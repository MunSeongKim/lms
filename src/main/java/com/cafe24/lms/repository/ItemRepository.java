package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe24.lms.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findByNo(Long no);
    
    @Modifying
    @Query("UPDATE Item i SET i.isRent='F' WHERE i.no=:no")
    int update(@Param("no") Long no);
}
