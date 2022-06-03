import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteService {


  constructor(private router: Router) { }
  openLogin()
  {
    this.router.navigate(['login']);
  }

 openDashboard()
  {
    this.router.navigate(['dashboard']);
  }
 
  openInventory(){
    this.router.navigate(['dashboard/inventory'])
  }

  openOrderDetails(id: string){
    this.router.navigate(['dashboard/orders/order-details', id])
  }

  openOrders(){
    this.router.navigate(['dashboard/orders'])
  }

}
