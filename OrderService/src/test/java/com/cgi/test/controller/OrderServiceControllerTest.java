package com.cgi.test.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.cgi.OrderService.controller.OrderServiceController;
import com.cgi.OrderService.model.Boxes;
import com.cgi.OrderService.model.Order;
import com.cgi.OrderService.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceControllerTest {
	
//	private MockMvc mockMvc;
//
//	private Order order;
//	private Boxes boxes;
//	private List<Boxes> boxeslist;
//
//	@MockBean
//    private OrderService orderService;
//
//    @InjectMocks
//    private OrderServiceController orderController;
//
//    @SuppressWarnings("deprecation")
//	@BeforeEach
//    public void setUp() {
//
//      MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
//
//        order = new Order();
//        order.setOrderId(1);
//        order.setOrder_number(1213283);
//        order.setGross_weight(123);
//        order.setTracking_number(76538);
//        order.setCreation_date(2022-02-8);
//        order.setDriver("aditya");
//        order.setReceivedBy("Bob");
//        order.setReceptionSig("True");
//        order.setOrderStatus("False");
//        order.setWarehouse_id(100);
//        order.setList_box(boxeslist);
//        order.setComment("This is order service");
//
//
//        boxes = new Boxes();
//        boxes.setBox_id(12);
//        boxes.setSku("Box number 1234");
//        boxes.setProduct_name("Wine");
//        boxes.setBox_type("Large box");
//        boxes.setQty_per_box(4);
//
//        boxeslist = new ArrayList<>();
//        boxeslist.add(boxes);
//
//    }
//    @Test
//    public void addOrderSuccess() throws Exception {
//    	when(orderService.addOrder(any())).thenReturn(order);
//    	System.out.println("test.............");
//		mockMvc.perform(post("/OrderService/addOrder").contentType(MediaType.APPLICATION_JSON).content(asJsonString(order)))
//		.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//
//
//    }
//
//    @Test
//    public void addNewsFailure() throws Exception {
//        when(orderService.addOrder(any())).thenReturn(order);
//        mockMvc.perform(MockMvcRequestBuilders.post("/OrderService/addOrder").contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(order)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//
//    @Test
//    public void deleteOrderSuccess() throws Exception {
//
//        when(orderService.deleteOrder(order.getOrderId())).thenReturn(order);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/OrderService/deleteOrder")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void deleteNewsFailure() throws Exception {
//
//        when(orderService.deleteOrder(order.getOrderId())).thenReturn(order);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/OrderService/deleteOrder")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//
//
//
//
//
//
//
//    private static String asJsonString(final Object obj) {
//        try {
//        	ObjectMapper objmapper = new ObjectMapper();
//        	objmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        	objmapper.registerModule(new JavaTimeModule());
//            return objmapper.writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//

	
	

}
