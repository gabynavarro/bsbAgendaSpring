package com.bsb.agenda.model.response;

import com.bsb.agenda.model.entity.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class PersonResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String dni;
    private String address;

    public static  PersonResponse toResponse(Person person){
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .phone(person.getPhone())
                .dni(person.getDni())
                .address(person.getAddress())
                .build();
    }

}
