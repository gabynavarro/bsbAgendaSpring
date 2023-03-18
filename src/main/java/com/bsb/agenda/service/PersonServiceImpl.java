package com.bsb.agenda.service;

import com.bsb.agenda.exception.BadRequestException;
import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.exception.NotFoundException;
import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.request.PersonRequest;
import com.bsb.agenda.model.response.person.PersonResponse;
import com.bsb.agenda.repository.CompanyRepository;
import com.bsb.agenda.repository.PersonRepository;
import com.bsb.agenda.service.abs.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final String ERROR_NOT_FOUND = "An error occurred in the process: ";
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public PersonResponse addPerson(PersonRequest request) throws ErrorProcessException {
        Person person = personRepository.findByDni(request.getDni());
        if (person != null) {
            throw new BadRequestException("Existing person");
        }
        try {
            return PersonResponse.toResponse(personRepository.save(PersonRequest.toEnty(request)));
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    public List<PersonResponse> getAll(String search) throws ErrorProcessException {
        Specification<Person> specification = PersonRepository.lastNameOrPhoneOrProvinceOrDniOrCountryContains(search);
        try {
            return personRepository.findAll(specification).stream()
                    .map(PersonResponse::toResponse)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }

    }

    @Override
    public List<PersonResponse> findAll() throws ErrorProcessException {
        try {
            return personRepository.findAll().stream()
                    .map(PersonResponse::toResponse)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    public PersonResponse findById(Long id) throws ErrorProcessException {
        Person p = personRepository.findById(id).orElseThrow(() -> new NotFoundException("the person's id was not found in the database"));
        try {
            return PersonResponse.toResponse(p);
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    @Transactional
    public PersonResponse addCompanyToPerson(Long person, Long company) throws ErrorProcessException {
        Person p = personRepository.findById(person).orElseThrow(() -> new BadRequestException("Person not found"));
        Company c = companyRepository.findById(company).orElseThrow(() -> new BadRequestException("Company not foud"));
        try {
            c.addPerson(p);
            p.addCompany(c);
            companyRepository.save(c);
            return PersonResponse.toResponse(personRepository.save(p));
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }
}
