package br.com.helgardh.springelasticstack.service;

import br.com.helgardh.springelasticstack.exception.NotFoundException;
import br.com.helgardh.springelasticstack.mapper.AbstractMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.Objects;

public abstract class AbstractService<E, V> implements Service<V> {

    public abstract PagingAndSortingRepository<E, Object> getRepository();

    public abstract AbstractMapper<E, V> getMapper();

    @Override
    public V save(V valueObject) {
        validate(valueObject);
        return getMapper().toDto(getRepository().save(getMapper().toEntity(valueObject)));
    }

    @Override
    public V update(String id, V valueObject) {
        validate(valueObject);

        E entity = getMapper().toEntity(findById(id));

        BeanUtils.copyProperties(valueObject, entity, "id");

        return getMapper().toDto(getRepository().save(entity));
    }

    @Override
    public void delete(String id) {
        findById(id);
        getRepository().deleteById(id);
    }

    @Override
    public V findById(String id) {
        if(!StringUtils.hasText(id)) throw new IllegalArgumentException("ID cannot be null.");
        return getRepository().findById(id).map(getMapper()::toDto).orElseThrow(
                () ->  new NotFoundException(MessageFormat.format("Entity with ID {0} not found.", id))
        );
    }

    @Override
    public Page<V> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(getMapper()::toDto);
    }

    public void validate(V valueObject){
        if(Objects.isNull(valueObject)){
            throw new IllegalArgumentException("Value object cannot be null.");
        }
    }
}
