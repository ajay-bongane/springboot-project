package com.example.gamification.game;


import com.example.gamification.game.domain.LeaderBoardRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/leaders")
@RequiredArgsConstructor
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;

    @GetMapping
    public List<LeaderBoardRow> getLeaders(){
        log.info("Retrieving leaderboard");
        return leaderBoardService.getCurrentLeaderBoard();
    }
}
