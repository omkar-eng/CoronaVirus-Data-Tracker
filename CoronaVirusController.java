package io.java.coronavirusdatatracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.java.coronavirusdatatracker.models.DataModel;
import io.java.coronavirusdatatracker.services.CoronaVirusService;

@Controller
public class CoronaVirusController {
	
	@Autowired
	CoronaVirusService coronaVirusService;
	
	@GetMapping("/")
	public String home(Model model)
	{
		List<DataModel> allStat=coronaVirusService.getAllData();
		model.addAttribute("locationStat",allStat);
		int totalCase=allStat.stream().mapToInt(stat -> stat.getLatestTotalCase()).sum();
		int totalPreCase=allStat.stream().mapToInt(stat -> stat.getPreTotalCase()).sum();
		int diffCase=totalCase-totalPreCase;
		model.addAttribute("sumStat", totalCase);
		model.addAttribute("newlyCase", diffCase);
		return "home";
	}

}
