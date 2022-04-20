package com.jo.challenge.service;

import com.jo.challenge.dto.ChallengeDto;
import com.jo.challenge.model.Challenge;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    void addChallenge(ChallengeDto challengeDto);
    void editChallenge(Long id, ChallengeDto challengeDto);
    List<Challenge> getAllChallenge();
    Optional<Challenge> getChallengeById(Long id);
    void delChallenge(Long id);
}
