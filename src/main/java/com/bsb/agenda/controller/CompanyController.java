package com.bsb.agenda.controller;

import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.request.CompanyRequest;
import com.bsb.agenda.service.abs.CompanyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService service;
    @PostMapping
    @ApiOperation(value = "Create new company", notes = "Return a company type response" )
    public ResponseEntity<?> personAdd(
            @Valid @RequestBody CompanyRequest request) throws ErrorProcessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCompany(request));
    }
    /* search person por lastname, phnoline, province, dni, country*/
    @GetMapping
    @ApiOperation(value = "Search filter by matchy", notes = "Returns a list of response type matches" )
    public ResponseEntity<List<?>> getAll(@RequestParam(required = false, defaultValue = "search") String search) throws ErrorProcessException {
        return ResponseEntity.ok(service.getAll(search));
    }
    @GetMapping("/all")
    @ApiOperation(value = "Search all companies", notes = "Returns a list of response" )
    public ResponseEntity<List<?>> searchAll() throws ErrorProcessException {
        return ResponseEntity.ok(service.searchAll());
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Search all companies", notes = "Returns a list of response" )
    public ResponseEntity<?> searchById(@PathVariable Long id) throws ErrorProcessException {
        return ResponseEntity.ok(service.findById(id));
    }
}
