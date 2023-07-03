package com.Guddu.Job_Serach_Portal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    private Long id;
    private String title;
    private String discription;
    private String location;

    @Min(value = 20000)
    private double salary;

    @Email
    private String companyEmail;
    private String companyName;
    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobtype;
}
