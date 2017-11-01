package com.huoyun.connectionbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.huoyun.pipe.Pipe;
import com.huoyun.pipe.impl.PipeImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		Pipe pipe1 = new PipeImpl("pipe1");
		Pipe pipe2 = new PipeImpl("pipe2");
		Pipe pipe3 = new PipeImpl("pipe3");
		Pipe pipe4 = new PipeImpl("pipe4");
		pipe1.pipe(pipe2).pipe(pipe3).pipe(pipe4);
		Object result = pipe1.run("Hello ");
		SpringApplication.run(Application.class, args);
	}
}
