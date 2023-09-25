package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;

    //constructer that creates and id for each new Employee
    public Job(){
        id = nextId;
        nextId++;
    }

     //constructer with other input parameters
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    @Override
    public String toString() {
        String newLine = System.lineSeparator();

        this.name=(Objects.equals(name, ""))?"Data not available":name;
        String emp=(employer.getValue() == "")?"Data not available":employer.getValue();
        employer.setValue(emp);
        String loc=(location.getValue() == "")?"Data not available":location.getValue();
        location.setValue(loc);
        String pos=(positionType.getValue() == "")?"Data not available":positionType.getValue();
        positionType.setValue(pos);

        return newLine + "ID: " + id +
                newLine + "Name: " + name +
                newLine + "Employer: " + employer +
                newLine + "Location: " + location +
                newLine + "Position Type: " + positionType.getValue()  +
                newLine + "Core Competency: " +coreCompetency + newLine;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job job)) return false;
        return getId() == job.getId() && Objects.equals(getName(), job.getName()) && Objects.equals(getEmployer(), job.getEmployer()) && Objects.equals(getLocation(), job.getLocation()) && Objects.equals(getPositionType(), job.getPositionType()) && Objects.equals(getCoreCompetency(), job.getCoreCompetency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmployer(), getLocation(), getPositionType(), getCoreCompetency());
    }

}
