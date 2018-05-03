package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "album" )
public class Album extends Item {
    @Column( name = "singer", nullable = true, length = 20 )
    private String singer;

    public String getSinger() {
	return singer;
    }

    public void setSinger( String singer ) {
	this.singer = singer;
    }

    @Override
    public String toString() {
	return "Album [singer=" + singer + ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getIsRent()="
		+ getIsRent() + ", getCategory()=" + getCategory() + "]";
    }

}
