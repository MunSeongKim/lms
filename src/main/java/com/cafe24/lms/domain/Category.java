package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name = "DTYPE" )
public abstract class Category {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "category_no" )
    private Long no;
    @Column( name = "name", nullable = false, length = 20 )
    private String name;

    @OneToMany( mappedBy = "category", fetch=FetchType.LAZY )
    private List<Item> items = new ArrayList<Item>();

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public List<Item> getItems() {
	return items;
    }

    public void setItems( List<Item> items ) {
	this.items = items;
    }

    @Override
    public String toString() {
	return "Category [no=" + no + ", name=" + name + "]";
    }
}
