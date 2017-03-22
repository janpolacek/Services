/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.core.controller.converter;

import com.so.core.controller.dto.ResourceDto;
import com.so.core.controller.dto.registration.RegistrationPlayerDto;
import com.so.core.controller.dto.registration.RegistrationTeamDto;
import com.so.dal.core.model.registration.RegistrationPlayer;
import com.so.dal.core.model.registration.RegistrationTeam;
import com.so.dal.core.model.season.SeasonTournament;
import com.so.dal.core.repository.ResourceRepository;
import com.so.dal.core.repository.registration.RegistrationPlayerRepository;
import com.so.dal.core.repository.registration.RegistrationTeamRepository;
import com.so.dal.core.repository.season.SeasonTournamentRepository;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author peter
 */
@Service
public class RegistrationConverter {

    private final static Logger LOG = LoggerFactory.getLogger(RegistrationConverter.class);

    @Autowired
    private RegistrationTeamRepository regTeamRepo;

    @Autowired
    private RegistrationPlayerRepository regPlayerRepo;

    @Autowired
    private SeasonTournamentRepository seasonTournamentRepo;

    @Autowired
    private ResourceRepository resourceRepo;

    public RegistrationPlayer regPlayerDtoToEntity(RegistrationPlayerDto dto) {
        RegistrationPlayer entity;

        if (dto.getId() != null) {
            entity = regPlayerRepo.findOne(dto.getId());
        } else {
            entity = new RegistrationPlayer();
        }
        if (dto.getRegistrationTeam() != null) {
            entity.setRegistrationTeam(regTeamRepo.findOne(dto.getRegistrationTeam()));
        }

        entity.setBirthDate(dto.getBirthDate());
        entity.setIsProfessional(dto.getIsProfessional());
        entity.setIsStudent(dto.getIsStudent());
        entity.setIsVerified(dto.getIsVerified());
        entity.setMail(dto.getMail());
        entity.setName(dto.getName());
        entity.setNote(dto.getNote());
        entity.setNumber(dto.getNumber());
        entity.setPhone(dto.getPhone());
        entity.setSex(dto.getSex());
        entity.setSurname(dto.getSurname());

        return entity;
    }

    public RegistrationTeam regTeamDtoToEntity(RegistrationTeamDto dto, Boolean ifCopyPlayers) {

        RegistrationTeam entity;

        if (dto.getId() != null) {
            entity = regTeamRepo.findOne(dto.getId());
        } else {
            entity = new RegistrationTeam();
        }

        SeasonTournament st = seasonTournamentRepo.findOne(dto.getSeasonTournamentId());
        if (st == null) {
            LOG.error(" chyba v konvertore regTeam, nenajdeny seasonTournament s id={}  koncim spracovanie", dto.getSeasonTournamentId());
            throw new IllegalStateException("nenajdeny seasonTournament s id=" + dto.getSeasonTournamentId());
        }
        if (dto.getZnak().getId() != null) {
            entity.setResource(resourceRepo.findOne(dto.getZnak().getId()));
        }

        entity.setColor(dto.getColor());
        entity.setCreatedTime(dto.getCreatedTime());
        entity.setIsCancelled(dto.getIsCancelled());
        entity.setIsVerify(dto.getIsVerify());
        entity.setName(dto.getName());
        entity.setSeasonTournament(st);

        entity.setShortName(dto.getShortName());

        if (ifCopyPlayers) {
            Set<RegistrationPlayer> set = new HashSet<RegistrationPlayer>();
            for (RegistrationPlayerDto player : dto.getRegistrationPlayers()) {
                set.add(regPlayerDtoToEntity(player));
            }
            entity.setRegistrationPlayers(set);
        }
        return entity;
    }

    public RegistrationPlayerDto regPlayerEntityToDto(RegistrationPlayer entity) {
        RegistrationPlayerDto dto = new RegistrationPlayerDto();

        dto.setBirthDate(entity.getBirthDate());
        dto.setId(entity.getId());
        dto.setIsProfessional(entity.isIsProfessional());
        dto.setIsVerified(entity.isIsVerified());
        dto.setIsStudent(entity.isIsStudent());
        dto.setMail(entity.getMail());
        dto.setName(entity.getName());
        dto.setNote(entity.getNote());
        dto.setNumber(entity.getNumber());
        dto.setPhone(entity.getPhone());
        dto.setRegistrationTeam(entity.getRegistrationTeam().getId());
        dto.setSex(entity.getSex());
        dto.setSurname(entity.getSurname());

        return dto;
    }

    public RegistrationTeamDto regTeamEntityToDto(RegistrationTeam entity) {
        RegistrationTeamDto dto = new RegistrationTeamDto();

        dto.setColor(entity.getColor());
        dto.setCreatedTime(entity.getCreatedTime());
        dto.setId(entity.getId());
        dto.setIsCancelled(entity.isIsCancelled());
        dto.setIsVerify(entity.isIsVerify());
        dto.setName(entity.getName());
        dto.setSeasonTournamentId(entity.getSeasonTournament().getId());
        dto.setShortName(entity.getShortName());
        dto.setZnak(new ResourceDto(entity.getResource().getId(), entity.getResource().getPath()));
        dto.setRegistrationPlayers(new HashSet<RegistrationPlayerDto>());
        for (RegistrationPlayer player : entity.getRegistrationPlayers()) {
            dto.getRegistrationPlayers().add(regPlayerEntityToDto(player));
        }
        return dto;
    }
}