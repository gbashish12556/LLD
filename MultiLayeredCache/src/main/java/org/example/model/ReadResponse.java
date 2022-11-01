package org.example.model;

public class ReadResponse<Value> {

    public Value getValue() {
        return value;
    }

    private Value value;

    public Double getTotalTime() {
        return totalTime;
    }

    private Double totalTime;
    public ReadResponse(Value value, Double totalTime){
        this.value = value;
        this.totalTime  = totalTime;
    }
}
