package com.promineotech.plums;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScanMarker;

@SpringBootApplication (scanBasePackageClasses = {ComponentScanMarker.class})
public class PlumsFinalProject {

	public static void main(String[] args) {
		SpringApplication.run(PlumsFinalProject.class, args);
	}
}
