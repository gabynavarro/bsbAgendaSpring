package com.bsb.agenda.repository;

import com.bsb.agenda.model.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DataRepository <T extends Data> extends JpaRepository<T, Long> {
}
