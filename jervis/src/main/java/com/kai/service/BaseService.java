package com.kai.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.kai.api.model.AbstractDto;
import com.kai.domain.AbstractEntity;

/**
 * @author Kai
 *
 */
public abstract class BaseService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static String dtoSuffix = "Dto";
    private static String dtoPackage = packageForClass(AbstractDto.class);
    private static String entityPackage = packageForClass(AbstractEntity.class);

    @Autowired
    ModelMapper modelMapper;

    /**
     * Convert entity to dto
     * 
     * @param entity
     * @return
     */
    public <D extends AbstractDto, E extends AbstractEntity> D toDto(E entity) {
	return toDto(entity, getDtoClass(entity.getClass()));
    }
    
    /**
     * Convert entity to dto of a given class.
     * 
     * @param entity
     * @param clazz
     * @return
     */
    public <D extends AbstractDto, E extends AbstractEntity> D toDto(E entity, Class<D> clazz) {
	return modelMapper.map(entity, clazz);
    }

    /**
     * @param entities
     * @return
     */
    public <D extends AbstractDto, E extends AbstractEntity> List<D> toDtoList(List<E> entities) {
	if (CollectionUtils.isEmpty(entities)) {
	    return new ArrayList<D>();
	} else {
	    return toDtoList(entities, getDtoClass(entities.get(0).getClass()));
	}
    }

    public <D extends AbstractDto, E extends AbstractEntity> List<D> toDtoList(List<E> entities, Class<D> clazz) {
	List<D> dtos = new ArrayList<D>();
	if(entities != null) {
	    for(E entity : entities)
		dtos.add(toDto(entity, clazz));
	}
	return dtos;
    }
    
    /**
     * Convert dto to entity
     * 
     * @param dto
     * @return
     */
    public <E extends AbstractEntity, D extends AbstractDto> E toEntity(D dto) {
	return toEntity(dto, getEntityClass(dto.getClass()));
    }
    
    /**
     * Convert dto to entity of a given class
     * 
     * @param dto
     * @param clazz
     * @return
     */
    public <E extends AbstractEntity, D extends AbstractDto> E toEntity(D dto, Class<E> clazz) {
	return modelMapper.map(dto, clazz);
    }
    
    /**
     * Convert dtos to entities, corresponding dto class is used
     * 
     * @param dtos
     * @return
     */
    public <E extends AbstractEntity, D extends AbstractDto> List<E> toEntityList(List<D> dtos) {
	if(CollectionUtils.isEmpty(dtos)) {
	    return new ArrayList<E>();
	} else {
	    return toEntityList(dtos, getEntityClass(dtos.get(0).getClass()));
	}
    }
    
    /**
     * Convert dtos to entities of a given class.
     * 
     * @param dtos
     * @param clazz
     * @return
     */
    public <E extends AbstractEntity, D extends AbstractDto> List<E> toEntityList(List<D> dtos, Class<E> clazz) {
	List<E> entities = new ArrayList<>();
	if(dtos != null) {
	    for(D dto: dtos) 
		entities.add(toEntity(dto, clazz));
	}
	return entities;
    }

    @SuppressWarnings("unchecked")
    private <D extends AbstractDto, E extends AbstractEntity> Class<D> getDtoClass(Class<?> clazz) {
	try {
	    return (Class<D>) Class.forName(dtoPackage + clazz.getSimpleName() + dtoSuffix);
	} catch (ClassNotFoundException e) {
	    throw new RuntimeException();
	}
    }

    @SuppressWarnings("unchecked")
    private <D extends AbstractDto, E extends AbstractEntity> Class<E> getEntityClass(Class<D> clazz) {
	try {
	    String name = clazz.getSimpleName();
	    return (Class<E>) Class.forName(entityPackage + name.substring(0, name.length() - dtoSuffix.length()));
	} catch (ClassNotFoundException e) {
	    throw new RuntimeException();
	}
    }

    private static String packageForClass(Class<?> clazz) {
	return clazz.getPackage().getName() + ".";
    }

}
