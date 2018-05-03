package com.cafe24.lms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.UserRepository;
import com.cafe24.util.EncryptPassword;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void joinUser( User user ) {
	String encPassword = EncryptPassword.encrypt( user.getPassword() );
	user.setPassword( encPassword );
	user.setRegDate( new Date() );
	userRepository.save( user );
    }

    public User getUser( String email, String password ) {
	String encPassword = EncryptPassword.encrypt( password );
	return userRepository.findByEmailAndPassword( email, encPassword );
    }

    public User getUser( Long no ) {
	return userRepository.findByNo( no );
    }
    
    public User modifyUser( User user ) {
	if ( userRepository.update( user ) != 1 ) {
	    return null;
	}

	if ( !("".equals( user.getPassword() )) && (user.getPassword() != null) ) {
	    String encPassword = EncryptPassword.encrypt( user.getPassword() );
	    if ( userRepository.update( encPassword, user.getNo() ) != 1 ) {
		return null;
	    }
	}

	return userRepository.findByNo( user.getNo() );
    }
    
    public void remove(){
	userRepository.deleteAll();
    }
}
