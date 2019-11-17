package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class RestApiController {

    private final static String CREATE = "/create";
    private final static String GET = "/get";
    private final static String ORDERS = "/orders";
    private final static String ORDER = "/order";

    private HashMap<String, Order> orders = new HashMap<>();

    @RequestMapping(value = CREATE+ORDER, method = RequestMethod.POST)
    public void createOrder(@RequestBody String jsonOrder, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Order order = objectMapper.readValue(jsonOrder, Order.class);
        orders.put(order.getId(), order);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @ResponseBody
    @RequestMapping(value = GET + ORDERS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Order> getOrders(){
        return orders.values();
    }

    @ResponseBody
    @RequestMapping(value = GET + ORDER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getOrder(@RequestParam(value = "orderId") String orderId){
        return orders.get(orderId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }
}
