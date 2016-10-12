package com.epam.mentorship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.mentorship.service.ParticipantService;

@Controller
@RequestMapping(path = "/api/mentorship/participants")
public class ParticipantController {
	@Autowired
	private ParticipantService participantService; 
}
