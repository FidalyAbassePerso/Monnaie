package com.monnaie.monnaieDemo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.monnaie.monnaieDemo.entity.Monnaie;
import com.monnaie.monnaieDemo.service.MonnaieService;
import com.monnaie.monnaieDemo.service.impl.MonnaieServiceImpl;

@SpringBootApplication
@EntityScan(basePackages = {"com.monnaie.monnaieDemo.entity"})
@ComponentScan(basePackages = {"com.monnaie.monnaieDemo","com.monnaie.monnaieDemo.service.impl","com.monnaie.monnaieDemo.service"} )
public class MonnaieDemoApplication {
	
	private static ApplicationContext context;
	
	private static MonnaieService monnaieService;
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		context = SpringApplication.run(MonnaieDemoApplication.class, args);
		
		monnaieService = (MonnaieService) context.getBean("monnaieServiceImpl");
		
		Monnaie monnaie = monnaieService.monnaieOptimale(10);
		
		System.out.println("Monnaie rendu pour la somme 10 : "+monnaie);
		
		monnaie = monnaieService.monnaieOptimale(1);
		
		System.out.println("Monnaie rendu pour la somme 1 : "+ monnaie);
		
		monnaie = monnaieService.monnaieOptimale(6);
		
		System.out.println("Monnaie rendu pour la somme 6 : "+monnaie);
		
		// On arrete le programme à la fin
		SpringApplication.exit(context, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
			        return 0;
			    }
		});
		
	}
	

}
