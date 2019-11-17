package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource {

    private int capacity;
    private double speed;

    public double getSpeedMetersSecond() {
        return speed * 1000 / 3600;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "capacity=" + capacity +
                ", speed=" + speed +
                '}';
    }

}
