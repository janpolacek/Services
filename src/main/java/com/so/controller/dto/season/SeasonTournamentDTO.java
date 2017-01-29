package com.so.controller.dto.season;

import com.so.dal.model.season.SeasonTournament;

public class SeasonTournamentDTO{

    private Integer id;
    private Integer seasonId;
    private Integer tournamentId;
    private String name;

    public SeasonTournamentDTO() {
    }

    public SeasonTournamentDTO (SeasonTournament st) {
        this.id = st.getId();
        this.seasonId = st.getSeason().getId();
        this.tournamentId = st.getTournament().getId();
        this.name = st.getName();
    }

    public SeasonTournamentDTO ( Integer seasonId, Integer tournamentId, String name) {
        this.seasonId = seasonId;
        this.tournamentId = tournamentId;
        this.name = name;
    }

    public SeasonTournamentDTO ( String seasonId, String tournamentId, String name) {
        this.seasonId = Integer.parseInt(seasonId);
        this.tournamentId = Integer.parseInt(tournamentId);
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}