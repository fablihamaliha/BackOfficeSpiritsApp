package com.cgi.test.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgi.OrderService.model.Boxes;
import com.cgi.OrderService.model.Order;
import com.cgi.OrderService.repository.OrderRepository;

public class OrderRepositoryTest {
	
//	@Autowired
//	private OrderRepository orderrepo;
//
//	private Order order;
//	private Boxes boxes;
//	private List<Boxes> boxeslist;
//
//	@BeforeEach
//	public void setUp() {
//		order = new Order();
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
//
//
//	}
//
//	@AfterEach
//	public void tearDown() {
//		orderrepo.deleteAll();
//	}
//
//	@Test
//    public void AddOrderTest() {
//		orderrepo.insert(order);
//        List<Boxes> allorder = orderrepo.findById(1).get().getList_box();
//        assertEquals(boxeslist.get(1).getBox_id(),is(allorder.get(1).getBox_id()) );
//    }
//
//	@Test
//    public void deleteOrderTest() {
//		orderrepo.insert(order);
//        List<Boxes> allorder = orderrepo.findById(1).get().getList_box();
//        assertEquals(boxeslist.get(1).getBox_id(),is(allorder.get(1).getBox_id()) );
//        Iterator<Boxes> iterator = allorder.listIterator();
//        while (iterator.hasNext()) {
//            boxes = iterator.next();
//            if (boxes.getBox_id() == 1)
//                iterator.remove();
//        }
//
//       // userNews.setNewslist(allNews);
//        //newsRepository.save(userNews);
//
//        allorder = orderrepo.findById(1).get().getList_box();
//
//        assertEquals(true,is(allorder.isEmpty()));
//
//    }
//

	

}
