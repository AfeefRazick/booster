package org.rooster.server.job;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum JobType {
    FULL_TIME("Full-Time"),
    PART_TIME("Part-Time"),
    CASUAL("Casual"),
    INTERNSHIP("Internship"),
    CONTRACT("Contract");
    private final String type;

    JobType(String type) {
        this.type = type;
    }
}

