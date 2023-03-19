package com.bsb.agenda.repository;

import com.bsb.agenda.model.entity.Company;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;

@Repository
public interface CompanyRepository extends DataRepository<Company>, JpaSpecificationExecutor<Company> {
    Company findByCuit(String cuit);
    /* Fitro de busqueda por varias propiedades a la vez,
                obtimizacion de consulta */
    static Specification<Company> nameCompanyOrPhoneOrProvinceOrCuitOrCountryContains(String search) {
        return (root, query, cb) -> {
            String pattern = "%" + search + "%";
            Predicate nameCompanyPredicate = cb.like(root.get("nameCompany"), pattern);
            Predicate phoneLinePredicate = cb.like(root.get("phoneLine"), pattern);
            Predicate provincePredicate = cb.like(root.get("province"), pattern);
            Predicate cuitPredicate = cb.like(root.get("cuit"), pattern);
            Predicate countryPredicate = cb.like(root.get("country"), pattern);
            return cb.or(nameCompanyPredicate, phoneLinePredicate, provincePredicate, cuitPredicate, countryPredicate);
        };
    }
}
