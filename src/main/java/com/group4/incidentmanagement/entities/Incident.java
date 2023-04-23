package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incident_details")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "incident_id")
    private Integer id;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    private enum Priority{
        Critical,
        High,
        Medium,
        Low
    }

    private enum Status {
        New,
        In_Progress,
        Resolved,
        Rejected
    }

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
