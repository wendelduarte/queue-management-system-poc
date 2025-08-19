package com.queue.system.database.entity;

import com.queue.system.core.domain.UserDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	
	public UserEntity(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public UserDomain toDomain() {
		return new UserDomain(id, name, age);
	}
}