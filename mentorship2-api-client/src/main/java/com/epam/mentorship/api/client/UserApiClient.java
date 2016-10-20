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

	public User createUser(UserDto userDto) {
		User entity = dtoEntityConverter.convert(userDto);
		entity.setCreatedByUser(entity);
		entity.setLastModifiedByUser(entity);
		return userService.save(entity);
	}

	public User updateUser(Long id, UserDto userDto) {
		User user = userService.findById(id);
		if (user == null) {
			return null;
		}

		dtoEntityConverter.merge(user, userDto);
		return userService.update(user);
	}

	public void delete(User entity) {
		userService.delete(entity);
	}

	public void delete(Long id) {
		userService.delete(id);
	}

	public User findById(Long id) {
		return userService.findById(id);
	}

	public List<User> findUsers() {
		return userService.findUsers();
	}

}