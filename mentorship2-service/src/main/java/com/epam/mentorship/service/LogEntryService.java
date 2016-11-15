package com.epam.mentorship.service;

import java.util.List;

import com.epam.mentorship.model.mongo.LogEntry;

public interface LogEntryService {
    void logEntry(LogEntry logEntry);

    List<LogEntry> findAll();

    List<LogEntry> findByType(String type);
}
