package com.jo.challenge.service;

import com.jo.challenge.dto.UserChallengeDto;
import com.jo.challenge.model.UserChallenge;

import java.util.List;
import java.util.Optional;

public interface UserChallengeService {
    String addChallengeList(UserChallengeDto userChallengeDto);
    void editChallengeList(Long id, UserChallengeDto challengeListDto);
    List<UserChallenge> getAllChallengeList();
    Optional<UserChallenge> getChallengeListById(Long id);
    void delChallengeList(Long id);
    Long countByChallengeId(Long challengeId);
    List<UserChallenge> findByUserIdOrderByIdDesc(Long userId);
    Optional<UserChallenge> findByChallengeIdAndUserId(Long challengeId, Long userId);
}
