package com.epam.mentorship.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.mentorship.api.client.UserApiClient;
import com.epam.mentorship.api.model.dto.ApiResponse;
import com.epam.mentorship.api.model.dto.UserDto;
import com.epam.mentorship.model.User;

@RestController
@RequestMapping(
        path = "/api/users")
public class UserController {
    @Autowired
    private UserApiClient userApiClient;

    @RequestMapping(
            method = RequestMethod.POST)
    public ApiResponse<User> createUser(
            @RequestBody @Valid final UserDto userDto,
            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ApiResponse<>(bindingResult.getAllErrors());
        }

        User user = userApiClient.createUser(userDto);
        return new ApiResponse<>(user);
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.PUT)
    public ApiResponse<User> updateUser(@PathVariable final Long id,
            @RequestBody @Valid final UserDto userDto,
            final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            return new ApiResponse<>(bindingResult.getAllErrors());
        }

        User user = userApiClient.updateUser(id, userDto);
        return new ApiResponse<>(user);
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.GET)
    public ApiResponse<User> findById(@PathVariable final Long id) {
        return new ApiResponse<>(userApiClient.findById(id));
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.DELETE)
    public ApiResponse<User> deleteById(@PathVariable final Long id) {
        userApiClient.delete(id);
        return new ApiResponse<>(null);
    }

    @RequestMapping(
            method = RequestMethod.GET)
    public ApiResponse<List<User>> findUsers(final Model model) {
        return new ApiResponse<>(userApiClient.findUsers());
    }
}
