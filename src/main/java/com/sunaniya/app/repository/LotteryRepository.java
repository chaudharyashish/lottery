package com.sunaniya.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunaniya.app.model.Lottery;

public interface LotteryRepository extends JpaRepository<Lottery, Long> {

	 @Query("Select l from Lottery l where l.allotted=:isAllott AND l.lotteryNumber like %:number%")
     List<Lottery> findByAllottedAndLotteryNumberContaining(@Param("isAllott")boolean isAllotted, @Param("number")String number);
	 
//	 @Query("Select l from Lottery l where l.alloted=:isAllotted")
     List<Lottery> findByAllotted(boolean isAllotted, Pageable pageable);
}
