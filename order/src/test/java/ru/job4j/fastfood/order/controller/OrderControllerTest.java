package ru.job4j.fastfood.order.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.fastfood.domain.model.Customer;
import ru.job4j.fastfood.order.dto.OrderPlacementDto;
import ru.job4j.fastfood.order.service.OrderService;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    private ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    public void whenPlace() throws Exception {
        OrderPlacementDto dto = new OrderPlacementDto(new ArrayList<>(), new Customer());
        String requestBody = objectWriter.writeValueAsString(dto);
        mockMvc.perform(
                post("/order/place")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void whenComplete() throws Exception {
        int orderId = 1;
        String requestUrl = String.format("/order/%d/complete", orderId);
        mockMvc.perform(
                patch(requestUrl)
        ).andExpect(status().isOk());
    }

    @Test
    public void whenPutOnHold() throws Exception {
        int orderId = 1;
        String requestUrl = String.format("/order/%d/putOnHold", orderId);
        mockMvc.perform(
                patch(requestUrl)
        ).andExpect(status().isOk());
    }

    @Test
    public void whenCancel() throws Exception {
        int orderId = 1;
        String requestUrl = String.format("/order/%d/cancel", orderId);
        mockMvc.perform(
                patch(requestUrl)
        ).andExpect(status().isOk());
    }
}