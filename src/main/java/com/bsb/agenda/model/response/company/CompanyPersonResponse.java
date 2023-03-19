package com.bsb.agenda.model.response.company;

import com.bsb.agenda.model.entity.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPersonResponse {
    private Long id;
    @ApiModelProperty(name = "name company",
            value = "name of the company",
            dataType = "String",
            example = "Aconcagua SRL")
    private String nameCompany;
    @ApiModelProperty(name = "cuit company",
            value = "cuit of the company",
            dataType = "String",
            example = "20362587411")
    private String cuit;
    /* Data*/
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

    public static CompanyPersonResponse toResponse(Company enty){
        return CompanyPersonResponse.builder()
                .id(enty.getId())
                .nameCompany(enty.getNameCompany())
                .cuit(enty.getCuit())
                .address(enty.getAddress())
                .province(enty.getProvince())
                .country(enty.getCountry())
                .build();
    }
}
