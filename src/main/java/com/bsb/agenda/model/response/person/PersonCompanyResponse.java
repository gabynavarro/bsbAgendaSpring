package com.bsb.agenda.model.response.person;

import com.bsb.agenda.model.entity.Person;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonCompanyResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String cell;
    /* Data*/
    private String address;
    private String province;
    private String coutry;
    public static PersonCompanyResponse toReponse(Person enty) {
    return  PersonCompanyResponse.builder()
            .id(enty.getId())
            .firstName(enty.getFirstName())
            .lastName(enty.getLastName())
            .cell(enty.getCell())
            .address(enty.getAddress())
            .province(enty.getProvince())
            .coutry(enty.getCoutry())
            .build();
    }
}
