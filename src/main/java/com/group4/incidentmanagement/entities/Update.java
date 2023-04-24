package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue
    private Integer updateId;
    private String updateDesc;
    private Timestamp time = Timestamp.from(Instant.from(Instant.now()));

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="incident_id")
    private Incident incident;
}

