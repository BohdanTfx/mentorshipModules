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

import com.epam.mentorship.api.facade.UserApiService;
import com.epam.mentorship.api.model.dto.ApiResponse;
import com.epam.mentorship.api.model.dto.UserDto;
import com.epam.mentorship.model.User;

@RestController
@RequestMapping(path = "/api/users")
public class UserController {
	@Autowired
	private UserApiService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ApiResponse<User> createUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ApiResponse<>(bindingResult.getAllErrors());
		}

		User user = userService.createUser(userDto);
		return new ApiResponse<>(user);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return new ApiResponse<>(bindingResult.getAllErrors());
		}

		User user = userService.updateUser(id, userDto);
		return new ApiResponse<>(user);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ApiResponse<User> findById(@PathVariable Long id) {
		return new ApiResponse<>(userService.findById(id));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ApiResponse<List<User>> findUsers(Model model) {
		return new ApiResponse<>(userService.findUsers());
	}
}