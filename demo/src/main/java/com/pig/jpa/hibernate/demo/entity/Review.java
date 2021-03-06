package com.pig.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String rating;
	private String description;
	@ManyToOne// ManyToOne fetch default is Eager
	private Course course;    
	
	protected Review() {
	}

	public Review(String rating,String description) {
		this.rating=rating;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRation(String rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", rating="+ rating +", description=" + description + "]";
	}

}
