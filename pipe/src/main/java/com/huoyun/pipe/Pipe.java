package com.huoyun.pipe;

public interface Pipe {

	Pipe pipe(Pipe pipe);

	Object run(PipeContext context, Object in);
}
