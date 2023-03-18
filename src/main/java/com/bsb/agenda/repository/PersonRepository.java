package com.bsb.agenda.repository;

import com.bsb.agenda.model.entity.Person;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;

@Repository
public interface PersonRepository extends DataRepository<Person>, JpaSpecificationExecutor<Person> {
    Person findByDni(String dni);
    /* Fitro de busqueda por varias propiedades a la vez,
                obtimizacion de consulta */
    static Specification<Person> lastNameOrPhoneOrProvinceOrDniOrCountryContains(String search) {
        return (root, query, cb) -> {
            String pattern = "%" + search + "%";
            Predicate lastNamePredicate = cb.like(root.get("lastName"), pattern);
            Predicate phoneLinePredicate = cb.like(root.get("phoneLine"), pattern);
            Predicate provincePredicate = cb.like(root.get("province"), pattern);
            Predicate dniPredicate = cb.like(root.get("dni"), pattern);
            Predicate countryPredicate = cb.like(root.get("coutry"), pattern);
            return cb.or(lastNamePredicate, phoneLinePredicate, provincePredicate, dniPredicate, countryPredicate);
        };
    }
}
