package com.pearl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobile;

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    List<Address> addresses = new ArrayList<>();

}
