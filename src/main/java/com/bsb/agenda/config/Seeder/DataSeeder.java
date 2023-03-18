package com.bsb.agenda.config.Seeder;

import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.entity.Person;
import com.bsb.agenda.repository.CompanyRepository;
import com.bsb.agenda.repository.PersonRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DataSeeder {
    private final int numRow = 10;
    private final Faker faker = new Faker();
    private final PersonRepository personRepository;
    private final CompanyRepository companyRepository;
    @EventListener
    public void seed(ContextRefreshedEvent event) throws Exception {
        // create people
        List<Person> employees = personRepository.findAll();
        if (employees.isEmpty()) {
            createPerson();
        }
        if(companyRepository.findAll().isEmpty()){
            createCompany();
        }
    }

    private void createPerson() {
        for (int i = 0; i < numRow; i++) {
            Person p=Person.builder()
                    .firstName(faker.name().firstName())
                    .lastName(faker.name().lastName())
                    .dni(faker.idNumber().valid())
                    .cell(faker.phoneNumber().cellPhone())
                    .phoneLine(faker.phoneNumber().phoneNumber())
                    .zipCode(faker.address().zipCode())
                    .address(faker.address().streetAddress())
                    .province(faker.address().state())
                    .coutry(faker.address().country())
                    .build();
            personRepository.save(p);
        }
    }
    private void createCompany() {
        for (int i = 0; i < numRow; i++) {
            Company company = Company.builder()
                    .nameCompany(faker.company().name())
                    .cuit(faker.number().digits(11))
                    .phoneLine(faker.phoneNumber().phoneNumber())
                    .zipCode(faker.address().zipCode())
                    .address(faker.address().streetAddress())
                    .province(faker.address().state())
                    .coutry(faker.address().country())
                    .build();
            companyRepository.save(company);
        }

    }

}
