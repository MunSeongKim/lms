package com.cafe24.lms.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findAllByUserNo( Long userNo );

    Page<Rent> findAllByOrderByRentDate(Pageable pageable);

    Object findByUserNo( Long userNo );

}
