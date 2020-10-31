package com.example.demo.controller;

import com.example.demo.model.Survey;
import com.example.demo.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SurveyController {
    @Autowired
    private SurveyService service;

    @RequestMapping(path="survey/getAll",method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> getProducts(){

        List<Survey> surveys = new ArrayList<Survey>();

        surveys = service.fetchSurvey();
        return new ResponseEntity<List<Survey>>(surveys, HttpStatus.OK);

    }


    @GetMapping("survey/getById/{id}")
    public ResponseEntity<Survey> getSurveyById(@PathVariable int id){
        Survey s =  service.getSurveyById(id).get();
        return new ResponseEntity<Survey>(s, HttpStatus.OK);
    }

    @PostMapping("survey/save")
    public ResponseEntity<Survey> addProduct (@RequestBody Survey survey){
        Survey s =   service.save(survey);
        return new ResponseEntity<Survey>(s, HttpStatus.OK);
    }

}
