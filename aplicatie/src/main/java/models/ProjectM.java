package models;

import models.Employee;

/**
 * Created by razvan.juverdeanu on 11/19/15.
 */
public class ProjectM extends Employee {
    private String projectName;
    String occupation = "projectmanager";
    public ProjectM(String name, String surname, String CNP, String city, String address, String projectName,String level, String occupation) {
        super(name, surname, CNP, city, address,level,occupation);
        this.projectName = projectName;
    }



    @Override
    public String toString(){
        return  "Project name: " + projectName + "\n Surname: " + getSurname() + "\n Name: " + getName()
                + "\n CNP: " + getCNP() + "\n City: " + getCity() + "\n Address: " + getAddress();
    }
}
