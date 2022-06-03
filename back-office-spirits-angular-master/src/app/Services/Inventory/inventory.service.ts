import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from 'src/app/Model/product';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private inventoryService: HttpClient, private authservice: AuthenticationService) { }

  addProduct(product: Product){
    let token = this.authservice.getJWT();
    return this.inventoryService.post("http://localhost:8083/api/v1/inventory", product,
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }

  getAllProducts(){
    let token = this.authservice.getJWT();
    return this.inventoryService.get("http://localhost:8083/api/v1/inventory",
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }

}
