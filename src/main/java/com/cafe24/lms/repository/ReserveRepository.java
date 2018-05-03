package com.cafe24.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Reserve;
import com.cafe24.lms.domain.ReserveId;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, ReserveId> {
    Reserve findByItemNoOrderByPriorityDesc( Long itemNo );
}
