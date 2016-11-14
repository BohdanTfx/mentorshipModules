package com.epam.mentorship.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.epam.mentorship.model.mongo.LogEntry;

public interface LogEntryDao extends MongoRepository<LogEntry, Long> {

}
