package com.epam.mentorship.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.UserDao;
import com.epam.mentorship.model.User;
import com.epam.mentorship.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User save(final User entity) {
        return userDao.save(entity);
    }

    @Override
    public User update(final User entity) {
        return userDao.update(entity);
    }

    @Override
    public void delete(final User user) {
        userDao.delete(user);
    }

    @Override
    public void delete(final Long id) {
        userDao.delete(userDao.getById(id));
    }

    @Override
    public User findById(final Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> findUsers() {
        return userDao.getAll();
    }

}
