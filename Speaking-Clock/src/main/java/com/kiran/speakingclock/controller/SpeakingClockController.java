package com.kiran.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.speakingclock.constants.ClockConstants;
import com.kiran.speakingclock.service.SpeakingClockService;

@RestController
@RequestMapping(value =  ClockConstants.CLOCK_CONSTANTS)
public class SpeakingClockController {

	@Autowired
	SpeakingClockService speakingClockService;

	@GetMapping(value =  ClockConstants.CONVERT_TIME_TO_WORDS)
	public String convertTimeToWords(@PathVariable("time") String time) {
		try {

			String timeInWords = speakingClockService.convertToWords(time);

			return "It's " + timeInWords;
		} catch (NumberFormatException e) {
			return "Invalid time format";
		}
	}

}
