//package com.so.core.controller.webservices.season;
//
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.so.core.controller.dto.season.SeasonTournamentPeriodDTO;
//import com.so.dal.core.model.season.SeasonTournamentPeriod;
//import com.so.core.services.season.SeasonTournamentPeriodService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.util.LinkedList;
//import java.util.List;
//
//@RestController
//
//@RequestMapping("/seasontournamentperiod")
//public class SeasonTournamentPeriodController {
//
//    @Autowired
//    SeasonTournamentPeriodService seasonTournamentPeriodService;
//
//    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public String getSeasonTournaments(@RequestParam(value = "q", required = false) String query) {
//        List<SeasonTournamentPeriod> seasonTournamentPeriods;
//        List<SeasonTournamentPeriodDTO> seasonTournamentPeriodDTOS = new LinkedList<SeasonTournamentPeriodDTO>();
//        JsonObject jo = new JsonObject();
//        Gson gson = new Gson();
//
//        if (query != null) {
//            seasonTournamentPeriods = seasonTournamentPeriodService.findByNameContaining(query);
//            jo.addProperty("query", query);
//
//        } else {
//            seasonTournamentPeriods = seasonTournamentPeriodService.findAll();
//        }
//
//        for (SeasonTournamentPeriod st : seasonTournamentPeriods) {
//            seasonTournamentPeriodDTOS.add(new SeasonTournamentPeriodDTO(st));
//        }
//
//        jo.addProperty("length", seasonTournamentPeriodDTOS.size());
//        jo.add("results", gson.toJsonTree(seasonTournamentPeriodDTOS));
//
//        return jo.toString();
//    }
//
//    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public String getSeasonTournament(@PathVariable(value = "id") Integer id) {
//
//        SeasonTournamentPeriod seasonTournamentPeriod;
//        SeasonTournamentPeriodDTO seasonTournamentPeriodDTO;
//        Gson gson = new Gson();
//
//        seasonTournamentPeriod = seasonTournamentPeriodService.findById(id);
//        seasonTournamentPeriodDTO = new SeasonTournamentPeriodDTO(seasonTournamentPeriod);
//
//        return gson.toJson(seasonTournamentPeriodDTO);
//    }
//
//    /*
//     {
//     "id": 1,
//     "seasonTournamentId": 1,
//     "name": "Tretina",
//     "length": "21:21:11"
//     }
//     */
//    @RequestMapping(path = "/", method = RequestMethod.POST)
//    public ResponseEntity createSeasonTournament(@RequestBody SeasonTournamentPeriodDTO st) {
//
//        if (st == null) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//        Boolean status = null;
//
//        try {
//            status = seasonTournamentPeriodService.createSeasonTournamentPeriod(st.getSeasonTournamentId(), st.getName(), st.getLengthDate(), st.getIsGoldPart());
//        } catch (ParseException e) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//
//        if (status) {
//            return new ResponseEntity(HttpStatus.OK);
//        } else {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//}
