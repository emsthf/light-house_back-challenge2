package com.jo.challenge.service;

import com.jo.challenge.dto.Doing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DoingService {
    Doing addDoing(Doing doing);
    Doing editDoing(Doing doing);
    List<Doing> getAllDoing();
    Optional<Doing> getDoingById(Long id);
    void delDoing(Long id);
    List<Doing> findAllByUserChallengeId(Long userChallengeId);
    List<Doing> findAllByWeekAndUserChallengeId(int week, Long userChallengeId);
    Doing findByChallengeIdAndCheckDate(Long userChallengeId, LocalDate localDate);
}
