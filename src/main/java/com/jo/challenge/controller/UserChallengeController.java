package com.jo.challenge.controller;

import com.jo.challenge.dto.UserChallengeDto;
import com.jo.challenge.model.UserChallenge;
import com.jo.challenge.service.UserChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserChallengeController {
    private final UserChallengeService userChallengeService;

    @PostMapping("/mychallenge")
    public String add(@RequestBody UserChallengeDto challengeListDto){
        return userChallengeService.addChallengeList(challengeListDto);
    }

    @PutMapping("/mychallenge/{id}")
    public void edit(@PathVariable Long id, @RequestBody UserChallengeDto challengeListDto){
        userChallengeService.editChallengeList(id, challengeListDto);
    }

    @GetMapping("/mychallenge")
    public List<UserChallenge> getAll() {
        return userChallengeService.getAllChallengeList();
    }

    @GetMapping("/mychallenge/{id}")
    public Optional<UserChallenge> getChallengeById(@PathVariable Long id) {
        return userChallengeService.getChallengeListById(id);
    }

    @DeleteMapping("/mychallenge/{id}")
    public void del(@PathVariable("id")Long id) {
        userChallengeService.delChallengeList(id);
    }

    @GetMapping("/mychallenge/all/{challengeId}")
    public Long countByChallengeId(@PathVariable Long challengeId) {
        return userChallengeService.countByChallengeId(challengeId);
    }

    @GetMapping("/mychallenge/list/{userId}")
    public List<UserChallenge> findAllByUserId(@PathVariable Long userId) {
        return userChallengeService.findByUserIdOrderByIdDesc(userId);
    }

    @GetMapping("/mychallenge/{challengeId}/{userId}")
    public UserChallenge findByChallnegeIdAndUserId(@PathVariable Long challengeId, @PathVariable Long userId) {
        return userChallengeService.findByChallengeIdAndUserId(challengeId, userId).get();
    }
}
