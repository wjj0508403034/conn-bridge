package com.huoyun.pipe.impl;

import com.huoyun.pipe.Pipe;

public class PipeImpl implements Pipe{
	
	private Pipe pipe = null;

	private String name;
	
	public PipeImpl(String name){
		this.name = name;
	}
	
	@Override
	public final Pipe pipe(Pipe pipe) {
		this.pipe = pipe;
		return this.pipe;
	}
	
	@Override
	public final Object run(Object in){
		Object out = in + this.name;
		if(this.pipe == null){
			return out;
		}
		return this.pipe.run(out);
	}
	

}
