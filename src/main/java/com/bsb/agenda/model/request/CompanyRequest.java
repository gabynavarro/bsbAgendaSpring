package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Company;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @NotBlank(message = "nameCompany cannot be empty or null")
    @NotEmpty(message = "nameCompany cannot be empty or null")
    private String nameCompany;
    @NotBlank (message = "phoneLine cannot be empty or null")
    @NotEmpty (message = "phoneLine cannot be empty or null")
    @Size(min = 3, max =30,message = "The phoneLine must contain between 3-30 characters")
    private String phoneLine;
    private String zipCode;
    @NotBlank (message = "address cannot be empty or null")
    @NotEmpty (message = "address cannot be empty or null")
    @Size(min = 3, max =50,message = "The address must contain between 3-50 characters")
    private String address;
    @NotBlank (message = "province cannot be empty or null")
    @NotEmpty (message = "province cannot be empty or null")
    @Size(min = 3, max =70,message = "The province must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "province must contain only letters and spaces")
    private String province;
    @NotBlank (message = "coutry cannot be empty or null")
    @NotEmpty (message = "coutry cannot be empty or null")
    @Size(min = 3, max =70,message = "The coutry must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "coutry must contain only letters and spaces")
    private String coutry;
    @NotBlank (message = "cuit cannot be empty or null")
    @NotEmpty (message = "cuit cannot be empty or null")
    @Size(min = 11, max =13,message = "The cuit must contain between 11-13 characters")
    private String cuit;

    public static  Company toEnty(CompanyRequest request){
        return Company.builder()
                .nameCompany(request.getNameCompany())
                .phoneLine(request.getPhoneLine())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .province(request.getProvince())
                .coutry(request.getCoutry())
                .cuit(request.getCuit())
                .build();
    }
}
