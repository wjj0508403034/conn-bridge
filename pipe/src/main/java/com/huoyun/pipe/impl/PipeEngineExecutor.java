package com.huoyun.pipe.impl;

import com.huoyun.pipe.Pipe;
import com.huoyun.pipe.PipeContext;
import com.huoyun.pipe.PipeEngine;

public class PipeEngineExecutor implements PipeEngine {

	@Override
	public Object run(Pipe pipe, Object in) {
		PipeContext context = new PipeContextImpl();
		Object out = pipe.run(context, in);
		context.setResult(pipe, out);
		return out;
	}

	public static Object execute(Pipe pipe, Object in) {
		PipeEngine engine = new PipeEngineExecutor();
		return engine.run(pipe, in);
	}

}
