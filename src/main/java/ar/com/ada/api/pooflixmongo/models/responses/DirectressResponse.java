package ar.com.ada.api.pooflixmongo.models.responses;

import java.util.Date;

public class DirectressResponse {
    public String name;
    public Date birthDate;
    public String nationality;

    public DirectressResponse(){

    }
    public DirectressResponse(String name, Date birthDate, String nationality){
        this.name = name;
        this.birthDate = birthDate;
        this.nationality = nationality;
    }
}
