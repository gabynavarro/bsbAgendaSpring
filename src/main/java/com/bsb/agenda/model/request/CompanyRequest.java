package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Company;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @ApiModelProperty(name = "Name Company",
            value = "nameCompany of the Company",
            dataType = "String",
            notes = "nameCompany cannot be empty or null",
            example = "Aconcagua SRL",
            required = true)
    @NotBlank(message = "nameCompany cannot be empty or null")
    @NotEmpty(message = "nameCompany cannot be empty or null")
    private String nameCompany;
    @ApiModelProperty(name = "Phone line Company",
            value = "phone of the Company",
            dataType = "String",
            notes = "PhoneLine cannot be empty or null",
            example = "2615983473",
            required = true)
    @NotBlank (message = "phoneLine cannot be empty or null")
    @NotEmpty (message = "phoneLine cannot be empty or null")
    @Size(min = 3, max =30,message = "The phoneLine must contain between 3-30 characters")
    private String phoneLine;

    @ApiModelProperty(name = "zip code company",
            value = "zip code address of the company",
            dataType = "String",
            example = "5531",
            required = false)
    private String zipCode;


    @ApiModelProperty(name = "Address code company",
            value = "Address of the company",
            dataType = "String",
            example = "Rivadavia 857",
            required = true)
    @NotBlank (message = "address cannot be empty or null")
    @NotEmpty (message = "address cannot be empty or null")
    @Size(min = 3, max =30,message = "The address must contain between 3-30 characters")
    private String address;

    @ApiModelProperty(name = "province code company",
            value = "Province of the company",
            notes = "province must contain only letters and spaces",
            dataType = "String",
            example = "Mendoza",
            required = true)
    @NotBlank (message = "province cannot be empty or null")
    @NotEmpty (message = "province cannot be empty or null")
    @Size(min = 3, max =70,message = "The province must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "province must contain only letters and spaces")
    private String province;

    @ApiModelProperty(name = "country de company",
            value = "Country of the company",
            notes = "country must contain only letters and spaces",
            dataType = "String",
            example = "Argentina",
            required = true)
    @NotBlank (message = "country cannot be empty or null")
    @NotEmpty (message = "country cannot be empty or null")
    @Size(min = 3, max =70,message = "The country must contain between 3-70 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "country must contain only letters and spaces")
    private String country;

    @ApiModelProperty(name = "cuit de company",
            value = "Cuit of the company",
            notes = "cuit must contain only letters and spaces",
            dataType = "String",
            example = "20369875241",
            required = true)
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
                .coutry(request.getCountry())
                .cuit(request.getCuit())
                .build();
    }
}
