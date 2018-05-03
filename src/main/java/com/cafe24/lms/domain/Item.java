package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name = "DTYPE" )
public abstract class Item {

    @Id
    @Column( name = "item_no" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long no;
    @Column( name = "title", nullable = false, length = 100 )
    private String title;
    @Type( type = "true_false" )
    @Column( name = "is_rent", nullable = false )
    private Boolean isRent;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn( name = "category_no", nullable=false )
    private Category category;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="item", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Rent> rents = new ArrayList<Rent>();
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="item", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Reserve> reserves = new ArrayList<Reserve>();
    // -- Getter/Setter
    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle( String title ) {
	this.title = title;
    }

    public Boolean getIsRent() {
        return isRent;
    }

    public void setIsRent( Boolean isRent ) {
        this.isRent = isRent;
    }

    public Category getCategory() {
	return category;
    }

    public void setCategory( Category category ) {
	this.category = category;
	if( !category.getItems().contains(this) ){
	    category.getItems().add(this);
	}
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents( List<Rent> rents ) {
        this.rents = rents;
    }

    public List<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves( List<Reserve> reserves ) {
        this.reserves = reserves;
    }

    @Override
    public String toString() {
	return "Item [no=" + no + ", title=" + title + ", isRent=" + isRent + ", category=" + category + "]";
    }

}
