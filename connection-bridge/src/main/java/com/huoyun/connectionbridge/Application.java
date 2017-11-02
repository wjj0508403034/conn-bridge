package com.huoyun.connectionbridge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.huoyun.pipe.Pipe;
import com.huoyun.pipe.data.mapper.FieldMapping;
import com.huoyun.pipe.data.mapper.ObjectMapperPipe;
import com.huoyun.pipe.data.mash.DataMashPipe;
import com.huoyun.pipe.impl.PipeEngineExecutor;
import com.huoyun.pipe.impl.AbstractPipe;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
//		Pipe pipe1 = new AbstractPipe("pipe1");
//		Pipe pipe2 = new AbstractPipe("pipe2");
//		Pipe pipe3 = new AbstractPipe("pipe3");
//		Pipe pipe4 = new AbstractPipe("pipe4");
//		pipe1.pipe(pipe2).pipe(pipe3).pipe(pipe4);

//		ClassA a = new ClassA();
//		ObjectMapperPipe pipe = new ObjectMapperPipe(ClassB.class);
//		pipe.addFieldMapping("name", "firstName").addFieldMapping("name",
//				"c.firstName");
//		// Object result = pipe1.run("Hello ");
//		Object result = PipeEngineExecutor.execute(pipe, a);
		
		ClassA a1 = new ClassA();
		a1.setLastName("Wang");
		
		ClassB b1 = new ClassB();
		b1.setFirstName("Jingjing");
		
		DataMashPipe mashPipe = new DataMashPipe(ClassC.class);
		//mashPipe.pipe(new ObjectMapperPipe(ClassC.class));
		Object result2 = PipeEngineExecutor.execute(mashPipe, new Object[] {a1, b1});
		
		//ClassC c1 = new ClassC();
//		c1.setFirstName("Jingjing");
//		c1.setLastName("Wang");
		
		
		SpringApplication.run(Application.class, args);
	}
}
