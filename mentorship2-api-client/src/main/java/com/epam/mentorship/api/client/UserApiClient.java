package com.epam.mentorship.api.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentorship.api.client.annotation.ApiClient;
import com.epam.mentorship.api.model.dto.UserDto;
import com.epam.mentorship.api.util.DtoEntityConverter;
import com.epam.mentorship.model.User;
import com.epam.mentorship.service.UserService;

@ApiClient
public class UserApiClient {
    @Autowired
    private UserService userService;
    @Autowired
    private DtoEntityConverter dtoEntityConverter;

    public User createUser(final UserDto userDto) {
        throw new RuntimeException("Some msg");
        // User entity = dtoEntityConverter.convert(userDto);
        // entity.setCreatedByUser(entity);
        // entity.setLastModifiedByUser(entity);
        // return userService.save(entity);
    }

    public User updateUser(final Long id, final UserDto userDto) {
        User user = userService.findById(id);
        if (user == null) {
            return null;
        }

        dtoEntityConverter.merge(user, userDto);
        return userService.update(user);
    }

    public void delete(final User entity) {
        userService.delete(entity);
    }

    public void delete(final Long id) {
        userService.delete(id);
    }

    public User findById(final Long id) {
        return userService.findById(id);
    }

    public List<User> findUsers() {
        return userService.findUsers();
    }

}
