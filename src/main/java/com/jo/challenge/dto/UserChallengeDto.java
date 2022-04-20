package com.jo.challenge.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserChallengeDto {
    private Long id;
    private Long challengeId;
    private Long userId;
    private Long postId;
    private int userChallengeCount;
    private int userChallengeState;
    private int userChallengeTotalCount;
    private int weekCount;
}
