package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestApiController {

    private final static String SLASH = "/";
    private final static String CREATE = "/create";
    private final static String GET = "/get";
    private final static String ORDER = "/order";
    private final static String ALL = "all/";

    private ArrayList<Order> orders = new ArrayList<>();

    @RequestMapping(value = CREATE+ORDER, method = RequestMethod.POST)
    public void createOrder(@RequestBody String jsonOrder, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Order order = objectMapper.readValue(jsonOrder, Order.class);
        orders.add(order);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @ResponseBody
    @RequestMapping(value = GET + ORDER, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders(){
        System.out.println(orders.get(0));
        return orders;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }
}
