package Bouzhar.BotolaPro.demo.mapping;

import org.mapstruct.Mapper;

//@Mapper
public interface GenericMapper <E,D>{
    D mapToDto(E entity);
    E mapFromDto(D dto);
}
