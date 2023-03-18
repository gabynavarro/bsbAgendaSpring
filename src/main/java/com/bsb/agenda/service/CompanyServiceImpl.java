package com.bsb.agenda.service;

import com.bsb.agenda.exception.BadRequestException;
import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.exception.NotFoundException;
import com.bsb.agenda.model.entity.Company;
import com.bsb.agenda.model.request.CompanyRequest;
import com.bsb.agenda.model.response.company.CompanyResponse;
import com.bsb.agenda.repository.CompanyRepository;
import com.bsb.agenda.service.abs.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final String ERROR_NOT_FOUND = "An error occurred in the process: ";
    private final CompanyRepository companyRepository;

    @Override
    @Transactional
    public CompanyResponse addCompany(CompanyRequest request) throws ErrorProcessException {
        if (companyRepository.findByCuit(request.getCuit()) != null) {
            throw new BadRequestException("Existing company");
        }
        try {
            return CompanyResponse.toResponse(companyRepository.save(CompanyRequest.toEnty(request)));
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    public List<CompanyResponse> getAll(String search) throws ErrorProcessException {
        Specification<Company> specification = CompanyRepository.nameCompanyOrPhoneOrProvinceOrCuitOrCountryContains(search);
        try {
            return companyRepository.findAll(specification).stream()
                    .map(CompanyResponse::toResponse)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    public List<CompanyResponse> searchAll() throws ErrorProcessException {
        try {
            return companyRepository.findAll().stream()
                    .map(CompanyResponse::toResponse)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }

    @Override
    public CompanyResponse findById(Long id) throws ErrorProcessException {
        Company c = companyRepository.findById(id).orElseThrow(() -> new NotFoundException("the company id was not found in the database"));
        try {
            return CompanyResponse.toResponse(c);
        } catch (RuntimeException e) {
            throw new ErrorProcessException(ERROR_NOT_FOUND + e.getMessage());
        }
    }
}
