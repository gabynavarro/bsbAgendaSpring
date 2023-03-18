package com.bsb.agenda.model.response.company;

import com.bsb.agenda.model.entity.Company;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyPersonResponse {
    private Long id;
    private String nameCompany;
    private String cuit;
    /* Data*/
    private String address;
    private String province;
    private String coutry;
    public static CompanyPersonResponse toResponse(Company enty){
        return CompanyPersonResponse.builder()
                .id(enty.getId())
                .nameCompany(enty.getNameCompany())
                .cuit(enty.getCuit())
                .address(enty.getAddress())
                .province(enty.getProvince())
                .coutry(enty.getCoutry())
                .build();
    }
}
