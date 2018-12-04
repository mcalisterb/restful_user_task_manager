package com.application.model;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column
    private int userID;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private String date_time;


    public Task() {
    }

    public int getID(){
        return this.id;
    }
    
    public void setID(int id_){
        this.id = id_;
    }

    public int getUserID(){
        return this.userID;
    }
    
    public void setUserID(int id_){
        this.userID = id_;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name_){
        this.name = name_;
    }


    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }



    public String getDate_time(){
        return this.date_time;
    }

    public void setDate_time(String date_time){
        this.date_time = date_time;
    }

}
    

