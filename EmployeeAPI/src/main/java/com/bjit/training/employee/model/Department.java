package com.bjit.training.employee.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the departments database table.
 * 
 */
@Entity
@Table(name = "departments")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	public Department() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}