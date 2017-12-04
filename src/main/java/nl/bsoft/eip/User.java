package nl.bsoft.eip;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    private int id;
    private String Voornaam;
    private String Tussenvoegsel;
    private String Achternaam;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaam() {
        return Voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.Voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return Tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.Tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.Achternaam = achternaam;
    }

}
