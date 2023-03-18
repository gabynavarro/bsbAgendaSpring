package com.bsb.agenda.validation;

import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.model.response.company.CompanyPersonResponse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PersonValidator {
    public static Set<CompanyPersonResponse> validateCompanyInPerson(Set<Company> companies) {
        if (companies.isEmpty()) {
            return new HashSet<>();
        }
        return companies.stream()
                .map(CompanyPersonResponse::toResponse)
                .collect(Collectors.toSet());
    }
}
