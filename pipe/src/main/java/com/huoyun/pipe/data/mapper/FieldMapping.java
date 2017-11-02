package com.huoyun.pipe.data.mapper;

import org.dozer.loader.api.FieldsMappingOption;

public class FieldMapping {

	private String sourceField;
	private String targetField;
	private FieldsMappingOption[] options;
	
	public FieldMapping(String sourceField,String targetField,FieldsMappingOption... options){
		this.sourceField = sourceField;
		this.targetField = targetField;
		this.options = options;
	}

	public String getSourceField() {
		return sourceField;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public String getTargetField() {
		return targetField;
	}

	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}

	public FieldsMappingOption[] getOptions() {
		return options;
	}

	public void setOptions(FieldsMappingOption[] options) {
		this.options = options;
	}
}
