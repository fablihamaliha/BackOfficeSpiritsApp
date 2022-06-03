package com.cgi.InventoryService.repository;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.model.Warehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    private List<Product> productList;

    @BeforeEach
    public void setUp(){

        productList=new ArrayList<Product>();

        List<Warehouse> warehouseList1 = new ArrayList<Warehouse>();
        Warehouse warehouse1 = new Warehouse("213","Montreal",10);

        warehouseList1.add(warehouse1);

        product = new Product("TEST_2019","image1.jpg","Alain Brumont Madiran Tour",warehouseList1);
        Product product2 = new Product("TEST2_123","image2.jpg","Antoine Bonet Merlot",warehouseList1);

        productList.add(product);
        productList.add(product2);
    }


    @AfterEach
    public void tearDown() throws Exception{
        productRepository.deleteById("TEST_2019");
    }

    @Test
    public void addProductTest(){
        productRepository.insert(product);
        Product addedProduct = productRepository.findById(product.getProductSku()).get();
        assertThat(addedProduct.getProductSku(),is(product.getProductSku()));
    }

    @Test
    public void getAllProductsTest(){
        productRepository.insert(product);
        List<Product> products = productRepository.findAll();
        int last = products.size()-1;

        assertThat(products.get(last).getProductSku(),is(product.getProductSku()));

    }

    @Test
    public void getProductTest(){
        productRepository.insert(product);
        Product  product1 = productRepository.findById(product.getProductSku()).get();

        assertThat(product1.getProductSku(),is(product.getProductSku()));
    }

}
