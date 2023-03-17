package com.bsb.agenda.model.response;

import com.bsb.agenda.model.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CompanyResponse {
    private Long id;
    private String nameCompny;
    private String address;
    public static  CompanyResponse toResponse(Company enty){
        return CompanyResponse.builder()
                .id(enty.getId())
                .nameCompny(enty.getNameCompny())
                .address(enty.getAddress())
                .build();
    }
}
