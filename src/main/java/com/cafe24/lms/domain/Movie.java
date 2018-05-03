package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "movie" )
public class Movie extends Item {
    @Column( name = "production", nullable = true, length = 50 )
    private String production;

    public String getProduction() {
	return production;
    }

    public void setProduction( String production ) {
	this.production = production;
    }

    @Override
    public String toString() {
	return "Movie [production=" + production + ", getNo()=" + getNo() + ", getTitle()=" + getTitle()
		+ ", getIsRent()=" + getIsRent() + ", getCategory()=" + getCategory() + "]";
    }

}
