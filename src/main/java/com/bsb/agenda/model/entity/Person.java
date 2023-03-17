package com.bsb.agenda.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name = "people")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(length = 30)
    private String phone;
    @Column(unique = true, length = 13)
    private String dni;
    private String address;
    /* TODO:Relations*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "people")
    private Set<Company> companies = new HashSet<>();

}
