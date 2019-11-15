package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class DistributionCenter {

    private double latitude;
    private double longitude;
    private int sizeResources;
    private LocalTime startTime;
    private LocalTime endTime;

    public DistributionCenter(double latitude, double longitude, int sizeResources, LocalTime startTime, LocalTime endTime) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.sizeResources = sizeResources;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "DistributionCenter{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", sizeResources=" + sizeResources +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

}
