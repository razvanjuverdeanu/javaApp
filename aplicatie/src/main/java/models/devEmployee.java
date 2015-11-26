package models;

import models.Employee;

/**
 * Created by razvan.juverdeanu on 11/19/15.
 */
public class devEmployee extends Employee {
    private String devlevel;
    String occupation = "dev";
    public devEmployee(String name, String surname, String CNP, String city, String address, String devlevel, String occupation) {
        super(name, surname, CNP, city, address,devlevel, occupation);

    }



    public String getDevlevel(){
        return devlevel;
    }
    public void setDevlevel(){
        this.devlevel = devlevel;
    }
    public String toString(){
        return  "\n Surname: " + getSurname() + "\n Name: " + getName()
                + "\n CNP: " + getCNP() + "\n City: " + getCity() + "\n Address: " + getAddress() + "\n Level: " + getDevlevel() + "Occupation: " + occupation;

    }
}
