package tasks;

import model.DistributionCenter;
import model.Order;
import model.Resource;
import tasks.Flow;
import tasks.FlowComposer;
import tasks.Schedule;


import java.time.LocalTime;
import java.util.ArrayList;

public class DemoSchedule {
    public static void main(String[] args) {
        DistributionCenter distributionCenter = new DistributionCenter(1, 1, 2, LocalTime.of(8, 0), LocalTime.of(22, 0));
        Resource resource = new Resource(20, 60);
        Order[] orders;
        orders = new Order[3];
        orders[0] = new Order(1, 2, 2, LocalTime.of(15, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[1] = new Order(1, 3, 2.7, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[2] = new Order(1, 2.5, 2.5, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[3] = new Order(1, 2.3, 2.5, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[4] = new Order(1, 2.4, 2.5, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        Schedule schedule = new Schedule(distributionCenter, orders, resource);
        System.out.println(schedule.toString());
        schedule.calculate();

    }
}