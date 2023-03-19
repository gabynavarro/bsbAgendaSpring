package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Person;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class PersonRequest {
    @ApiModelProperty(name = "firstName",
            value = "firstName of the Person",
            dataType = "String",
            notes = "cannot be null contain special characters",
            example = "Gabriel",
            required = true)
    @NotBlank (message = "firstname cannot be empty or null")
    @NotEmpty (message = "firstname cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "firstname must contain only letters and spaces")
    @Size(min = 3, max =50,message = "The firstname must contain between 3-50 characters")
    private String firstName;

    @ApiModelProperty(name = "lastName",
            value = "lastName of the Person",
            dataType = "String",
            notes = "cannot be null contain special characters",
            example = "Navarro",
            required = true)
    @NotBlank (message = "lastname cannot be empty or null")
    @NotEmpty (message = "lastname cannot be empty or null")
    @Size(min = 3, max =50,message = "The lastname must contain between 3-50 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "lastname must contain only letters and spaces")
    private String lastName;

    @ApiModelProperty(name = "phoneLine",
            value = "phoneLine of the Person",
            dataType = "String",
            notes = "cannot be null contain special characters",
            example = "2615983473",
            required = true)
    @NotBlank (message = "phoneLine cannot be empty or null")
    @NotEmpty (message = "phoneLine cannot be empty or null")
    @Size(min = 3, max =30,message = "The phoneLine must contain between 3-30 characters")
    private String phoneLine;

    @ApiModelProperty(name = "cell phone",
            value = "cell phone of the Person",
            dataType = "String",
            example = "2615983473",
            required = false)
    private String cell;

    @ApiModelProperty(name = "zip code person",
            value = "zip code address of the Person",
            dataType = "String",
            example = "5531",
            required = false)
    private String zipCode;

    @ApiModelProperty(name = "Address code person",
            value = "Address of the Person",
            dataType = "String",
            example = "Rivadavia 857",
            required = true)
    @NotBlank (message = "address cannot be empty or null")
    @NotEmpty (message = "address cannot be empty or null")
    @Size(min = 3, max =30,message = "The address must contain between 3-30 characters")
    private String address;

    @ApiModelProperty(name = "province code person",
            value = "Address of the Person",
            notes = "province must contain only letters and spaces",
            dataType = "String",
            example = "Mendoza",
            required = true)
    @NotBlank (message = "province cannot be empty or null")
    @NotEmpty (message = "province cannot be empty or null")
    @Size(min = 3, max =70,message = "The province must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "province must contain only letters and spaces")
    private String province;

    @ApiModelProperty(name = "country de person",
            value = "Country of the Person",
            notes = "province must contain only letters and spaces",
            dataType = "String",
            example = "Argentina",
            required = true)
    @NotBlank (message = "country cannot be empty or null")
    @NotEmpty (message = "country cannot be empty or null")
    @Size(min = 3, max =70,message = "The country must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "country must contain only letters and spaces")
    private String country;

    @ApiModelProperty(name = "dni de person",
            value = "dni of the Person",
            notes = "province must contain only letters and spaces",
            dataType = "String",
            example = "06987632",
            required = true)
    @NotBlank (message = "dni cannot be empty or null")
    @NotEmpty (message = "dni cannot be empty or null")
    @Size(min = 7, max =13,message = "The dni must contain between 7-13 characters")
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
                .coutry(request.getCountry())
                .dni(request.getDni())
                .build();
    }

}
