package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistributionCenter {

    private double latitude;
    private double longitude;
    private int sizeResources;
    private LocalTime startTime;
    private LocalTime endTime;

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
