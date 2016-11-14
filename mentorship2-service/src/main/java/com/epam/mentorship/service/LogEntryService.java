package com.epam.mentorship.service;

import com.epam.mentorship.model.mongo.LogEntry;

public interface LogEntryService {
    void logEntry(LogEntry logEntry);
}
