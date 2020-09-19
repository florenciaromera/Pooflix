package ar.com.ada.api.pooflixmongo.entities;

public class MediaContent {
    private Double timeWatch;
    private Integer clasification;
    private boolean watched;

    public void pause(){

    }

    public void play(){

    }
    
    public Double getTimeWatch() {
        return timeWatch;
    }

    public void setTimeWatch(Double timeWatch) {
        this.timeWatch = timeWatch;
    }

    public Integer getClasification() {
        return clasification;
    }

    public void setClasification(Integer clasification) {
        this.clasification = clasification;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
    
}
