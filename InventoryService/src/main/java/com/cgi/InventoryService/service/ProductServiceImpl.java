package com.cgi.InventoryService.service;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.model.Warehouse;
import com.cgi.InventoryService.repository.ProductRepository;
import com.cgi.InventoryService.util.exceptions.InvalidQuantityException;
import com.cgi.InventoryService.util.exceptions.InvalidWarehouseException;
import com.cgi.InventoryService.util.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product addProduct(Product product) throws InvalidQuantityException, InvalidWarehouseException {

        //check for invalid quantities
        List<Warehouse> warehouseList = product.getWarehouseList();

        //Check that warehouse not null and size is 1. User can only save one product to a warehouse at a time
        if(warehouseList!=null && warehouseList.size()==1){
            //check all warehouse qty
            for(Warehouse w : warehouseList){
                if(w.getQty()<0){
                    throw new InvalidQuantityException("Quantity must be greater than or equal to zero");
                }
            }
        }else{
            //warehouses are null, throw error
            throw new InvalidWarehouseException("Invalid warehouse. Must be single warehouse in the list");
        }

        //Check if this product already exists
        Optional<Product> optProduct = productRepository.findById(product.getProductSku());

        if(optProduct.isPresent()){

            //If exists, go through warehouses
            Product oldProduct = optProduct.get();
            List<Warehouse> oldWarehouses = oldProduct.getWarehouseList();
            Warehouse warehouse = warehouseList.get(0);


            Optional<Warehouse>optWarehouse = oldWarehouses.stream().filter(w-> w.getWarehouseId().equals(warehouse.getWarehouseId())).findFirst();

            //if warehouse already exists, add quantity
            if(optWarehouse.isPresent()){
                //find the warehouse we need to add to
                for(Warehouse w : oldWarehouses){
                    if(w.getWarehouseId().equals(warehouse.getWarehouseId())){
                        //add to warehouse qty
                        w.setQty(w.getQty()+warehouse.getQty());
                    }
                }

                //set the warehouse updated warehouse list
                oldProduct.setWarehouseList(oldWarehouses);
                //save the updated product
                return productRepository.save(oldProduct);

            }else{
                //If warehosue doesnt exist, append it to the list
                oldWarehouses.add(warehouse);
                oldProduct.setWarehouseList(oldWarehouses);
                //save the updated product
                return productRepository.save(oldProduct);

            }

        }else{
            //add the product since it doesnt exist
            return productRepository.save(product);
        }
    }




    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String productId) throws ProductDoesNotExistException {

        Optional<Product> optProduct = productRepository.findById(productId);

        if(optProduct.isPresent()){
            return optProduct.get();
        }else{
            throw new ProductDoesNotExistException("Product not found");
        }
    }

    @Override
    public void deleteProduct(String productId) throws ProductDoesNotExistException {
        Optional<Product> optProduct = productRepository.findById(productId);

        if(optProduct.isPresent()){
            productRepository.deleteById(productId);
        }else{
            throw new ProductDoesNotExistException("Product not found");
        }
    }
}
