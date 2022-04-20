package com.jo.challenge.dto;

import com.jo.challenge.model.UserChallenge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_challenge_id")
    private UserChallenge userChallenge;
    private LocalDate checkDate;
    private int week;
    private Long postId;

    public Doing(UserChallenge userChallenge, LocalDate checkDate, int week, Long postId) {
        this.userChallenge = userChallenge;
        this.checkDate = checkDate;
        this.week = week;
        this.postId = postId;
    }
}
