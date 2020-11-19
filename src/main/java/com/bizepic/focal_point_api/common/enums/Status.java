package com.bizepic.focal_point_api.common.enums;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public enum Status {

	ACTIVE(1001, "Active"), 
	INACTIVE(1002, "Inactive");

	private final Integer key;
	private final String value;

	Status(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	public Integer getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}
