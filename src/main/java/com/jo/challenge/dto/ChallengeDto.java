package com.jo.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class ChallengeDto {
    private Long id;
    private String challengeTitle;
    private String challengeDesc;
    private String challengeImg;
    private LocalDate startDay;
    private LocalDate endDay;
    private int period;
    private int weekCount;
    private int totalCount;
    private int challengeCount;
    private int challengeState;
}
