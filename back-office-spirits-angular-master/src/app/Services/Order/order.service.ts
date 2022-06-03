import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Order } from 'src/app/Model/order';
import { AuthenticationService } from '../Authentication/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private orderservice : HttpClient, private authservice: AuthenticationService) { }

  addOrder(order: Order){
    let token = this.authservice.getJWT();
    return this.orderservice.post("http://localhost:9095/OrderService/addOrder", order,
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }

  getAllOrder(){
    let token = this.authservice.getJWT();
    return this.orderservice.get("http://localhost:9095/OrderService/getAllOrder",
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }

  getOrderByOrderNumber( orderNumber: string){
    let token = this.authservice.getJWT();
    return this.orderservice.get("http://localhost:9095/OrderService/getOrderbyId/"+ orderNumber,
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }



  updateOrder(order: Order){
    let token = this.authservice.getJWT();
    return this.orderservice.put("http://localhost:9095/OrderService/updateorder", order,
    {
      headers:new HttpHeaders({
        "Authorization": `Bearer ${token}`
      })
    }
    )
  }

  


}
