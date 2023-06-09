package com.bsb.agenda.service.abs;

import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.request.PersonRequest;
import com.bsb.agenda.model.response.person.PersonResponse;

import java.util.List;

public interface PersonService {
    PersonResponse addPerson(PersonRequest request) throws ErrorProcessException;
    List<PersonResponse> getAll(String search) throws ErrorProcessException;
    List<PersonResponse> findAll() throws ErrorProcessException;
    PersonResponse findById(Long id) throws ErrorProcessException;
    PersonResponse addCompanyToPerson(Long person, Long company) throws ErrorProcessException;

}
