package com.group4.incidentmanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Incident {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
    private enum Status{
        New,
        In_Progress,
        Resolved,
        Rejected
    }
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
}
