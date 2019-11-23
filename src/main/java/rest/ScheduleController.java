package rest;

import dto.ScheduleDTO;
import model.DistributionCenter;
import model.Order;
import model.Resource;
import org.springframework.web.bind.annotation.*;
import tasks.Schedule;

import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    @PostMapping(value = "/exec")
    public String execSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule(scheduleDTO.getDistributionCenter(), scheduleDTO.getOrders(),
                scheduleDTO.getResource());
        return schedule.toString();
    }

    @GetMapping(value = "/dto")
    public ScheduleDTO getScheduleDTO() {
        DistributionCenter distributionCenter = new DistributionCenter(1, 1, 2, LocalTime.of(8, 0), LocalTime.of(22, 0));
        Resource resource = new Resource(20, 60);
        Order[] orders;
        orders = new Order[3];
        orders[0] = new Order(1, 2, 2, LocalTime.of(15, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[1] = new Order(1, 3, 2.7, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        orders[2] = new Order(1, 2.5, 2.5, LocalTime.of(8, 0), LocalTime.of(22, 0), LocalTime.of(0, 5), LocalTime.of(0, 5));
        return new ScheduleDTO(distributionCenter, orders, resource);
    }

    @GetMapping(value = "/")
    public String ping() {
        return "OK";
    }
}
