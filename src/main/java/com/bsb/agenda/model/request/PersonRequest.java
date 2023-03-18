package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Person;
import lombok.*;

import javax.validation.constraints.*;


@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class PersonRequest {
    @NotBlank (message = "firstname cannot be empty or null")
    @NotEmpty (message = "firstname cannot be empty or null")
    @Size(min = 3, max =50,message = "The firstname must contain between 3-50 characters")
    private String firstName;
    @NotBlank (message = "lastname cannot be empty or null")
    @NotEmpty (message = "lastname cannot be empty or null")
    @Size(min = 3, max =50,message = "The lastname must contain between 3-50 characters")
    private String lastName;
    @NotBlank (message = "phoneLine cannot be empty or null")
    @NotEmpty (message = "phoneLine cannot be empty or null")
    @Size(min = 3, max =30,message = "The phoneLine must contain between 3-30 characters")
    private String phoneLine;
    private String cell;
    private String zipCode;
    private String address;
    @NotBlank (message = "province cannot be empty or null")
    @NotEmpty (message = "province cannot be empty or null")
    @Size(min = 3, max =70,message = "The province must contain between 3-70 characters")
    private String province;
    @NotBlank (message = "coutry cannot be empty or null")
    @NotEmpty (message = "coutry cannot be empty or null")
    @Size(min = 3, max =70,message = "The coutry must contain between 3-70 characters")
    private String coutry;
    @NotBlank (message = "dni cannot be empty or null")
    @NotEmpty (message = "dni cannot be empty or null")
    @Size(min = 3, max =13,message = "The dni must contain between 3-13 characters")
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
