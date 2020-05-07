package com.ozcelik.example;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ozcelik.pojo.Person;
import com.ozcelik.pojo.Person;

@Path("/xmlOutput")
public class ExampleWithXml {
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	@Path("/getPersonAsXml")
	public Person getPersonAsXml() {
		Person person = new Person();
		person.setCity("Ankara");
		person.setCountry("Turkey");
		person.setName("Yusuf Ozcelik");
		return person;
	}
	@GET
	@Produces(MediaType.APPLICATION_ATOM_XML)
	@Path("/getPersonListXml")
	public ArrayList<Person> getPersonList() {
		ArrayList<Person> personList = new ArrayList<>();
		Person person = new Person();
		person.setCity("Londra");
		person.setCountry("U.K.");
		person.setName("David Strom");
		
		Person person2 = new Person();
		Person person3 = new Person();
		person2.setCity("Berlin");
		person2.setCountry("Germany");
		person2.setName("Hans Muller");
		
		person3.setCity("Moscov");
		person3.setCountry("Russia");
		person3.setName("Tatiana Lovisk");
		personList.add(person);
		personList.add(person2);
		personList.add(person3);
		return personList;
	}
}
