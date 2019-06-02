package com.example.Information.entities;

import com.example.Information.constants.AuthorityName;
import com.example.Information.models.PersonModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Person implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	private String name;

	@NotNull
	private String lastname;

	@NotNull
	@Min(1)
	private int age;

	@NotNull
	private String birthPlace;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private Person father;

	@OneToMany(mappedBy = "father" )
	private Set<Person> sons;

	@ManyToMany
	private List<Authority> authorities;

	@NotNull
	private String password;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Set<Person> getSons() {
		return sons;
	}

	public void setSons(Set<Person> sons) {
		this.sons = sons;
	}

	public void addSon(Person son){
		sons.add(son);
	}
	public void deleteSon(Person son){
		sons.remove(son);
	}

	public boolean wasOnLinage(Person person) {
		boolean var =sons.stream().anyMatch(p -> p.id == person.getId());

		return sons.stream().anyMatch(person1 -> person1.wasOnLinage(person));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities.stream()
						  .map(Authority::getName)
						  .map(AuthorityName::name)
						  .map(SimpleGrantedAuthority::new)
						  .collect(Collectors.toList());	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
