package com.application.model;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
    @Column
	private String first_name;
    @Column
	private String last_name;


    public UserDetails() {
    }

    public int getID(){
        return this.id;
    }
    
    public void setID(int id_){
        this.id = id_;
    }

    public String getusername(){
        return this.username;
    }

    public void setusername(String userName){
        this.username = userName;
    }


    public String getfirst_name(){
        return this.first_name;
    }

    public void setfirst_name(String firstName){
        this.first_name = firstName;
    }

    public String getlast_name(){
        return this.last_name;
    }

    public void setlast_Name(String lastName){
        this.last_name = lastName;
    }



}
    

