package br.com.helgardh.springelasticstack.mapper;

import br.com.helgardh.springelasticstack.domain.entity.Person;
import br.com.helgardh.springelasticstack.domain.v1.vo.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper extends AbstractMapper<Person, PersonVO> {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

}
