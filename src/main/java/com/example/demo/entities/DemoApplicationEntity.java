package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message", schema = "gilbert_p_renegado")
public class DemoApplicationEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "MESSAGE", nullable = false, length = 100)
    private String message;
	
	

	@Override
	public String toString() {
		return "DemoApplicationEntity ["
				+ "id=" + id 
				+ ", message=" + message 
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
	
	
}
