/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.dal.core.repository.game;

import com.so.dal.core.model.Sports;
import com.so.dal.core.model.game.Penalty;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author peter
 */
@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Integer>{
    public List<Penalty> findBySports(Sports s);
}
