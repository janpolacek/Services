package com.so.dal.core.model.registration;
// Generated 27.2.2017 18:41:18 by Hibernate Tools 4.3.1


import com.so.dal.core.model.Resource;
import com.so.dal.core.model.season.SeasonTournament;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RegistrationTeam generated by hbm2java
 */
@Entity
@Table(name="registrationTeam"
    ,catalog="sport_app_dev"
)
public class RegistrationTeam  implements java.io.Serializable {


     private Integer id;
     private Resource resource;
     private SeasonTournament seasonTournament;
     private String name;
     private String shortName;
     private Date createdTime;
     private Boolean isCancelled;
     private String color;
     private Boolean isVerify;
     private Set<RegistrationPlayer> registrationPlayers = new HashSet<RegistrationPlayer>(0);

    public RegistrationTeam() {
    }

	
    public RegistrationTeam(Resource resource, SeasonTournament seasonTournament, String name, String shortName, Date createdTime, Boolean isCancelled, String color, Boolean isVerify) {
        this.resource = resource;
        this.seasonTournament = seasonTournament;
        this.name = name;
        this.shortName = shortName;
        this.createdTime = createdTime;
        this.isCancelled = isCancelled;
        this.color = color;
        this.isVerify = isVerify;
    }
    public RegistrationTeam(Resource resource, SeasonTournament seasonTournament, String name, String shortName, Date createdTime, Boolean isCancelled, String color, Boolean isVerify, Set<RegistrationPlayer> registrationPlayers) {
       this.resource = resource;
       this.seasonTournament = seasonTournament;
       this.name = name;
       this.shortName = shortName;
       this.createdTime = createdTime;
       this.isCancelled = isCancelled;
       this.color = color;
       this.isVerify = isVerify;
       this.registrationPlayers = registrationPlayers;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idLogo", nullable=false)
    public Resource getResource() {
        return this.resource;
    }
    
    public void setResource(Resource resource) {
        this.resource = resource;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idSeasonTournament", nullable=false)
    public SeasonTournament getSeasonTournament() {
        return this.seasonTournament;
    }
    
    public void setSeasonTournament(SeasonTournament seasonTournament) {
        this.seasonTournament = seasonTournament;
    }

    
    @Column(name="name", nullable=false, length=1500)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="shortName", nullable=false, length=500)
    public String getShortName() {
        return this.shortName;
    }
    
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="createdTime", nullable=false, length=19)
    public Date getCreatedTime() {
        return this.createdTime;
    }
    
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    
    @Column(name="isCancelled", nullable=false)
    public Boolean isIsCancelled() {
        return this.isCancelled;
    }
    
    public void setIsCancelled(Boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    
    @Column(name="color", nullable=false, length=500)
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }

    
    @Column(name="isVerify", nullable=false)
    public Boolean isIsVerify() {
        return this.isVerify;
    }
    
    public void setIsVerify(Boolean isVerify) {
        this.isVerify = isVerify;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="registrationTeam")
    public Set<RegistrationPlayer> getRegistrationPlayers() {
        return this.registrationPlayers;
    }
    
    public void setRegistrationPlayers(Set<RegistrationPlayer> registrationPlayers) {
        this.registrationPlayers = registrationPlayers;
    }




}


