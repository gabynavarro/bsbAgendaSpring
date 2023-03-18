package com.bsb.agenda.service.abs;

import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.request.CompanyRequest;
import com.bsb.agenda.model.response.company.CompanyResponse;
import com.bsb.agenda.model.response.person.PersonResponse;

import java.util.List;

public interface CompanyService {
    CompanyResponse addCompany(CompanyRequest request) throws ErrorProcessException;
    List<CompanyResponse> getAll(String search) throws ErrorProcessException;
    List<CompanyResponse> searchAll() throws ErrorProcessException;
    CompanyResponse findById(Long id) throws ErrorProcessException;
    CompanyResponse addPersonToCompany(Long person, Long company) throws ErrorProcessException;
}
