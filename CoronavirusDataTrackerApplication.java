package io.java.coronavirusdatatracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoronavirusDataTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronavirusDataTrackerApplication.class, args);
	}

}
