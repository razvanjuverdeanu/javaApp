package models;

/**
 * Created by razvan.juverdeanu on 11/24/15.
 */
public class tlQa extends qaEmployee{
    private String coordonateTeamQa;
    String occupation = "tlqa";


    public tlQa(String name, String surname, String CNP, String city,
                String address, String qaLevel, String coordonateTeamQa, String occupation) {
        super(name, surname, CNP, city, address, qaLevel, occupation);
        this.coordonateTeamQa = coordonateTeamQa;
    }

    @Override
    public String toString(){
        return  "Coordonate dev members:" + coordonateTeamQa +  "\n QA Level: " + getQaLevel() + "\n Surname: "
                + getSurname() + "\n Name: " + getName() + "\n CNP: " + getCNP() + "\n City: " + getCity()
                + "\n Address: " + getAddress();
    }
}
