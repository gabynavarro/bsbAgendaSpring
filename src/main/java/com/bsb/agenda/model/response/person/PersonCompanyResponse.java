package com.bsb.agenda.model.response.person;

import com.bsb.agenda.model.entity.Person;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonCompanyResponse {
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
    @ApiModelProperty(name = "cell phone person",
            value = "cell phone of the person",
            dataType = "String",
            example = "2615983473")
    private String cell;
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
    public static PersonCompanyResponse toReponse(Person enty) {
    return  PersonCompanyResponse.builder()
            .id(enty.getId())
            .firstName(enty.getFirstName())
            .lastName(enty.getLastName())
            .cell(enty.getCell())
            .address(enty.getAddress())
            .province(enty.getProvince())
            .country(enty.getCountry())
            .build();
    }
}
