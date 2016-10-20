package com.epam.mentorship.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.api.client.UserApiClient;
import com.epam.mentorship.api.model.dto.UserDto;
import com.epam.mentorship.model.User;

@Controller
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserApiClient userApiClient;

	@RequestMapping(method = RequestMethod.POST)
	public String createUser(@RequestBody @Valid UserDto userDto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "userProfile";
		}

		User user = userApiClient.createUser(userDto);
		model.addAttribute("user", user);
		return "userProfile";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.POST)
	public String updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "userProfile";
		}

		User user = userApiClient.updateUser(id, userDto);
		model.addAttribute("user", user);
		return "userProfile";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("user", userApiClient.findById(id));
		return "userProfile";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String findUsers(Model model) {
		model.addAttribute("users", userApiClient.findUsers());
		return "users";
	}
}