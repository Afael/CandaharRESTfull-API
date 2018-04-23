package com.candahar.rest.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long Id;
	private String ProfileName;
	private String FirstName;
	private String LastName;
	private Date DateCreated;
	
	public Profile() {}

	public Profile(long id, String profileName, String firstName, String lastName) {
		super();
		Id = id;
		ProfileName = profileName;
		FirstName = firstName;
		LastName = lastName;
		DateCreated = new Date();
	}
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getProfileName() {
		return ProfileName;
	}
	public void setProfileName(String profileName) {
		ProfileName = profileName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	
}
