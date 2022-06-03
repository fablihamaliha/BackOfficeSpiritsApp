package com.cgi.InventoryService.controller;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.model.Warehouse;
import com.cgi.InventoryService.service.ProductService;
import com.cgi.InventoryService.util.exceptions.InvalidQuantityException;
import com.cgi.InventoryService.util.exceptions.InvalidWarehouseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Product product;
    private List<Product> productList;

    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;


    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    mockMvc= MockMvcBuilders.standaloneSetup(productController).build();
        productList=new ArrayList<Product>();

        List<Warehouse> warehouseList1 = new ArrayList<Warehouse>();
        Warehouse warehouse1 = new Warehouse("213","Montreal",10);

        warehouseList1.add(warehouse1);

        product = new Product("ABMT_2019","image1.jpg","Alain Brumont Madiran Tour",warehouseList1);
        Product product2 = new Product("ABM_4L","image2.jpg","Antoine Bonet Merlot",warehouseList1);

        productList.add(product);
        productList.add(product2);
    }


//Post tests
    @Test
    public void givenAddProductThenShouldReturnSavedProduct() throws Exception {
        when(productService.addProduct(any())).thenReturn(product);

        mockMvc.perform(post("/api/v1/inventory").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(product)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }


    @Test
    public void givenProductToSaveShouldThrowInvalidQuantityException() throws Exception {
        when(productService.addProduct(any())).thenThrow(InvalidQuantityException.class);

        mockMvc.perform(post("/api/v1/inventory").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(product)))
                .andExpect(status().isBadRequest()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void givenProductToSaveShouldThrowInvalidWarehouseException() throws Exception {
        when(productService.addProduct(any())).thenThrow(InvalidWarehouseException.class);

        mockMvc.perform(post("/api/v1/inventory").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(product)))
                .andExpect(status().isBadRequest()).andDo(MockMvcResultHandlers.print());
    }

//get all test
    @Test
    public void givenGetAllProductsShouldReturnListOfAllProducts() throws Exception{
        when(productService.getAllProducts()).thenReturn(productList);
        mockMvc.perform(get("/api/v1/inventory").contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(product)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

//get product test
    @Test
    public void givenGetProductShouldReturnRequestedProduct() throws Exception{
        when(productService.getProduct(product.getProductSku())).thenReturn(product);
        mockMvc.perform(get("/api/v1/inventory/"+product.getProductSku()).contentType(MediaType.APPLICATION_JSON).content(convertObjtoString(product)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }


    public String convertObjtoString(Object obj) throws JsonProcessingException
    {
        ObjectMapper objmapper=new ObjectMapper();

        String result=objmapper.writeValueAsString(obj);
        return result;

    }
}
