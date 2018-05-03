package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query( "SELECT new com.cafe24.lms.domain.User(u.no, u.name, u.email, u.role)"
    	+ " FROM User u WHERE u.email=:email AND u.password=:password" )
    User findByEmailAndPassword( @Param( "email" ) String email, @Param( "password" ) String password );

    @Query( "SELECT new com.cafe24.lms.domain.User(u.no, u.name, u.email, u.phone, u.gender)"
    	+ " FROM User u WHERE u.no=:no" )
    User findByNo( @Param( "no" ) Long no );
    
    @Modifying
    @Query("UPDATE User u "
    	+ "SET u.name=:#{#user.name}, u.phone=:#{#user.phone}, "
    	+ "u.gender=:#{#user.gender} "
    	+ "WHERE u.no = :#{#user.no}")
    int update(@Param("user") User user);
    
    @Modifying
    @Query("UPDATE User u "
    	+ "SET u.password=:password "
    	+ "WHERE u.no=:no")
    int update(@Param("password") String password, @Param("no") Long no);
}
