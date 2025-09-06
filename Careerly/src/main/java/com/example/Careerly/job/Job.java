package com.example.Careerly.job;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Job(){}
    public Job(int id, String title, String maxSalary, String minSalary, String description, String location) {
        this.id = id;
        this.title = title;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.description = description;
        this.location = location;
    }

//    public Job(String description, int id, String location, String maxSalarey, String minSalarey, String title) {
//        this.description = description;
//        this.id = id;
//        this.location = location;
//        this.maxSalarey = maxSalarey;
//        this.minSalarey = minSalarey;
//        this.title = title;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
