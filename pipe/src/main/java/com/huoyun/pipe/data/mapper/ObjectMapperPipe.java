package com.huoyun.pipe.data.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

import com.huoyun.pipe.PipeContext;
import com.huoyun.pipe.impl.AbstractPipe;

public class ObjectMapperPipe extends AbstractPipe {

	private final DozerBeanMapper mapper = new DozerBeanMapper();
	private BeanMappingBuilder builder = null;

	private Class<?> destinationClass;
	private Class<?> sourceClass;

	private Object destination;

	private final List<FieldMapping> fieldMappingList = new ArrayList<>();

	public ObjectMapperPipe(Class<?> destinationClass,
			FieldMapping... fieldsMapping) {
		this.destinationClass = destinationClass;

		if (fieldsMapping != null) {
			for (FieldMapping mapping : fieldsMapping) {
				this.fieldMappingList.add(mapping);
			}
		}
	}

	public ObjectMapperPipe(Object destination, FieldMapping... fieldsMapping) {
		this(destination.getClass(), fieldsMapping);
		this.destination = destination;
	}

	public ObjectMapperPipe addFieldMapping(FieldMapping fieldMapping) {
		this.fieldMappingList.add(fieldMapping);
		return this;
	}

	public ObjectMapperPipe addFieldMapping(String sourceField,
			String targetField) {
		this.fieldMappingList.add(new FieldMapping(sourceField, targetField));
		return this;
	}

	@Override
	public Object onRun(PipeContext context, Object in) {
		if (this.sourceClass == null) {
			this.sourceClass = in.getClass();
		}

		BeanMappingBuilder builder = this.getBuilder();
		if (builder != null) {
			this.mapper.addMapping(builder);
		}

		if (this.destination != null) {
			this.mapper.map(in, this.destination);
			return this.destination;
		}

		return this.mapper.map(in, this.destinationClass);
	}

	private BeanMappingBuilder getBuilder() {
		if (this.builder == null) {
			this.builder = new ObjectMappingBuilder(this.sourceClass,
					this.destinationClass, this.fieldMappingList);
		}

		return this.builder;

	}

}
