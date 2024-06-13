package org.rooster.server.job;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.stream.Stream;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job {
    @Id
    @GeneratedValue
    private Long id;
    private String logo;
    private String title;
    private String companyName;
    private String classification;
    private String subClassification;
    private JobType type;
    private String location;

    @OneToOne
    @Cascade(value = CascadeType.ALL)
    private Salary salary;
    private Date postedDate;
    private String companyUrl;
}

