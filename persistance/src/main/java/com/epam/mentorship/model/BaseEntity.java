package com.epam.mentorship.model;


public class BaseEntity<ID> {
	protected ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
}
