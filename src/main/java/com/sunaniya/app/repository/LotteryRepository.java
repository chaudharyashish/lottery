package com.sunaniya.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunaniya.app.model.Lottery;

public interface LotteryRepository extends JpaRepository<Lottery, Long> {

	 @Query("Select l from Lottery l where l.isAllotted=:isAllott AND l.lotteryNumber like %:start OR l.lotteryNumber like :end%")
     List<Lottery> findByAllottedAndLotteryNumberContaining(@Param("isAllott")boolean isAllotted, @Param("start")String start, @Param("end")String end);
	 
//	 @Query("Select l from Lottery l where l.isAlloted=:isAllotted")
     List<Lottery> findByAllotted(boolean isAllotted, Pageable pageable);
}
