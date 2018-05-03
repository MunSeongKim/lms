package com.cafe24.lms.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table( name = "reserve" )
public class Reserve {
    
    @EmbeddedId
    private ReserveId id;

    @MapsId( "userNo" )
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn( name = "user_no" )
    private User user;

    @MapsId( "itemNo" )
    @ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
    @JoinColumn( name = "item_no" )
    private Item item;

    @Column( name = "priority", nullable = false )
    private Integer priority;

    public ReserveId getId() {
	return id;
    }

    public void setId( ReserveId id ) {
	this.id = id;
    }

    public User getUser() {
	return user;
    }

    public void setUser( User user ) {
	this.user = user;
	if(!user.getReserves().contains(this)){
	    user.getReserves().add(this);
	}
    }

    public Item getItem() {
	return item;
    }

    public void setItem( Item item ) {
	this.item = item;
	if(!item.getReserves().contains(this)){
	    item.getReserves().add(this);
	}
    }

    public Integer getPriority() {
	return priority;
    }

    public void setPriority( Integer priority ) {
	this.priority = priority;
    }
//
//    @Override
//    public String toString() {
//	return "Reserve [id=" + id + ", user=" + user + ", item=" + item + ", priority=" + priority + "]";
//    }

}
