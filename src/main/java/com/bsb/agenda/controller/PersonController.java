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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@Api(value = "Person Controller", tags = "Actions allowed for people")
public class PersonController {
    private final PersonService service;
    @PostMapping
    @ApiOperation(value = "create new Person", notes = "Return a person type response" )
    public ResponseEntity<PersonResponse> personAdd(
            @Valid @RequestBody PersonRequest request) throws ErrorProcessException {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addPerson(request));
    }

}
