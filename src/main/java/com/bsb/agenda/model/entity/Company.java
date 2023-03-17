package com.bsb.agenda.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "data_id")
public class Company extends Data {
    @Column(length = 50)
    private String nameCompny;
    @Column(unique = true)
    private String cuit;

    /* TODO: Relations */
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "person_company",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    Set<Person> people = new HashSet<>();
    @Builder
    public Company(Long id, String phoneLine, String zipCode, String address, String province, String coutry, String nameCompny, String cuit) {
        super(id, phoneLine, zipCode, address, province, coutry);
        this.nameCompny=nameCompny;
        this.cuit=cuit;
    }

}
