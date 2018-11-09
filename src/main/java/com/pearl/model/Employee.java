package com.pearl.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "first-name")
    private String firstName;


    @JsonProperty(value = "last-name")
    private String lastName;


    @JsonProperty(value = "email")
    private String email;


    @JsonProperty(value = "mobile")
    private String mobile;

    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addresses;

}
