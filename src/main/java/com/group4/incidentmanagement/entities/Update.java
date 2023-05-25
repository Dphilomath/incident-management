package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
//    @JoinColumn(name="incident_id")
    private Incident incident;
}

