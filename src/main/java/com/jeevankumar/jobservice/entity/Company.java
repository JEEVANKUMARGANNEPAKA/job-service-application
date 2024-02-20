package com.jeevankumar.jobservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    private List<Review> reviews;
}
