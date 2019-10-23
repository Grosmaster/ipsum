package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tasks.Flow;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class DistributionCenterTest {

    private static DistributionCenter distributionCenter;
    private static Resource resource;

    @BeforeAll
    static void setup() {
        distributionCenter = new DistributionCenter(2, 2, 1, LocalTime.of(8, 0), LocalTime.of(22, 0));
        resource = new Resource(20, 60);
    }

    @Test
    void oneOrder() {
        Order[] orders = new Order[1];
        orders[0] = new Order(1, 2, 50, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        Flow flow = new Flow(distributionCenter, orders, resource);
        LocalTime startTime = LocalTime.of(14, 59, 36);
        LocalTime endTime = LocalTime.of(1, 0, 24);

        assertEquals(flow.getStart(), startTime);
        assertEquals(flow.getEnd(), endTime);
        System.out.println("Success");
    }

    @Test
    void threeOrders() {
        Order[] orders = new Order[3];
        orders[0] = new Order(1, 2.0001, 2.0001, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[1] = new Order(1, 2.0001, 2.0002, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[2] = new Order(1, 2.0002, 2.0001, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        Flow flow = new Flow(distributionCenter, orders, resource);
        flow.setOrders(orders);
        flow.calculate();

        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(8, 30, 1);
        assertEquals(flow.getStart(), startTime);
        assertEquals(flow.getEnd(), endTime);
        System.out.println("Success");
    }

    @Test
    void threeOrdersTwo(){
        Order[] orders = new Order[3];
        orders[0] = new Order(1, 2.1, 2.1, LocalTime.of(9, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[1] = new Order(1, 2.2, 2.2, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[2] = new Order(1, 2.3, 2.3, LocalTime.of(10, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        Flow flow = new Flow(distributionCenter, orders, resource);
        flow.setOrders(orders);
        flow.calculate();

        LocalTime startTime = LocalTime.of(8, 29, 17);
        LocalTime endTime = LocalTime.of(10, 52,10);
        assertEquals(flow.getStart(), startTime);
        assertEquals(flow.getEnd(), endTime);
        System.out.println("Success");
    }
}