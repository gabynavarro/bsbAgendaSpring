package com.bsb.agenda.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@PrimaryKeyJoinColumn(name = "data_id")
public class Person extends Data{
    @Column(length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(unique = true, length = 13)
    private String dni;
    @Column(length = 30)
    private String cell;

    /* TODO:Relations*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "people")
    private Set<Company> companies = new HashSet<>();
    public void addCompany(Company point){
        companies.add(point);
    }
    @Builder
    public Person(Long id, String phoneLine, String zipCode, String address, String province, String coutry, String firstName, String lastName,String dni, String cell) {
        super(id, phoneLine, zipCode, address, province, coutry);
        this.firstName=firstName;
        this.lastName=lastName;
        this.dni=dni;
        this.cell=cell;
    }
}
