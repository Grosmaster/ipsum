package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order implements Comparable, Serializable {

    private String id;
    private int weight;
    private double latitude;
    private double longitude;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime endTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime shippingTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime dischargingTime;

    public Order(int weight, double latitude, double longitude, LocalTime startTime, LocalTime endTime,
                 LocalTime shippingTime, LocalTime dischargingTime) {
        this.weight = weight;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startTime = startTime;
        this.endTime = endTime;
        this.shippingTime = shippingTime;
        this.dischargingTime = dischargingTime;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int compareTo(Object o) {
        Order order = (Order) o;
        return this.startTime.compareTo(order.getStartTime());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", weight=" + weight +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", shippingTime=" + shippingTime +
                ", dischargingTime=" + dischargingTime +
                '}';
    }
}
