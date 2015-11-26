package models;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
public class qaEmployee extends Employee{
    private String occupation="qa";
    private String qalevel;

    public qaEmployee(String name, String surname, String CNP, String city, String address, String qaLevel, String occupation) {
        super(name, surname, CNP, city, address,qaLevel, occupation);

    }

    public String getQaLevel(){
        return qalevel;
    }
    public void setQaLevel(){
        this.qalevel = qalevel;
    }
    @Override
    public String toString(){

        return  "Surname: " + getSurname() + "\n Name: " + getName()
                + "\n CNP: " + getCNP() + "\n City: " + getCity() + "\n Address: " + getAddress() + "\n Level :" + qalevel + "Occupation: " + occupation;

    }
}
