package com.todo.tasks;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task implements Serializable{

	private static final long serialVersionUID = -5577579081118070434L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private int priority;
	private Date date;
	private boolean completed;




	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString(){
		return id+"::"+title+"::"+description+""+completed;
	}

}