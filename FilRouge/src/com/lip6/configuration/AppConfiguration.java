package com.lip6.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//si je veux int�grer une config XML venant de mon legacy, j'utilise l'@ImportResource 
//@ImportResource(locations = {"classpath:spring/app-context-xml.xml"})

@ImportResource(locations = {"classpath:applicationContext.xml"})
@ComponentScan(basePackages = {"com.lip6.configuration, com.lip6.daos, com.lip6.entities, com.lip6.services, com.lip6.servlets, com.lip6.util"})
@Configuration
public class AppConfiguration {

	//plus rien dans la classe Java, juste une indication ou scanner les beans
}

