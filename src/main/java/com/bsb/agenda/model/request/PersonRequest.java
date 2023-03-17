package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class PersonRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String dni;
    private String address;
    public static Person toEnty(PersonRequest request){
        return  Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .dni(request.getDni())
                .address(request.getAddress())
                .build();
    }

}
