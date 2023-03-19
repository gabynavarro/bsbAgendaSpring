package com.bsb.agenda.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Model Company")
public class Company extends Data {
    @ApiModelProperty("Company name or trade name")
    @Column(length = 50)
    private String nameCompany;
    @ApiModelProperty("Company cuit or rut")
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

    public void addPerson(Person point){
        people.add(point);
    }
    @Builder
    public Company(Long id, String phoneLine, String zipCode, String address, String province, String country, String nameCompany, String cuit) {
        super(id, phoneLine, zipCode, address, province, country);
        this.nameCompany=nameCompany;
        this.cuit=cuit;
    }

}
