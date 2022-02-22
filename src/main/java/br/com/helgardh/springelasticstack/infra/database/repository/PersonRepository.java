package br.com.helgardh.springelasticstack.infra.database.repository;

import br.com.helgardh.springelasticstack.domain.entity.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    Optional<Person> findById(String id);

    Optional<Person> findByCpf(String cpf);

    Iterable<Person> findAllByAgeBetween(Integer start, Integer end);

}
