package br.com.helgardh.springelasticstack.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.Optional;

public interface Service<V> {

    V save(V valueObject);

    V update(String id, V valueObject);

    void delete(String id);

    V findById(String id);

    Page<V> findAll(Pageable pageable);

}
