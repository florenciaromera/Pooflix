package ar.com.ada.api.pooflixmongo.models.responses;

import org.bson.types.ObjectId;

public class GenericResponse {
    public ObjectId _id;
    public String message;
    public boolean isOk;

    public GenericResponse(){

    }

    public GenericResponse(ObjectId id, String message, boolean isOk){
        this._id = id;
        this.message = message;
        this.isOk = isOk;
    }
}
