package tasks;

import model.DistributionCenter;
import model.Order;
import model.Resource;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class FlowComposerTest {

    DistributionCenter distributionCenter;
    Resource resource;
    Order[] orders;

    @Before
    public void init() {
        distributionCenter = new DistributionCenter(1, 1, 1, LocalTime.of(8, 0), LocalTime.of(22, 0));
        resource = new Resource(20, 60);
        orders = new Order[3];
        orders[0] = new Order(1, 8, 2, LocalTime.of(15, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[1] = new Order(1, 3, 2.7, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[2] = new Order(1, 4.8, 2.5, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));

    }

    @Test
    public void calculateTest() {
        Flow flow = new Flow(distributionCenter, orders, resource);
        flow.calculate();
        long flowTime = Duration.between(flow.getStart(), flow.getEnd()).get(ChronoUnit.SECONDS);
        FlowComposer flowComposer = new FlowComposer(distributionCenter, orders, resource);
        flow.setOrders(flowComposer.calculate());
        flow.calculate();
        long composerTime = Duration.between(flow.getStart(), flow.getEnd()).get(ChronoUnit.SECONDS);
        assertTrue(flowTime >= composerTime);
    }
}