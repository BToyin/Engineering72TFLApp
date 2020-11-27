package com.sparta.eng72.journeyplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JourneyController {

    private JourneyService journeyService;
    private StationService stationService;

    @Autowired
    public JourneyController(JourneyService journeyService, StationService stationService) {
        this.journeyService = journeyService;
        this.stationService = stationService;
    }

    @GetMapping("/")
    public String getStations(ModelMap modelMap){
        List<Station> stations = stationService.getAllStations();
        modelMap.addAttribute("stations", stations);
        return "index";
    }

    @PostMapping("/journey")
    public String getJourney(ModelMap modelMap, @RequestParam(value = "from") String from, @RequestParam(value = "to") String to){
        Journey journey = journeyService.getJourney(from,to);
        modelMap.addAttribute("journey", journey);
        return "/";
    }

}
