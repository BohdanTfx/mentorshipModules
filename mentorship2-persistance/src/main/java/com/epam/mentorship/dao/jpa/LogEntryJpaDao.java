package com.epam.mentorship.dao.jpa;

import org.springframework.stereotype.Repository;

import com.epam.mentorship.dao.LogEntryDao;
import com.epam.mentorship.model.LogEntry;

@Repository
public class LogEntryJpaDao extends GenericJpaDao<LogEntry, Long>
        implements LogEntryDao {
    private static final long serialVersionUID = 8890244863875003041L;

    public LogEntryJpaDao() {
        super(LogEntry.class);
    }

}
