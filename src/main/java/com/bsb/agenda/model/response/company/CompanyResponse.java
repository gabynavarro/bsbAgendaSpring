package com.bsb.agenda.model.response.company;

import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.response.person.PersonCompanyResponse;
import com.bsb.agenda.validation.CompanyValidator;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class CompanyResponse {
    private Long id;
    private String nameCompany;
    private String cuit;
    /* Data*/
    protected String zipCode;
    private String address;
    private String province;
    private String coutry;
    private Set<PersonCompanyResponse> people;
    public static  CompanyResponse toResponse(Company enty){
        return CompanyResponse.builder()
                .id(enty.getId())
                .nameCompany(enty.getNameCompany())
                .cuit(enty.getCuit())
                .zipCode(enty.getZipCode())
                .address(enty.getAddress())
                .province(enty.getProvince())
                .coutry(enty.getCoutry())

                .build();
    }
}
