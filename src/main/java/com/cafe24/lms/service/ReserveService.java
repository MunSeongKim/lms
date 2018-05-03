package com.cafe24.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.domain.ReserveId;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.ItemRepository;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.ReserveRepository;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class ReserveService {
    @Autowired
    private ReserveRepository reserveRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentRepository rentRepository;

    private boolean isReservedUser( Long itemNo, Long userNo ) {
	ReserveId id = new ReserveId();
	id.setItemNo( itemNo );
	id.setUserNo( userNo );
	return (reserveRepository.findOne( id ) != null );
    }

    private Reserve isReservedItem( Long itemNo ) {
	return reserveRepository.findByItemNoOrderByPriorityDesc( itemNo );
    }

    private boolean isRented( Long itemNo ) {
	return itemRepository.findOne(itemNo).getIsRent();
    }
    
    private boolean isRentedUser( Long userNo ) {
	return (rentRepository.findByUserNo(userNo) != null);
    }
    
    public Page<Reserve> getReserveList(Pageable pageable) {
	return reserveRepository.findAll(pageable);
    }

    public boolean reserve( Long itemNo, Long userNo ) {
	if ( isRented(itemNo) ) {
	    return false;
	}
	
	if ( isRentedUser(userNo) ){
	    System.out.println( "대여" );
	    return false;
	}
	
	if ( isReservedUser( itemNo, userNo ) ) {
	    return false;
	}
	
	Item reserveItem = itemRepository.findOne( itemNo );
	User reserveUser = userRepository.findOne( userNo );

	Reserve reserved = isReservedItem( itemNo );
	
	Reserve reserve = new Reserve();
	reserve.setId(new ReserveId(itemNo,userNo));
	reserve.setItem( reserveItem );
	reserve.setUser( reserveUser );
	
	if ( reserved != null ) {
	    reserve.setPriority( reserved.getPriority() + 1 );
	} else {
	    reserve.setPriority( 1 );
	}
	
	System.out.println( reserve );

	return (reserveRepository.save( reserve ) != null);
    }
}
