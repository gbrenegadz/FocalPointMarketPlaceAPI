package com.example.demo.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author Gilbert Renegado
 *
 */
@Entity
@Data
@Table(name = "user_info", schema = "gilbert_p_renegado")
public class UserInfoEntity {
	
	public static final String ID = "id";

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "FULL_NAME", nullable = false, length = 100)
    private String fullName;
	
	@Column(name = "GIVEN_NAME", nullable = false, length = 100)
    private String givenName;
	
	@Column(name = "FAMILY_NAME", nullable = false, length = 100)
    private String familyName;
	
	@Column(name = "EMAIL", nullable = false, length = 50)
    private String email;
	
	@Column(name = "IMAGE_URL", nullable = false, length = 500)
    private String imageUrl;
	
	@Column(name = "IS_ACTIVE", nullable = false)
    private Integer isActive;
	
	@Column(name = "CREATED_DATETIME", nullable = false)
    private Timestamp createdDatetime;
	
	@Column(name = "MODIFIED_DATETIME", nullable = false)
    private Timestamp modifiedDatetime;
}
