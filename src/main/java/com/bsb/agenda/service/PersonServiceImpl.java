package com.bsb.agenda.service;

import com.bsb.agenda.exception.BadRequestException;
import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.request.PersonRequest;
import com.bsb.agenda.model.response.person.PersonResponse;
import com.bsb.agenda.repository.PersonRepository;
import com.bsb.agenda.service.abs.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.bsb.agenda.validation.PersonValidator.validatePerson;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Override
    public PersonResponse addPerson(PersonRequest request) throws ErrorProcessException {
        try {
            return PersonResponse.toResponse(personRepository.save(PersonRequest.toEnty(request)));
        }catch (RuntimeException e){
            throw new ErrorProcessException("error en el proceso");
        }
    }
}
