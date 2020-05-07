package com.ozcelik.client;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.ozcelik.pojo.Person;

public class ClientClassExample {
	
	
	
	public static void main(String[] args) {
		ClientClassExample clientClassExample = new ClientClassExample();
		//clientClassExample.postAValueInJSON();
		//clientClassExample.postListValueInJSON();		
		//clientClassExample.postAValueInXML();
		clientClassExample.postListValueInXML();
	}
	
	public void postAValueInXML() {
		Person person = new Person();
		person.setName("Yusuf Ozcelik");
		person.setCity("Ankara");
		person.setCountry("Turkiye");
		Entity personEntity = Entity.xml(person); // person'u xml formatýna çevirip personEntity nesnesine koy
		String link = "http://localhost:8080/RestEasyProje/webservice/postExample/postAValueXml";
		ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
		ResteasyWebTarget resteasyWebTarget = resteasyClient.target(link);
		Response response = resteasyWebTarget.request().post(personEntity);
		status(response);
	}
	
	public void postListValueInXML() {
		PersonListClass personListClass = new PersonListClass();
		Person person = new Person();
		person.setName("Mustafa Abi");
		person.setCity("Konya");
		person.setCountry("Turkiye");
		
		Person person1 = new Person();
		person1.setName("John Denver");
		person1.setCity("Kansas City");
		person1.setCountry("U.S.A.");
		
		Person person2 = new Person();
		person2.setName("Hans Gretsen");
		person2.setCity("Berlin");
		person2.setCountry("Deutschland");
		
		personListClass.appPerson(person);
		personListClass.appPerson(person1);
		personListClass.appPerson(person2);
		
		Entity<PersonListClass> entity = Entity.xml(personListClass);
		String link = "http://localhost:8080/RestEasyProje/webservice/postExample//postAListXml";
		ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
		ResteasyWebTarget resteasyWebTarget = resteasyClient.target(link);
		Response response = resteasyWebTarget.request().post(entity);
		status(response);
		
	}
	
	public void postAValueInJSON() {
		Person person = new Person();
		person.setName("Yusuf Ozcelik");
		person.setCity("Ankara");
		person.setCountry("Turkiye");
		String link = "http://localhost:8080/RestEasyProje/webservice/postExample/postAValue";
		Client client = ClientBuilder.newClient(); // yeni bir client nesnesi oluþturduk
		WebTarget target = client.target(link); 
		Response response = target.request().post(Entity.entity(person, MediaType.APPLICATION_JSON)); 
		// target üzerinden hedef nesneye request atmak için request.post ifadesini kullandýk
		// person entitysini application_json tipinde post et dedik
		
		status(response);
	}
	
	
	public void status(Response response) {
		
		if(response.getStatus()==200) {
			System.out.println("Post iþlemi baþarýlý!");
			System.out.println(response.readEntity(String.class));
		}
		else {
			System.out.println("Ýþlem baþarýsýz");
			System.out.println(response.readEntity(String.class));
		}		
	}
	
	
	
	public void postListValueInJSON() {
		ArrayList<Person> personList = new ArrayList<>();
		String link = "http://localhost:8080/RestEasyProje/webservice/postExample/postListValue";
		Person person = new Person();
		person.setName("Mustafa Abi");
		person.setCity("Konya");
		person.setCountry("Turkiye");
		
		Person person1 = new Person();
		person1.setName("John Denver");
		person1.setCity("Kansas City");
		person1.setCountry("U.S.A.");
		
		Person person2 = new Person();
		person2.setName("Hans Gretsen");
		person2.setCity("Berlin");
		person2.setCountry("Deutschland");
		
		personList.add(person1);
		personList.add(person);
		personList.add(person2);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(link);
		Response response = target.request().post(Entity.entity(personList, MediaType.APPLICATION_JSON));
		
		status(response);
	}
	
}
