package com.huoyun.pipe.data.mapper;

import java.util.List;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingBuilder;

public class ObjectMappingBuilder extends BeanMappingBuilder {

	private final Class<?> sourceClass;
	private final Class<?> targetClass;
	private final List<FieldMapping> fieldsMappingList;

	public ObjectMappingBuilder(Class<?> sourceClass, Class<?> targetClass,
			List<FieldMapping> fieldsMappingList) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.fieldsMappingList = fieldsMappingList;
	}

	@Override
	protected void configure() {
		TypeMappingBuilder builder = this.mapping(this.sourceClass,
				this.targetClass);

		if (fieldsMappingList != null) {
			for (FieldMapping mapping : fieldsMappingList) {
				builder.fields(mapping.getSourceField(),
						mapping.getTargetField(), mapping.getOptions());
			}
		}
	}

}
