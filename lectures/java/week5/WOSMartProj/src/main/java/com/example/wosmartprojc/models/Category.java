package com.example.wosmartprojc.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="categorys")
public class Category {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotBlank(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 2 and 30 characters")
	private String name;



    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
	private Date updatedAt;


    // ==========================
    //        RELATIONSHIPS
    // ==========================

	@OneToMany(mappedBy="noteCat", fetch = FetchType.LAZY)
	private List<Note> catNote;
	
	@OneToMany(mappedBy="foodCat", fetch = FetchType.LAZY)
	private List<Food> catFood;
	
	@OneToMany(mappedBy="pupCat", fetch = FetchType.LAZY)
	private List<Puppy> catPup;
	
	@OneToMany(mappedBy="squishCat", fetch = FetchType.LAZY)
	private List<Squish> catSquish;
	
	@OneToMany(mappedBy="stickCat", fetch = FetchType.LAZY)
	private List<Stick> catStick;
	
	@OneToMany(mappedBy="linkCat", fetch = FetchType.LAZY)
	private List<Link> catLink;
	
    // ==========================
    //        CONSTRUCTOR
    // ==========================

    public Category() {}

	// ==========================
    //     GETTERS / SETTERS
    // ==========================
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Note> getCatNote() {
		return catNote;
	}

	public void setCatNote(List<Note> catNote) {
		this.catNote = catNote;
	}

	public List<Food> getCatFood() {
		return catFood;
	}

	public void setCatFood(List<Food> catFood) {
		this.catFood = catFood;
	}

	public List<Puppy> getCatPup() {
		return catPup;
	}

	public void setCatPup(List<Puppy> catPup) {
		this.catPup = catPup;
	}

	public List<Squish> getCatSquish() {
		return catSquish;
	}

	public void setCatSquish(List<Squish> catSquish) {
		this.catSquish = catSquish;
	}

	public List<Stick> getCatStick() {
		return catStick;
	}

	public void setCatStick(List<Stick> catStick) {
		this.catStick = catStick;
	}

	public List<Link> getCatLink() {
		return catLink;
	}

	public void setCatLink(List<Link> catLink) {
		this.catLink = catLink;
	}

	
    
    
}
