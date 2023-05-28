package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="update_details")
public class Update {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer updateId;
    private String updateDesc;
    private Timestamp time = Timestamp.from(Instant.from(Instant.now()));

    @JsonBackReference(value = "incident-update")
    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;

    @JsonBackReference(value = "user-update")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

