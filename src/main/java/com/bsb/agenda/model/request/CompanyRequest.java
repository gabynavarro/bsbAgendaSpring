package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Company;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class CompanyRequest {
    private String nameCompny;
    private String address;

    public static  Company toEnty(CompanyRequest request){
        return Company.builder()
                .nameCompny(request.getNameCompny())
                .address(request.getAddress())
                .build();
    }
}
