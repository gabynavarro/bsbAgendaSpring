package com.bsb.agenda.model.response.person;

import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.response.company.CompanyPersonResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
@AllArgsConstructor
public class PersonResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String cell;
    /* Data*/
    protected String zipCode;
    private String address;
    private String province;
    private String coutry;
    /* Company Response*/
    private CompanyPersonResponse company;

    public static  PersonResponse toResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .dni(person.getDni())
                .cell(person.getCell())
                .zipCode(person.getZipCode())
                .address(person.getAddress())
                .province(person.getProvince())
                .coutry(person.getCoutry())
                //falta relacion
                .build();
    }

}
