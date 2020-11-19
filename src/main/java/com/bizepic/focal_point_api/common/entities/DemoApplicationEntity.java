package com.bizepic.focal_point_api.common.entities;

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
@Table(name = "message", schema = "gilbert_p_renegado")
public class DemoApplicationEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "MESSAGE", nullable = false, length = 100)
    private String message;
}
