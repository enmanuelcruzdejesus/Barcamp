package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Survey {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRatingQ1() {
        return ratingQ1;
    }

    public void setRatingQ1(int ratingQ1) {
        this.ratingQ1 = ratingQ1;
    }

    public int getRatingQ2() {
        return ratingQ2;
    }

    public void setRatingQ2(int ratingQ2) {
        this.ratingQ2 = ratingQ2;
    }

    public int getRatingQ3() {
        return ratingQ3;
    }

    public void setRatingQ3(int ratingQ3) {
        this.ratingQ3 = ratingQ3;
    }

    public String getRatingQ4() {
        return ratingQ4;
    }

    public void setRatingQ4(String ratingQ4) {
        this.ratingQ4 = ratingQ4;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    private int ratingQ1;
    private int ratingQ2;
    private int ratingQ3;
    private String ratingQ4;
    private Date created;
    private String userid;



    public Survey(int ratingQ1, int ratingQ2, int ratingQ3, String ratingQ4) {

        this.ratingQ1 = ratingQ1;
        this.ratingQ2 = ratingQ2;
        this.ratingQ3 = ratingQ3;
        this.ratingQ4 = ratingQ4;
        this.created = new Date();

    }




    public Survey(){






    }
}
