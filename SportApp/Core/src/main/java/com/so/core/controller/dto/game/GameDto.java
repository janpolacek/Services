/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.core.controller.dto.game;

import com.so.core.controller.dto.season.SeasonTournamentDTO;
import com.so.core.controller.dto.season.SeasonTournamentGroupDTO;
import com.so.core.controller.dto.season.SeasonTournamentLocationDTO;
import com.so.core.controller.dto.season.SeasonTournamentRoundDTO;

/**
 *
 * @author peter
 */
public class GameDto {

    private Integer id;
    private CompetitorTeamDto awayTeam;
    private CompetitorTeamDto homeTeam;
    private SeasonTournamentGroupDTO group;
    private SeasonTournamentLocationDTO location;
    private SeasonTournamentRoundDTO round;
    private SeasonTournamentDTO seasonTournament;
    private String name;
    private String startTime;
    private String realStart;
    private Boolean overtime;
    private Boolean finished;
    private Boolean contumated;

    public GameDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CompetitorTeamDto getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(CompetitorTeamDto awayTeam) {
        this.awayTeam = awayTeam;
    }

    public CompetitorTeamDto getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(CompetitorTeamDto homeTeam) {
        this.homeTeam = homeTeam;
    }

    public SeasonTournamentGroupDTO getGroup() {
        return group;
    }

    public void setGroup(SeasonTournamentGroupDTO group) {
        this.group = group;
    }

    public SeasonTournamentLocationDTO getLocation() {
        return location;
    }

    public void setLocation(SeasonTournamentLocationDTO location) {
        this.location = location;
    }

    public SeasonTournamentRoundDTO getRound() {
        return round;
    }

    public void setRound(SeasonTournamentRoundDTO round) {
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRealStart() {
        return realStart;
    }

    public void setRealStart(String realStart) {
        this.realStart = realStart;
    }

    public Boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Boolean getContumated() {
        return contumated;
    }

    public void setContumated(Boolean contumated) {
        this.contumated = contumated;
    }

    public SeasonTournamentDTO getSeasonTournament() {
        return seasonTournament;
    }

    public void setSeasonTournament(SeasonTournamentDTO seasonTournamentId) {
        this.seasonTournament = seasonTournamentId;
    }




}