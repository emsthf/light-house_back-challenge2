package com.jo.challenge.repository;

import com.jo.challenge.dto.Doing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DoingRepository extends JpaRepository<Doing, Long> {
    List<Doing> findAllByUserChallengeId(Long userChallengeId);
    List<Doing> findAllByWeekAndUserChallengeId(int week, Long userChallengeId);
    Doing findByUserChallengeIdAndCheckDate(Long userChallengeId, LocalDate localDate);
}
