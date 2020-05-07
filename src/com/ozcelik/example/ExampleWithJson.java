package com.ozcelik.example;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ozcelik.pojo.Person;
import com.ozcelik.pojo.Person;

@Path("/getExample")
public class ExampleWithJson {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAValue")
	public Person getAValue() {
		Person person = new Person();
		person.setCity("Ankara");
		person.setCountry("Turkey");
		person.setName("Yusuf Ozcelik");
		return person;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getListValue")
	public ArrayList<Person> getListValue() {
		ArrayList<Person> personList = new ArrayList<>();
		Person person = new Person();
		
		person.setCity("Istanbul");
		person.setCountry("Turkey");
		person.setName("Burak Oz");
		
		Person person1 = new Person();
		person1.setCity("Washington");
		person1.setCountry("U.S.A.");
		person1.setName("Michael Jordan");

		Person person2 = new Person();
		person2.setCity("Detroit");
		person2.setCountry("U.S.A.");
		person2.setName("Isaiah Thomas");
		
		personList.add(person);
		personList.add(person1);
		personList.add(person2);
		
		return personList;
	}
}
