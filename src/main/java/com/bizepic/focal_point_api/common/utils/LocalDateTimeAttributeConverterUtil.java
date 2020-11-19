package com.bizepic.focal_point_api.common.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;

/**
 * 
 * @author Gilbert Renegado
 *
 */
public class LocalDateTimeAttributeConverterUtil implements AttributeConverter<LocalDateTime, Timestamp> {

	@Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
    }
 
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    }
}
