package com.example.testbot2.model;

import com.example.testbot2.enams.PetType;
import com.example.testbot2.enams.ProbationaryStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "owners_reports")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "name")
    private String name;

    @Column(name = "pet_type")
    @Enumerated(EnumType.STRING)
    private PetType petType;

    @Column(name = "photo_report")
    private byte[] photoReport;

    @Column(name = "string_report")
    private String stringReport;

    @Column(name = "last_report")
    private LocalDateTime dateOfLastReport;

    @Column(name = "start_probation")
    private LocalDateTime dateOfStartProbation;

    @Column(name = "end_probation")
    private LocalDateTime dateOfEndProbation;

    @Column(name = "probationary_status")
    @Enumerated(EnumType.STRING)
    private ProbationaryStatus probationaryStatus;
    @Column(name = "period_extend")
    private int periodExtend;

    public int getPeriodExtend() {
        return periodExtend;
    }

    public void setPeriodExtend(int periodExtend) {
        if (periodExtend >= 0 && periodExtend < 15)
            this.periodExtend = periodExtend;
    }

    public LocalDateTime getDateOfLastReport() {
        return dateOfLastReport;
    }

    public void setDateOfLastReport(LocalDateTime dateOfLastReport) {
        this.dateOfLastReport = dateOfLastReport;
    }

    public LocalDateTime getDateOfStartProbation() {
        return dateOfStartProbation;
    }

    public void setDateOfStartProbation(LocalDateTime dateOfStartProbation) {
        this.dateOfStartProbation = dateOfStartProbation;
    }

    public LocalDateTime getDateOfEndProbation() {
        return dateOfEndProbation;
    }

    public void setDateOfEndProbation(LocalDateTime dateOfEndProbation) {
        this.dateOfEndProbation = dateOfEndProbation;
    }

    public ProbationaryStatus getProbationaryStatus() {
        return probationaryStatus;
    }

    public void setProbationaryStatus(ProbationaryStatus probationaryStatus) {
        this.probationaryStatus = probationaryStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public byte[] getPhotoReport() {
        return photoReport;
    }

    public void setPhotoReport(byte[] photoReport) {
        this.photoReport = photoReport;
    }

    public String getStringReport() {
        return stringReport;
    }

    public void setStringReport(String stringReport) {
        this.stringReport = stringReport;
    }
}

