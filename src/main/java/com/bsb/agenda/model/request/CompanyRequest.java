package com.bsb.agenda.model.request;

import com.bsb.agenda.model.entity.Company;
import lombok.*;


@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String nameCompny;
    private String phoneLine;
    private String zipCode;
    private String address;
    private String province;
    private String coutry;
    private String cuit;

    public static  Company toEnty(CompanyRequest request){
        return Company.builder()
                .nameCompny(request.getNameCompny())
                .phoneLine(request.getPhoneLine())
                .zipCode(request.getZipCode())
                .address(request.getAddress())
                .province(request.getProvince())
                .coutry(request.getCoutry())
                .cuit(request.getCuit())
                .build();
    }
}
