import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Boxes } from 'src/app/Model/boxes';
import { Order } from 'src/app/Model/order';
import { Product } from 'src/app/Model/product';
import { ProductWarehouse } from 'src/app/Model/productwarehouse';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { InventoryService } from 'src/app/Services/Inventory/inventory.service';
import { OrderService } from 'src/app/Services/Order/order.service';
import { RouteService } from 'src/app/Services/Routing/route.service';
import { UserprofileService } from 'src/app/Services/UserProfile/userprofile.service';

@Component({
  selector: 'app-order-form',
  templateUrl: './order-form.component.html',
  styleUrls: ['./order-form.component.css']
})
export class OrderFormComponent implements OnInit {

  message:string = ""
  isAdmin = false;
  order?:Order = new Order();

  orderDetailForm = new FormGroup({
    orderNumber: new FormControl('', [Validators.required]),
    warehouseId: new FormControl('', [Validators.required]),
    grossweight: new FormControl('', [Validators.required, Validators.min(0)]),
    trucknum: new FormControl('', [Validators.required]),
    drivername: new FormControl('', [Validators.required]),
  });

  productForm = new FormGroup({
    sku: new FormControl('', [Validators.required]),
    qtyofboxes: new FormControl('', [Validators.required, Validators.min(0)]),
    productname: new FormControl('', [Validators.required]),
    boxtype: new FormControl('', [Validators.required]),
    qtyperbox: new FormControl('', [Validators.required, Validators.min(0)]),
    img: new FormControl('', [Validators.required]),
  });



  
  //add order service
  constructor(private inventoryService : InventoryService,
    private routingService:RouteService, 
    private orderservice : OrderService, 
    private userprofileservice: UserprofileService,
    private authservice: AuthenticationService) { }

  ngOnInit(): void {
    this.order.list_box = [];
    this.addBox();
    let username: string =this.authservice.getUsername();

    if(username.toLowerCase() == "admin"){
      this.isAdmin=true;
    }

    


  }



// BUG: Adding a box will delete all information in the boxes
  addBox(){
    this.message="";
    let box : Boxes = new Boxes();
    this.order.list_box.push(box);
  }


  removeBox(index:any){
    console.log(index);
    this.order.list_box.splice(index,1);
  }


  submitOrder(){
    
    if(this.orderDetailForm.valid && this.productForm.valid){
    console.log(this.order);
      this.orderservice.addOrder(this.order).subscribe( (res:any)=>{
        console.log(res);

        //route to orders
        this.routingService.openOrders();

    })
    
    }else{
      this.message="Invalid or missing values"
    }


    

  }

}
