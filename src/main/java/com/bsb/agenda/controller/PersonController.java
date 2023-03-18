package com.bsb.agenda.controller;

import com.bsb.agenda.exception.ErrorProcessException;
import com.bsb.agenda.model.request.PersonRequest;
import com.bsb.agenda.model.response.person.PersonResponse;
import com.bsb.agenda.service.abs.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@Api(value = "Person Controller", tags = "Actions allowed for people")
public class PersonController {
    private final PersonService service;
    @PostMapping
    @ApiOperation(value = "Create new Person", notes = "Return a person type response" )
    public ResponseEntity<PersonResponse> personAdd(
            @Valid @RequestBody PersonRequest request) throws ErrorProcessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addPerson(request));
    }
    /* search person por lastname, phnoline, province, dni, country*/
    @GetMapping
    @ApiOperation(value = "Search filter by matchy", notes = "Returns a list of response type matches" )
    public ResponseEntity<List<?>> getAll(@RequestParam(required = false, defaultValue = "search") String search) throws ErrorProcessException {
        return ResponseEntity.ok(service.getAll(search));
    }
    @GetMapping("/all")
    @ApiOperation(value = "Search all people", notes = "Returns a list of response" )
    public ResponseEntity<List<?>> searchAll() throws ErrorProcessException {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Search porson by id", notes = "Returns response type person" )
    public ResponseEntity<?> findById(@PathVariable Long id) throws ErrorProcessException {
        return ResponseEntity.ok(service.findById(id));
    }
}
