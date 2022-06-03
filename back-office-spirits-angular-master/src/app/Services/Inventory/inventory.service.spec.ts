import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { InventoryService } from './inventory.service';
import { Product } from 'src/app/Model/product';


const products: Product[] =[
  {
    productSku : "TEST_123",
    imgUrl: "testimg.jpg",
    productName : "Test Product",
    warehouseList: []
  },
  {
    productSku : "TEST_1234",
    imgUrl: "testimg2.jpg",
    productName : "Test Product2",
    warehouseList: []
  }

]




describe('InventoryService', () => {
  let service: InventoryService;
  let httpMock: HttpTestingController;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers:[InventoryService],

    });

    httpMock= TestBed.get(HttpTestingController);
    service = TestBed.inject(InventoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });


  it('Add Product method should add a prodcut', () => {
    
    let product: Product ={
      productSku : "TEST_123",
      imgUrl: "testimg.jpg",
      productName : "Test Product",
      warehouseList: []
    }

    service.addProduct(product).subscribe( (res:any)=>{
      expect(res.data).toEqual(product);
    })

    const req= httpMock.expectOne("http://localhost:8083/api/v1/inventory")
    expect(req.request.method).toEqual('POST');
    req.flush({data:product})


  });

  it('Get products method should return list of products', () => {
    service.getAllProducts().subscribe( (res:any)=>{

      expect(res.data.length).toBe(2);
      expect(res.data).toEqual(products);
    })

    const req= httpMock.expectOne("http://localhost:8083/api/v1/inventory")
    expect(req.request.method).toEqual('GET');
    req.flush({data:products})
  });

});
