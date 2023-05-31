package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incident_details")
@ToString
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "incident_id")
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Enums.Priority priority;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Enums.Status status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Enums.Category category;
    @NotNull
    @JsonBackReference(value = "user-incident")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;


    public Incident(String name, Enums.Priority priority, Enums.Status status, Enums.Category category, User user) {
        this.name = name;
        this.priority = priority;
        this.category = category;
        this.status = status;
        this.user = user;
    }

    @JsonManagedReference(value = "incident-update")
    @OneToMany(mappedBy = "incident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Update> updates = new ArrayList<>();
}
