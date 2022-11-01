package org.example.model;

public class WriteResponse {
    public Double getTotalTime() {
        return totalTime;
    }

    private Double totalTime;
    public WriteResponse(Double totalTime){
        this.totalTime = totalTime;
    }
}
