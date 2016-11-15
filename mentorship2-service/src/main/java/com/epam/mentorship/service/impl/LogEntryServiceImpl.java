package com.epam.mentorship.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.LogEntryDao;
import com.epam.mentorship.model.mongo.LogEntry;
import com.epam.mentorship.service.LogEntryService;

@Service
public class LogEntryServiceImpl implements LogEntryService {

    @Autowired
    private LogEntryDao logEntryDao;
    @Autowired
    private CounterService counterService;

    @Override
    public void logEntry(final LogEntry logEntry) {
        logEntry.setId(Long.valueOf(counterService
                .getNextSequence(LogEntry.class.getSimpleName())));
        logEntry.setLogDate(new Date());
        logEntryDao.save(logEntry);
    }

    @Override
    public List<LogEntry> findAll() {
        return logEntryDao.findAll();
    }

    @Override
    public List<LogEntry> findByType(final String type) {
        return logEntryDao.findByType(type);
    }

}
