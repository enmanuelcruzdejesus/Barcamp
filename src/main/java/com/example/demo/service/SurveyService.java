package com.example.demo.service;

import com.example.demo.model.Survey;
import com.example.demo.repo.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepo repo;

    public SurveyService(){

    }

    public List<Survey> fetchSurvey(){
        return  repo.findAll();
    }

    public Optional<Survey> getSurveyById(int id){
        return repo.findById(id);
    }

    public Survey save(Survey p){

        return repo.save(p);
    }

    public void delete(int id){
        this.repo.deleteById(id);
    }
}
