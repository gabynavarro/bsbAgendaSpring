package com.bsb.agenda.service.abs;

import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.request.PersonRequest;
import com.bsb.agenda.model.response.person.PersonResponse;

public interface PersonService {
    PersonResponse addPerson(PersonRequest request) throws ErrorProcessException;
}
