package com.ozcelik.client;

import java.awt.List;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.ozcelik.pojo.Person;

@XmlRootElement(name = "collection") // collection tipinde olduðu için
public class PersonListClass {
	ArrayList<Person> personList;
	
	 public PersonListClass() {
		// TODO Auto-generated constructor stub
		personList = new ArrayList<Person>();
	}
	 
	 public void appPerson(Person person) {
		 personList.add(person);
	 }
	 @XmlElement(name = "person") // postmana göre veriyoruz 
	public ArrayList<Person> getPersonList() {
		return personList;
	}

//	public void setPersonList(ArrayList<Person> personList) {
//		this.personList = personList;
//	}
	 
	 
}
