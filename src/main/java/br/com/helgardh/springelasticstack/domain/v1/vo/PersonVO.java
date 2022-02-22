package br.com.helgardh.springelasticstack.domain.v1.vo;

import lombok.*;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
public class PersonVO implements Serializable {

    private String id;

    private String name;

    private Integer age;

    private String cpf;

    @Builder
    public PersonVO(String id, String name, Integer age, String cpf) {
        this.id = StringUtils.hasText(id) ? id : UUID.randomUUID().toString();
        this.name = name;
        this.age = age;
        this.cpf = cpf;
    }

    public PersonVO() {
        this.id = StringUtils.hasText(id) ? id : UUID.randomUUID().toString();
    }
}
