package com.epam.mentorship.dao.jpa;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.epam.mentorship.dao.UserDao;
import com.epam.mentorship.model.JobTitle;
import com.epam.mentorship.model.User;

@Repository
public class UserJpaDao extends GenericJpaDao<User, Long> implements UserDao {
	private static final long serialVersionUID = 2406387785183079071L;

	@PostConstruct
	public void init() {
		User user = new User();
		user.setId(50L);
		user.setDateOfBirth(new Date());
		user.setFirstName("Olegator");
		user.setLastName("None");
		user.setJobTitle(JobTitle.JUNIOR);
		save(user);
		
		User user1 = new User();
		user1.setId(20L);
		user1.setDateOfBirth(new Date());
		user1.setFirstName("Ahmat");
		user1.setLastName("Tea");
		user1.setJobTitle(JobTitle.SENIOR);
		save(user1);
		
		User user2 = new User();
		user2.setId(111L);
		user2.setDateOfBirth(new Date());
		user2.setFirstName("Jon");
		user2.setLastName("Snow");
		user2.setJobTitle(JobTitle.CHIEF);
		save(user2);
	}
}