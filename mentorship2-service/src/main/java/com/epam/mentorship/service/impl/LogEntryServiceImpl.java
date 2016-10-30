package com.epam.mentorship.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.LogEntryDao;
import com.epam.mentorship.model.LogEntry;
import com.epam.mentorship.service.LogEntryService;

@Service
public class LogEntryServiceImpl implements LogEntryService {

    @Autowired
    private LogEntryDao logEntryDao;

    @Override
    public void logEntry(final LogEntry logEntry) {
        logEntryDao.save(logEntry);
    }

}
