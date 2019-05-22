package com.paco.apirest.convert;


public interface ModelConvert <T,D> {
	
	T convert2Entity(D dto);
	D converto2Dto(T model);
	
}
