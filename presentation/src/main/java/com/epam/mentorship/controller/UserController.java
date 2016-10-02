package com.epam.mentorship.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.model.User;
import com.epam.mentorship.model.dto.ApiResponse;
import com.epam.mentorship.model.dto.UserDto;
import com.epam.mentorship.service.UserService;
import com.epam.mentorship.util.DtoEntityConverter;

@Controller
@RequestMapping(path = "/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	DtoEntityConverter dtoEntityConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<User>> createUser(@RequestBody @Valid UserDto userDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(null, bindingResult.getAllErrors()), HttpStatus.OK);
		}

		User entity = dtoEntityConverter.convert(userDto);
		return new ResponseEntity<>(new ApiResponse<>(userService.save(entity), null), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto userDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(null, bindingResult.getAllErrors()), HttpStatus.OK);
		}

		User entity = userService.findById(id);
		if (entity == null) {
			return new ResponseEntity<ApiResponse<User>>(HttpStatus.BAD_REQUEST);
		}
		entity = dtoEntityConverter.convert(userDto);
		entity.setId(id);
		return new ResponseEntity<ApiResponse<User>>(new ApiResponse<>(userService.update(entity), null),
				HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.findById(id));
		return "userProfile";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String findUsers(Model model) {
		model.addAttribute("users", userService.findUsers());
		return "users";
	}
}