package com.huoyun.pipe.impl;

import com.huoyun.pipe.Pipe;
import com.huoyun.pipe.PipeContext;

public abstract class AbstractPipe implements Pipe {

	private Pipe pipe = null;

	@Override
	public final Pipe pipe(Pipe pipe) {
		this.pipe = pipe;
		return this.pipe;
	}

	protected abstract Object onRun(PipeContext context, Object in);

	@Override
	public final Object run(PipeContext context, Object in) {
		Object out = this.onRun(context, in);
		if (this.pipe == null) {
			return out;
		}
		return ((AbstractPipe) this.pipe).onRun(context, out);
	}

}
