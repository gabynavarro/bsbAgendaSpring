package com.bsb.agenda.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Model Person")
public class Person extends Data{
    @ApiModelProperty("Person firstname")
    @Column(length = 50)
    private String firstName;
    @ApiModelProperty("Person lastname")
    @Column(nullable = false, length = 50)
    private String lastName;
    @ApiModelProperty("Person dni or cedule")
    @Column(unique = true, length = 13)
    private String dni;
    @ApiModelProperty("Person phone line or cellphone")
    @Column(length = 30)
    private String cell;

    /* TODO:Relations*/
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "people")
    private Set<Company> companies = new HashSet<>();
    public void addCompany(Company point){
        companies.add(point);
    }
    @Builder
    public Person(Long id, String phoneLine, String zipCode, String address, String province, String country, String firstName, String lastName,String dni, String cell) {
        super(id, phoneLine, zipCode, address, province, country);
        this.firstName=firstName;
        this.lastName=lastName;
        this.dni=dni;
        this.cell=cell;
    }
}
