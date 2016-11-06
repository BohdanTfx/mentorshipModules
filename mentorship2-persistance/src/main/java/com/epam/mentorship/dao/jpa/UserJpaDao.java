package com.epam.mentorship.dao.jpa;

import org.springframework.stereotype.Repository;

import com.epam.mentorship.dao.UserDao;
import com.epam.mentorship.model.User;

@Repository
public class UserJpaDao extends GenericJpaDao<User, Long> implements UserDao {
    private static final long serialVersionUID = 2406387785183079071L;

    public UserJpaDao() {
        super(User.class);
    }

}
