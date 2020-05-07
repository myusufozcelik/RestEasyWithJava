package com.ozcelik.postexample;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ozcelik.pojo.Person;

@Path("/postExample")
public class PostExampleClass {

	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	// ya da "application/json" olarak söyleyebiliriz.
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/postAValue")
	public Person postAValueMethod(Person person) {
		System.out.println(person.getName());
		System.out.println(person.getCity());
		System.out.println(person.getCountry());
		return person;
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON) // postmande response dönüþü için yazýyoruz
	@Path("/postListValue")
	public ArrayList<Person> postListValueMethod(ArrayList<Person> personList) {
		for(Person person : personList) {
			System.out.println(person.getName());
			System.out.println(person.getCity());
			System.out.println(person.getCountry());
		}
		return personList;
	}
	
	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/postAValueXml")
	public Person postAValueXml(Person person) {
		
		System.out.println(person.getName());
		System.out.println(person.getCity());
		System.out.println(person.getCountry());
		
		return person;
	}
	
	@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/postAListXml")
	public ArrayList<Person> postListValueXml(ArrayList<Person> personList) {
		for(Person person : personList) {
			System.out.println(person.getName());
			System.out.println(person.getCity());
			System.out.println(	person.getCountry());
		}
		return personList;
	}
}
