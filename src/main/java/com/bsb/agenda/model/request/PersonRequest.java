package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Person;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter @Builder
public class PersonRequest {

    private String firstName;
    private String lastName;
    private String phoneLine;
    private String cell;
    private String zipCode;
    private String address;
    private String province;
    private String coutry;
    private String dni;


    public static Person toEnty(PersonRequest request){
        return  Person.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneLine(request.getPhoneLine())
                .cell(request.getCell())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .province(request.getProvince())
                .coutry(request.getCoutry())
                .dni(request.getDni())
                .build();
    }

}
