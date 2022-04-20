package com.jo.challenge.service;

import com.jo.challenge.dto.ChallengeDto;
import com.jo.challenge.model.Challenge;
import com.jo.challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {
    private final ChallengeRepository challengeRepository;

    @Override
    public void addChallenge(ChallengeDto challengeDto) {
        log.info("add challenge");
        // 전체 기간의 주차별로 실행해야 할 count 수
        int totalWeekCount = (int)Math.floor(challengeDto.getPeriod() / 7) * challengeDto.getWeekCount();
        // 전체 기간에서 일주일 단위로 나누어 떨어지지 않는 나머지 일수
        int remainderDay = challengeDto.getPeriod() - (int)Math.floor(challengeDto.getPeriod() / 7) * 7;
        int totalCount = 0;

        if(challengeDto.getPeriod() % 7 > challengeDto.getWeekCount()) {
            totalCount = totalWeekCount + challengeDto.getWeekCount();
        } else if(challengeDto.getPeriod() % 7 == 0) {
            totalCount = totalWeekCount;
        } else {
            totalCount = totalWeekCount + remainderDay;
        }
//        log.info("totalCount : {}", totalCount);

        challengeRepository.save(Challenge.builder()
                .challengeTitle(challengeDto.getChallengeTitle())
                .challengeDesc(challengeDto.getChallengeDesc())
                .challengeImg(challengeDto.getChallengeImg())
                .startDay(challengeDto.getStartDay())
                .endDay(challengeDto.getEndDay())
                .period(challengeDto.getPeriod())
                .weekCount(challengeDto.getWeekCount())
                .totalCount(totalCount)
                .challengeState(challengeDto.getChallengeState())
                .build());
    }

    @Override
    public void editChallenge(Long id, ChallengeDto challengeDto) {
        //        log.info("edit challenge. {}", challengeRepository.findById(challengeDto.getChallengeListId()).get());
        if (challengeRepository.findById(id).isPresent()) {
            Challenge editedChallenge = Challenge
                    .builder()
                    .id(id)
                    .challengeTitle(challengeDto.getChallengeTitle())
                    .challengeDesc(challengeDto.getChallengeDesc())
                    .challengeImg(challengeDto.getChallengeImg())
                    .startDay(challengeDto.getStartDay())
                    .endDay(challengeDto.getEndDay())
                    .period(challengeDto.getPeriod())
                    .weekCount(challengeDto.getWeekCount())
                    .totalCount(challengeDto.getTotalCount())
                    .challengeState(challengeDto.getChallengeState())
                    .build();
            challengeRepository.save(editedChallenge);
        }else {
            log.error("edit challenge error.");
        }
    }

    @Override
    public List<Challenge> getAllChallenge() {
        log.info("get all challenge");
        // 최신순으로 정렬
        return challengeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<Challenge> getChallengeById(Long id) {
        log.info("get challenge by challenge id {}.", id);
        return Optional.ofNullable(challengeRepository.findById(id).get());
    }

    @Override
    public void delChallenge(Long id) {
        log.info("delete challenge by id {}.", id);
        if(challengeRepository.findById(id).isPresent()) {
            challengeRepository.deleteById(id);
        }
    }

    @Transactional
    @Scheduled(cron = "0 0 0 * * *") // 매일 0시에 실행
    public void scheduler(){
        List<Challenge> list = challengeRepository.findAll();
        LocalDate today = LocalDate.now();

        list.forEach(challenge -> {
            if (challenge.getEndDay().isBefore(today) && challenge.getChallengeState() == 0){
                challenge.setChallengeState(1); //endDay 확인하고 state 변경(종료되면 1)
            }
        });
    }
}
