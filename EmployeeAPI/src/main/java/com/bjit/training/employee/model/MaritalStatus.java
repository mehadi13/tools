package com.bjit.training.employee.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the maritialstatus database table.
 * 
 */
@Entity
@Table(name = "maritalstatuses")
public class MaritalStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String status;

	public MaritalStatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}