package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="book")
public class BookCategory extends Category {
    @Column(name="sub_name", nullable=false, length=20)
    private String subName;
    
    public String getSubName() {
        return subName;
    }

    public void setSubName( String subName ) {
        this.subName = subName;
    }
    
}
