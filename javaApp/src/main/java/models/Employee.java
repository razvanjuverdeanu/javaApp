package models;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
/* *
 * Created by razvan.juverdeanu on 11/18/15.
 */
public class Employee {
    private String name;
    private String surname;
    private String CNP;
    private String city;
    private String address;
    private String level;
    private String occupation;


     /*
    @param name
    @param surname
    @param CNP
    @param city
    @param address
    @return
     */


    public Employee(String name,String surname,String CNP, String city,String address,String level, String occupation)
    {
        this.address = address;
        this.city = city;
        this.CNP = CNP;
        this.name = name;
        this.surname = surname;
        this.occupation = occupation;
        this.level = level;
    }



    public String getOccupation(){return occupation;}
    public void setOccupation(){this.occupation = occupation;}
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(){
        this.surname = surname;
    }
    public String getCity(){
        return city;
    }
    public void setCity(){
        this.city = city;
    }
    public String getCNP(){
        return  CNP;
    }
    public void setCNP(){
        this.CNP = CNP;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(){
        this.address = address;
    }
    public String getLevel(){
        return level;
    }
    public void setLevel(){
        this.level = level;
    }

    public String toString()
    {

        return  "Surname: " + surname + "\n Name: " + name + "\n CNP: " + CNP +
                "\n City: " + city + "\n Address: " + address  ;

    }


}