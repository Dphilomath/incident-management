package com.group4.incidentmanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer userId;
    private String userName;


    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "deptId")
    private Department department;


    @OneToMany(mappedBy = "user")
    private List<Incident> incidents;



}
