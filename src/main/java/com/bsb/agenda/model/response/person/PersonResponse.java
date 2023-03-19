package com.bsb.agenda.model.response.person;

import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.response.company.CompanyPersonResponse;
import com.bsb.agenda.validation.PersonValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;


@Getter @Setter @Builder
@AllArgsConstructor
public class PersonResponse {
    private Long id;
    @ApiModelProperty(name = "firstname person",
            value = "name of the person",
            dataType = "String",
            example = "Gabriel")
    private String firstName;
    @ApiModelProperty(name = "lastname person",
            value = "lastname of the person",
            dataType = "String",
            example = "Navarro")
    private String lastName;
    @ApiModelProperty(name = "dni or rut person",
            value = "dni of the person",
            dataType = "String",
            example = "06898964")
    private String dni;
    @ApiModelProperty(name = "cell phone person",
            value = "cell phone of the person",
            dataType = "String",
            example = "2615983473")
    private String cell;

    /* Data*/
    @ApiModelProperty(name = "PhoneLine area person",
            value = "Phone line area of the person",
            dataType = "String",
            example = "2614921040")
    private String phoneLine;
    @ApiModelProperty(name = "zipcode area person",
            value = "zipcode area of the person",
            dataType = "String",
            example = "5531")
    private String zipCode;
    @ApiModelProperty(name = "address person",
            value = "address of the person",
            dataType = "String",
            example = "Rivadavia 857")
    private String address;
    @ApiModelProperty(name = "state o province person",
            value = "province of the person",
            dataType = "String",
            example = "Mendoza")
    private String province;
    @ApiModelProperty(name = "country person",
            value = "country of the person",
            dataType = "String",
            example = "Argentina")
    private String country;
    /* Company Response*/
    private Set<CompanyPersonResponse> company;

    public static  PersonResponse toResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .dni(person.getDni())
                .cell(person.getCell())
                .phoneLine(person.getPhoneLine())
                .zipCode(person.getZipCode())
                .address(person.getAddress())
                .province(person.getProvince())
                .country(person.getCountry())
                .company(PersonValidator.validateCompanyInPerson(person.getCompanies()))
                .build();
    }

}
