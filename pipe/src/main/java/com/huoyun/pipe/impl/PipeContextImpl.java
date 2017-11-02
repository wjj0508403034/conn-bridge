package com.huoyun.pipe.impl;

import java.util.concurrent.ConcurrentHashMap;

import com.huoyun.pipe.Pipe;
import com.huoyun.pipe.PipeContext;

public class PipeContextImpl implements PipeContext{

	private ConcurrentHashMap<Pipe,Object> resultMap = new ConcurrentHashMap<>();
	
	@Override
	public Object getResult(Pipe pipe){
		return this.resultMap.get(pipe);
	}
	
	@Override
	public void setResult(Pipe pipe,Object result){
		this.resultMap.put(pipe, result);
	}
}
