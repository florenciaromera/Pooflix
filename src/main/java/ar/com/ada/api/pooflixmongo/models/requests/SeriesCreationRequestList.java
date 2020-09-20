package ar.com.ada.api.pooflixmongo.models.requests;

import java.util.List;

public class SeriesCreationRequestList {
    List<SeriesCreationRequest> seriesCreationRequest;

    public List<SeriesCreationRequest> getSeriesCreationRequest() {
        return seriesCreationRequest;
    }

    public void setSeriesCreationRequest(List<SeriesCreationRequest> seriesCreationRequest) {
        this.seriesCreationRequest = seriesCreationRequest;
    }    
}