package com.bsb.agenda.service.abs;

import com.bsb.agenda.model.entity.Data;
import com.bsb.agenda.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public abstract class DataService <T extends Data>{
    @Autowired
    private DataRepository <T> repository;
    public T save(T entity) {
        return repository.save(entity);
    }
    public Optional<T> findById(Long id) {
        return repository.findById(id);
    }
    public List<T> findAll() {
        return repository.findAll();
    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
