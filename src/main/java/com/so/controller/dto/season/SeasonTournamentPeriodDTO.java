package com.so.controller.dto.season;

import com.so.dal.model.season.SeasonTournamentPeriod;
import com.so.dal.model.season.SeasonTournamentRound;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by janpolacek on 1/28/17.
 */
public class SeasonTournamentPeriodDTO {
    private Integer id;
    private Integer seasonTournamentId;
    private String name;
    private String length;

    public SeasonTournamentPeriodDTO() {
    }

    public SeasonTournamentPeriodDTO(Integer seasonTournamentId, String name, String length) {
        this.seasonTournamentId = seasonTournamentId;
        this.name = name;
        this.length = length;
    }

    public SeasonTournamentPeriodDTO(SeasonTournamentPeriod st) {
        this.id = st.getId();
        this.seasonTournamentId = st.getId();
        this.name = st.getName();
        this.length = st.getLength().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeasonTournamentId() {
        return seasonTournamentId;
    }

    public void setSeasonTournamentId(Integer seasonTournamentId) {
        this.seasonTournamentId = seasonTournamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public Date getLengthDate() throws ParseException {
        String str_date= this.getLength();
        DateFormat formatter ;
        Date date ;
        formatter = new SimpleDateFormat("hh:mm:ss");
        date = formatter.parse(str_date);
        return date;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
