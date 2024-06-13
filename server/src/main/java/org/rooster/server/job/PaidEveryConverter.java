package org.rooster.server.job;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class PaidEveryConverter implements AttributeConverter<PaidEvery, String> {

    @Override
    public String convertToDatabaseColumn(PaidEvery paidEvery) {
        if (paidEvery == null) {
            return null;
        }
        return paidEvery.getDuration();
    }

    @Override
    public PaidEvery convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(PaidEvery.values())
                .filter(p -> p.getDuration().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
