package br.com.helgardh.springelasticstack.service;

import br.com.helgardh.springelasticstack.domain.entity.Person;
import br.com.helgardh.springelasticstack.domain.v1.vo.PersonVO;
import br.com.helgardh.springelasticstack.infra.database.repository.PersonRepository;
import br.com.helgardh.springelasticstack.mapper.AbstractMapper;
import br.com.helgardh.springelasticstack.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends AbstractService<Person, PersonVO>{

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public PagingAndSortingRepository getRepository() {
        return this.personRepository;
    }

    @Override
    public AbstractMapper<Person, PersonVO> getMapper() {
        return PersonMapper.INSTANCE;
    }
}
