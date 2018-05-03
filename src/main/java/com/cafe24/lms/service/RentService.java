package com.cafe24.lms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.ItemRepository;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class RentService {
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;
    
    public boolean rent(Long itemNo, Long userNo) {
	Item rentItem = itemRepository.findOne( itemNo );
	User rentUser = userRepository.findOne( userNo );
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	cal.add(Calendar.DATE, 7);
	
	Rent rent = new Rent();
	rent.setRentDate( new Date() );
	rent.setReturnDate( cal.getTime() );
	rent.setItem( rentItem );
	rent.setUser( rentUser );
	
	if(rentRepository.save(rent) != null){
	    rentItem.setIsRent( false );
	}
	return true;
    }
    
    public List<Rent> getRentByUser(Long userNo) {
	return rentRepository.findAllByUserNo(userNo);
    }
    
    public Page<Rent> getRentList(Pageable pageable){
	return rentRepository.findAllByOrderByRentDate(pageable);
    }
}
