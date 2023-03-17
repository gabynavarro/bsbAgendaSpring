package com.bsb.agenda.model.response.person;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonCampanyResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String cell;
    /* Data*/
    private String address;
    private String province;
    private String coutry;
}
