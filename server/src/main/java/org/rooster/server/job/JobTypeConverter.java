package org.rooster.server.job;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class JobTypeConverter implements AttributeConverter<JobType, String> {

    @Override
    public String convertToDatabaseColumn(JobType category) {
        if (category == null) {
            return null;
        }
        return category.getType();
    }

    @Override
    public JobType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(JobType.values())
                .filter(j -> j.getType().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
