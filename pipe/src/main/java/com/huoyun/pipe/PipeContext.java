package com.huoyun.pipe;

public interface PipeContext {

	Object getResult(Pipe pipe);

	void setResult(Pipe pipe, Object result);

}
