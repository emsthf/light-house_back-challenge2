package com.jo.challenge.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserChallenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "challenge_id")
    private Challenge challenge;
    private Long userId;
    private int userChallengeCount;
    private int userChallengeState;
    private boolean userChallengeResult;
}
