package com.example.Information.entities;


import com.example.Information.constants.AuthorityName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private AuthorityName name;

	@ManyToMany(mappedBy = "authorities")
	private List<Person> users;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AuthorityName getName() {
		return name;
	}

	public void setName(AuthorityName name) {
		this.name = name;
	}

	public List<Person> getUsers() {
		return users;
	}

	public void setUsers(List<Person> users) {
		this.users = users;
	}
}
