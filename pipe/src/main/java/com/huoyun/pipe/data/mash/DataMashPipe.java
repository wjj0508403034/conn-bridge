package com.huoyun.pipe.data.mash;

import java.lang.Iterable;
import java.util.HashMap;
import java.util.Map;

import com.huoyun.pipe.PipeContext;
import com.huoyun.pipe.data.mapper.ObjectMapperPipe;
import com.huoyun.pipe.impl.AbstractPipe;
import com.huoyun.pipe.impl.PipeEngineExecutor;

public class DataMashPipe extends AbstractPipe {

	private Class<?> targetClass;

	public DataMashPipe() {

	}

	public DataMashPipe(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	@Override
	public Object onRun(PipeContext context, Object in) {

		Object out = this.execute(context, in);

		if (this.targetClass == null) {
			return out;
		}

		ObjectMapperPipe pipe = new ObjectMapperPipe(this.targetClass);
		return PipeEngineExecutor.execute(pipe, out);
	}

	private Object execute(PipeContext context, Object in) {
		if (in == null) {
			return null;
		}

		Map<String, Object> dist = new HashMap<>();

		if (in.getClass().isArray()) {
			return this.execute(dist, (Object[]) in);
		}

		if (!(in instanceof Iterable)) {
			throw new RuntimeException("argument in isn't Iterable type");
		}

		return this.execute(dist, (Iterable<?>) in);
	}

	private Object execute(Object dist, Object... items) {
		for (Object item : items) {
			ObjectMapperPipe pipe = new ObjectMapperPipe(dist);
			PipeEngineExecutor.execute(pipe, item);
		}
		return dist;
	}

}
