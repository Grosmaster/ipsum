package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Resource {

    private int capacity;
    private double speed;

    public Resource(int capacity, double speed) {
        this.capacity = capacity;
        this.speed = speed;
    }

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
