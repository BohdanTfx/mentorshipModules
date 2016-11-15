package com.epam.mentorship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.model.mongo.LogEntry;
import com.epam.mentorship.service.LogEntryService;

@Controller
@RequestMapping(
        path = "/logs")
public class LogsController {
    @Autowired
    private LogEntryService logEntryService;

    @RequestMapping(
            method = RequestMethod.GET)
    public String findLogs(@RequestParam(
            required = false) final String type, final Model model) {
        List<LogEntry> result = type == null ? logEntryService.findAll()
                : logEntryService.findByType(type);
        model.addAttribute("logs", result);
        return "logs";
    }
}
