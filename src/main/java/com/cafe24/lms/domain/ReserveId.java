package com.cafe24.lms.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReserveId implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long userNo;
    private Long itemNo;
    
    public ReserveId() { }
    public ReserveId(Long itemNo, Long userNo){
	this.userNo = userNo;
	this.itemNo = itemNo;
    }

    public Long getUserNo() {
        return userNo;
    }
    public void setUserNo( Long userNo ) {
        this.userNo = userNo;
    }
    public Long getItemNo() {
        return itemNo;
    }
    public void setItemNo( Long itemNo ) {
        this.itemNo = itemNo;
    }
    
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((itemNo == null) ? 0 : itemNo.hashCode());
	result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
	return result;
    }
    @Override
    public boolean equals( Object obj ) {
	if ( this == obj ) return true;
	if ( obj == null ) return false;
	if ( getClass() != obj.getClass() ) return false;
	ReserveId other = (ReserveId) obj;
	if ( itemNo == null ) {
	    if ( other.itemNo != null ) return false;
	} else if ( !itemNo.equals( other.itemNo ) ) return false;
	if ( userNo == null ) {
	    if ( other.userNo != null ) return false;
	} else if ( !userNo.equals( other.userNo ) ) return false;
	return true;
    }
}
