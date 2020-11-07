package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info", schema = "gilbert_p_renegado")
public class UserInfoEntity {

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
	
	@Override
	public String toString() {
		return "UserInfoEntity [id=" + id + ", fullName=" + fullName + ", givenName=" + givenName + ", familyName="
				+ familyName + ", email=" + email + ", imageUrl=" + imageUrl + "]";
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	

}
