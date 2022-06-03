package com.cgi.InventoryService.service;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.model.Warehouse;
import com.cgi.InventoryService.repository.ProductRepository;
import com.cgi.InventoryService.util.exceptions.InvalidQuantityException;
import com.cgi.InventoryService.util.exceptions.InvalidWarehouseException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;
    private List<Product> productList;


    @BeforeEach
    public void setUp() throws Exception{

        MockitoAnnotations.initMocks(this);
        productList=new ArrayList<Product>();

        List<Warehouse> warehouseList1 = new ArrayList<Warehouse>();
        Warehouse warehouse1 = new Warehouse("213","Montreal",10);

        warehouseList1.add(warehouse1);

        product = new Product("ABMT_2019","image1.jpg","Alain Brumont Madiran Tour",warehouseList1);
        Product product2 = new Product("ABM_4L","image2.jpg","Antoine Bonet Merlot",warehouseList1);

        productList.add(product);
        productList.add(product2);
    }

    @AfterEach
    public void tearDown() throws Exception{
        productList=null;
        product=null;
    }


   //Add Product Tests
    //new product that is not in database
    @Test
   public void givenNewProductToSaveThenShouldReturnSavedProduct (){
       when(productRepository.findById(any())).thenReturn(Optional.empty());
        when(productRepository.save(any())).thenReturn(product);

        assertEquals(product, productService.addProduct(product));

        verify(productRepository,times(1)).save(any());
       verify(productRepository,times(1)).findById(any());

   }

   //Add product and warehouse that already exists in database- should increment qty
    @Test
   public void givenExistingProductToSaveWithExistingWarehouseThenShouldReturnSavedProduct(){
       when(productRepository.findById(any())).thenReturn(Optional.of(product));
       when(productRepository.save(any())).thenReturn(product);

       assertEquals(product, productService.addProduct(product));

       verify(productRepository,times(1)).save(any());
       verify(productRepository,times(1)).findById(any());

   }

    //product already exists but warehouse does not. Should add warehouse to product warehouse list
    @Test
    public void givenExistingProductToSaveWithoutExistingWarehouseThenShouldReturnSavedProductWithWarehouseAddedToList(){
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        when(productRepository.save(any())).thenReturn(product);
        List<Warehouse> warehouseList = new ArrayList<>();
        Warehouse warehouse =  new Warehouse("746","Toronto",15);
        warehouseList.add(warehouse);

        product.getWarehouseList().add(warehouse);
        Product product3 = new Product("ABM_4L","image2.jpg","Antoine Bonet Merlot",warehouseList);

        assertEquals(product, productService.addProduct(product3));

        verify(productRepository,times(1)).save(any());
        verify(productRepository,times(1)).findById(any());
    }

   //Add product with invalid quantity
    @Test
   public void givenProductToSaveWithInvalidQuantityThenShouldThrowException(){

        product.getWarehouseList().get(0).setQty(-5);
        assertThrows(InvalidQuantityException.class, ()-> productService.addProduct(product));

   }

   //add product with more than 1 warehouse in list
    @Test
   public void givenProductToSaveWithMultipleWarehousesThenShouldThrowException(){
       Warehouse warehouse =  new Warehouse("746","Toronto",15);
       product.getWarehouseList().add(warehouse);
       assertThrows(InvalidWarehouseException.class, ()-> productService.addProduct(product));

   }


   //GET ALL Test
    @Test
    public void givenGetAllProductsThenShouldReturnListOfAllProducts(){
        when(productRepository.findAll()).thenReturn(productList);

        assertEquals(productList,productService.getAllProducts());

        verify(productRepository,times(1)).findAll();
    }

    //Get single product test
    public void givenGetProductThenShouldReturnSpecifiedProduct(){
        when(productRepository.findById(any())).thenReturn(Optional.of(product));

        assertEquals(product, productService.getProduct(product.getProductSku()));

       verify(productRepository, times(1)).findById(any());
    }



}
