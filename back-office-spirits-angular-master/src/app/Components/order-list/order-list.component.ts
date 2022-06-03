import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/Model/order';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { InventoryService } from 'src/app/Services/Inventory/inventory.service';
import { OrderService } from 'src/app/Services/Order/order.service';
import { RouteService } from 'src/app/Services/Routing/route.service';
import { UserprofileService } from 'src/app/Services/UserProfile/userprofile.service';


@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  message:string = "";
  searchtext:string = "";
  warehouseList?: Warehouse [];
  canView?: boolean = false;


  order?:Order = new Order();

  list_order? : Order[];


  constructor(
    private inventoryService : InventoryService,
    private orderService: OrderService, 
    private routingService:RouteService,  
    private userprofileservice: UserprofileService,
    private authservice: AuthenticationService) { }


  ngOnInit(): void {
    
    this.orderService.getAllOrder().subscribe((res:any) =>
    {
      this.list_order = res;
      console.log(res);

      let username = this.authservice.getUsername();
      this.userprofileservice.getUserProfile(username).subscribe( (res:any)=>{
        // we have list of warehouses for a particular username. Need to get the warehouse ids for
        // this particular username
        this.warehouseList = res[0].warehouses;
  
        //List of warehouse ids for this username
        let warehouseIdListperuser = this.warehouseList.map( (w:any)=> w.warehouseid);
  
  
        this.list_order = this.list_order.filter((res:any) => warehouseIdListperuser.includes(res.warehouse_id.toString()))
  
      })

    },
    (err:any) =>
    {
      console.log(err.error)
    }

    )


  }

  


  getOrderDetails(id: string){

    console.log("This shows order details")
    this.routingService.openOrderDetails(id);


  }
 
  
}
