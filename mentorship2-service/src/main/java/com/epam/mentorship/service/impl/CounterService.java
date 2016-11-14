package com.epam.mentorship.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.epam.mentorship.model.mongo.Counter;

@Service
public class CounterService {
    @Autowired
    private MongoOperations mongo;

    public int getNextSequence(final String collectionName) {
        Counter counter = mongo.findAndModify(
                Query.query(Criteria.where("_id").is(collectionName)),
                new Update().inc("seq", 1),
                FindAndModifyOptions.options().returnNew(true), Counter.class);

        return counter.getSeq();
    }
}
