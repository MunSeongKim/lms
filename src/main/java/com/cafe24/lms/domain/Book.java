package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "book" )
public class Book extends Item {
    @Column( name = "isbn", nullable = true, length = 30 )
    private String isbn;

    public String getIsbn() {
	return isbn;
    }

    public void setIsbn( String isbn ) {
	this.isbn = isbn;
    }

    @Override
    public String toString() {
	return "Book [isbn=" + isbn + ", getNo()=" + getNo() + ", getTitle()=" + getTitle() + ", getIsRent()="
		+ getIsRent() + ", getCategory()=" + getCategory() + "]";
    }

}
