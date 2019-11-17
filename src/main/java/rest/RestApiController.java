package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.DistributionCenter;
import model.Order;
import model.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tasks.Flow;
import tasks.FlowComposer;
import tasks.Schedule;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {

    private final static String CREATE = "/create";
    private final static String DELETE = "/delete";
    private final static String ORDERS = "/orders";
    private final static String RESOURCE = "/resource";
    private final static String DISTRIBUTION_CENTER = "/distribution_center";
    private final static String ORDER = "/order";

    private final static String FLOW = "/flow";
    private final static String FLOW_COMPOSER = "/flow_composer";
    private final static String SCHEDULE = "/schedule";

    private ObjectMapper objectMapper = new ObjectMapper();
    private HashMap<String, Order> orders = new HashMap<>();
    private Resource resource;
    private DistributionCenter distributionCenter;

    @RequestMapping(value = CREATE + ORDER, method = RequestMethod.POST)
    public void createOrder(@RequestBody String jsonOrder, HttpServletResponse response)
            throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        Order order = objectMapper.readValue(jsonOrder, Order.class);
        orders.put(order.getId(), order);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @ResponseBody
    @RequestMapping(value = ORDERS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Order> getOrders() {
        return orders.values();
    }

    @ResponseBody
    @RequestMapping(value = ORDER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@RequestParam(value = "orderId") String orderId) {
        return orders.get(orderId);
    }

    @RequestMapping(value = DELETE, method = RequestMethod.DELETE)
    public void deleteOrders(@RequestParam(value = "orderIds") List<String> orderIds,
                             HttpServletResponse response) {
        orderIds.forEach((order) -> orders.remove(order));
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = CREATE + RESOURCE, method = RequestMethod.POST)
    public void createResource(@RequestBody String jsonResource, HttpServletResponse response)
            throws IOException {
        resource = objectMapper.readValue(jsonResource, Resource.class);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @ResponseBody
    @RequestMapping(value = RESOURCE, method = RequestMethod.GET)
    public Resource getResource(HttpServletResponse response) {
        if (resource == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return resource;
    }

    @RequestMapping(value = DELETE + RESOURCE, method = RequestMethod.DELETE)
    public void deleteResource(HttpServletResponse response) {
        resource = null;
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @RequestMapping(value = CREATE + DISTRIBUTION_CENTER, method = RequestMethod.POST)
    public void createDistributionCenter(@RequestBody String jsonDistrCenter, HttpServletResponse response)
            throws IOException {
        distributionCenter = objectMapper.readValue(jsonDistrCenter, DistributionCenter.class);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @ResponseBody
    @RequestMapping(value = DISTRIBUTION_CENTER, method = RequestMethod.GET)
    public DistributionCenter getDistributionCenter(HttpServletResponse response) {
        if (distributionCenter == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return distributionCenter;
    }

    @RequestMapping(value = DELETE + DISTRIBUTION_CENTER, method = RequestMethod.DELETE)
    public void deleteDistributionCenter(HttpServletResponse response) {
        distributionCenter = null;
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @ResponseBody
    @RequestMapping(value = FLOW, method = RequestMethod.GET)
    public String runFlow() {
        Flow flow = new Flow(distributionCenter, (Order[]) orders.values().toArray(), resource);
        return flow.toString();
    }

    @ResponseBody
    @RequestMapping(value = FLOW_COMPOSER, method = RequestMethod.GET)
    public String runFlowComposer() {
        FlowComposer flowComposer = new FlowComposer(distributionCenter, (Order[]) orders.values().toArray(), resource);
        Flow flow = new Flow(distributionCenter, flowComposer.calculate(), resource);
        return flow.toString();
    }

    @ResponseBody
    @RequestMapping(value = SCHEDULE, method = RequestMethod.GET)
    public String runSchedule() {
        Schedule schedule = new Schedule(distributionCenter, (Order[]) orders.values().toArray(), resource);
        return schedule.toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }
}
