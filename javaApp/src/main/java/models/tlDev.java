package models;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
public class tlDev extends devEmployee {
    private String coordonateTeamDev;
    String occupation = "tldev";



    public tlDev(String name, String surname, String CNP, String city, String address, String devLevel, String coordonateTeamDevl, String occupation) {
        super(name, surname, CNP, city, address, devLevel, occupation);
        this.coordonateTeamDev = coordonateTeamDev;
    }
    @Override
    public String toString(){
        return "Coordonate QA members: " + coordonateTeamDev + "Dev Level: " + getDevlevel()
                + "\n Surname: " + getSurname() + "\n Name: " + getName()
                + "\n CNP: " + getCNP() + "\n City: " + getCity() + "\n Address: " + getAddress();
    }

}
