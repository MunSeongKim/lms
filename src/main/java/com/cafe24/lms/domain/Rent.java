package com.cafe24.lms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "rent" )
public class Rent {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "rent_no" )
    private Long no;

    @Temporal( value = TemporalType.DATE )
    @Column( name = "rent_date", nullable = false )
    private Date rentDate;
    @Temporal( value = TemporalType.DATE )
    @Column( name = "return_date", nullable = false )
    private Date returnDate;

    @ManyToOne( fetch = FetchType.EAGER, optional = false )
    @JoinColumn( name = "user_no", nullable = false )
    private User user;

    @ManyToOne( fetch = FetchType.EAGER, optional = false )
    @JoinColumn( name = "item_no", nullable = false )
    private Item item;

    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public Date getRentDate() {
	return rentDate;
    }

    public void setRentDate( Date rentDate ) {
	this.rentDate = rentDate;
    }

    public Date getReturnDate() {
	return returnDate;
    }

    public void setReturnDate( Date returnDate ) {
	this.returnDate = returnDate;
    }

    public User getUser() {
	return user;
    }

    public void setUser( User user ) {
	this.user = user;
	if(!user.getRents().contains(this)){
	    user.getRents().add(this);
	}
    }

    public Item getItem() {
	return item;
    }

    public void setItem( Item item ) {
	this.item = item;
	if(!item.getRents().contains(this)){
	    item.getRents().add(this);
	}
    }
    

    @Override
    public String toString() {
	return "Rent [no=" + no + ", rentDate=" + rentDate + ", returnDate=" + returnDate + "]";
    }

}