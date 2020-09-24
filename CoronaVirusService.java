package io.java.coronavirusdatatracker.services;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.java.coronavirusdatatracker.models.DataModel;

@Service
public class CoronaVirusService {
	
	private String url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	private List<DataModel> allData=new ArrayList<>();
	
	
	public List<DataModel> getAllData() {
		return allData;
	}

	@PostConstruct
	@Scheduled(cron = " * * 1 * * *")
	public void fetchData() throws IOException, InterruptedException
	{
		List<DataModel> newData=new ArrayList<>();
		HttpClient client=HttpClient.newHttpClient();
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(url)).build();
		HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
		StringReader reader=new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
		for (CSVRecord record : records) {
			DataModel dataModel=new DataModel();
			dataModel.setState(record.get("Province/State"));
			dataModel.setCountry(record.get("Country/Region"));
			dataModel.setLatestTotalCase(Integer.parseInt(record.get(record.size()-1)));
			dataModel.setPreTotalCase(Integer.parseInt(record.get(record.size()-2)));
		    newData.add(dataModel);
			//System.out.println(newData);
		}
		this.allData=newData;
		
		
	}

}
