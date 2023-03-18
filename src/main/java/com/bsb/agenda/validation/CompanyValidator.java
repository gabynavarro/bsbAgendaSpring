package com.bsb.agenda.validation;

import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.response.person.PersonCompanyResponse;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyValidator {
    public static Set<PersonCompanyResponse> validateCompanyInPerson(Set<Person> people) {
        if (people.isEmpty()) {
            return new HashSet<>();
        }
        return people.stream()
                .map(PersonCompanyResponse::toReponse)
                .collect(Collectors.toSet());
    }
}
