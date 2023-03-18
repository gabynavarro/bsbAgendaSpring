package com.bsb.agenda.model.response.person;

import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.response.company.CompanyPersonResponse;
import com.bsb.agenda.validation.PersonValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.el.util.Validation;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private Set<CompanyPersonResponse> company;

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
                .company(PersonValidator.validateCompanyInPerson(person.getCompanies()))
                .build();
    }

}
