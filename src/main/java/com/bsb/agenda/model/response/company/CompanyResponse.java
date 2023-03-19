package com.bsb.agenda.model.response.company;

import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.response.person.PersonCompanyResponse;
import com.bsb.agenda.validation.CompanyValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Set;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
@ApiModel(description = "Format for Response company")
public class CompanyResponse {
    private Long id;
    @ApiModelProperty(name = "name company",
            notes = "name of the company",
            dataType = "String",
            example = "Aconcagua SRL")
    private String nameCompany;
    @ApiModelProperty(name = "cuit company",
            notes = "cuit of the company",
            dataType = "String",
            example = "20362587411")
    private String cuit;
    /* Data*/
    @ApiModelProperty(name = "zipcode area person",
            notes = "zipcode area of the person",
            dataType = "String",
            example = "5531")
    private String zipCode;
    @ApiModelProperty(name = "address person",
            notes = "address of the person",
            dataType = "String",
            example = "Rivadavia 857")
    private String address;
    @ApiModelProperty(name = "state o province person",
            notes = "province of the person",
            dataType = "String",
            example = "Mendoza")
    private String province;
    @ApiModelProperty(name = "country person",
            notes = "country of the person",
            dataType = "String",
            example = "Argentina")
    private String country;
    /* Person Response*/
    private Set<PersonCompanyResponse> people;
    public static  CompanyResponse toResponse(Company enty){
        return CompanyResponse.builder()
                .id(enty.getId())
                .nameCompany(enty.getNameCompany())
                .cuit(enty.getCuit())
                .zipCode(enty.getZipCode())
                .address(enty.getAddress())
                .province(enty.getProvince())
                .country(enty.getCountry())
                .people(CompanyValidator.validateCompanyInPerson(enty.getPeople()))
                .build();
    }
}
