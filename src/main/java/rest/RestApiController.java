package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Order;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class RestApiController {

    private final static String CREATE = "create";
    private final static String ORDER = "order";

    private ArrayList<Order> orders = new ArrayList<>();

    @RequestMapping("/"+CREATE+"/"+ORDER)
    public void createOrder(@RequestParam(value = "order")String jsonOrder, HttpServletResponse response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(jsonOrder, Order.class);
        orders.add(order);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }
}
