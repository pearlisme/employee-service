package com.pearl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Embeddable
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDR_ID")
    private Long id;
    private String street;
    private String city;
    private String country;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List tags = new ArrayList<>();

    @OneToMany
    @Builder.Default
    List<Location> locations = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "ADDR_ID",referencedColumnName = "EMP_ID",insertable = false,updatable = false)
//    private Employee employee;

}
