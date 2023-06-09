package com.group4.incidentmanagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dept_details")
public class Department {
    @Id
    @GeneratedValue
    private Integer deptId;
    @NotNull(message = "deptName must not be null")
    private String deptName;

    @JsonManagedReference(value = "user-dept")
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public Department(String deptName) {
        this.deptName = deptName;
    }
}
