package com.example.testbot2.service;


import com.example.testbot2.enams.PetType;
import com.example.testbot2.enams.ProbationaryStatus;
import com.example.testbot2.model.Owner;
import com.example.testbot2.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public void saveNewDogOwner(Long chatId,
                                String name,
                                PetType petType,
                                LocalDateTime dateOfStartProbation,
                                LocalDateTime dateOfEndProbation,
                                LocalDateTime dateOfLastReport,
                                ProbationaryStatus probationaryStatus) {
        Owner owner = new Owner();
        owner.setChatId(chatId);
        owner.setName(name);
        owner.setPetType(petType);
        owner.setDateOfStartProbation(dateOfStartProbation);
        owner.setDateOfEndProbation(dateOfEndProbation);
        owner.setDateOfLastReport(dateOfLastReport);
        owner.setProbationaryStatus(ProbationaryStatus.ACTIVE);
        ownerRepository.save(owner);
    }

    public Owner findOwnerByChatId(Long chatId) {
        return ownerRepository.getOwnerByChatId(chatId);
    }

    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }


    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }
}

