import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Order } from 'src/app/Model/order';

import { Product } from 'src/app/Model/product';
import { ProductWarehouse } from 'src/app/Model/productwarehouse';
import { Warehouse } from 'src/app/Model/warehouse';
import { AuthenticationService } from 'src/app/Services/Authentication/authentication.service';
import { ImageService } from 'src/app/Services/Image/image.service';
import { InventoryService } from 'src/app/Services/Inventory/inventory.service';
import { OrderService } from 'src/app/Services/Order/order.service';

import { RouteService } from 'src/app/Services/Routing/route.service';
import { UserprofileService } from 'src/app/Services/UserProfile/userprofile.service';
//test comment 
@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrls: ['./order-detail.component.css']
})
export class OrderDetailComponent implements OnInit {

  message:string = ""

  
  order?:Order = new Order();
  warehouseList?: Warehouse [];
  canView?: boolean = false;
  
  //add order service
  constructor(private inventoryService : InventoryService,
    private routingService:RouteService, 
    private orderservice : OrderService, 
    private userprofileservice: UserprofileService,
    private authservice: AuthenticationService,
    private imgservice :ImageService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {

  //get order number from url
    // let orderNumber = "QC213_211006_0102110101_FR"

    let orderNumber = this.route.snapshot.paramMap.get('id');

   //get the order id/ ordernumber from url
    //Call endpoint to get order

    this.orderservice.getOrderByOrderNumber(orderNumber).subscribe( (res:any)=>{

      this.order=res;

      let boxlist = this.order?.list_box;
      
      //for each box, set the 'received' and 'recievingqty' properties
      boxlist?.forEach((box:any) => {
      
        box.recieved=false;
        box.recievingQty = box.qty_of_boxes;
      }),
      (err:any)=>{
        console.log(err.error);

      };

    //Get warehouse list
    let username = this.authservice.getUsername();
    this.userprofileservice.getUserProfile(username).subscribe( (res:any)=>{
      this.warehouseList = res[0].warehouses;

      //check if user can view this order
      let warehouseIdList = this.warehouseList.map( (w:any)=> w.warehouseid);

      let index = warehouseIdList.indexOf(this.order.warehouse_id.toString());

      //If the order warehouse id is in the list of warehouse the user is associated with
      if(index >= 0 ){
        this.canView=true;
      }

    })


    })
    

   
  }



//When accept order button is clicked 
acceptOrder(){


let canSubmit = true;
this.message="";
let boxlist = this.order.list_box;


//Check for validations
  boxlist.forEach((box:any) => {
    
    //check that there is a signature




    //if recievingqty different from order qty
    if((box.recievingQty != box.qty_of_boxes) && (box.comment=="" || box.comment==null)){
      canSubmit=false;
      this.message="There is a box that requires a comment"
    }

    
    if(!box.recieved && (box.comment==='' || box.comment===null)){
       
      canSubmit=false;
      this.message="Please check each box before submitting or add a comment for unacknowledged boxes"
    }

    //Check that order is not completed
    if(this.order.orderStatus=="COMPLETED"){
      canSubmit=false;
      this.message="This order has already been processed"
    }

  });

  //If validation is good
  if(canSubmit){


    //Update order
    this.order.receivedBy=this.authservice.getUsername();

    this.orderservice.updateOrder(this.order).subscribe( (res:any)=>{
      console.log(res);
      console.log("Order submitted")

        

      //get warehouse from user
        //get user
      let username = this.authservice.getUsername();

      // this.userprofileservice.getUserProfile(username).subscribe( (res:any)=>{

        //get warehouselist
        // let warehouseList : Warehouse[] = res[0].warehouses
        let index = this.warehouseList.findIndex( (w:any) => w.warehouseid == this.order.warehouse_id);

        //Get the warehouse to send the products to 
        let warehouse = this.warehouseList[index];

        //For each box, create the product object and post to inventory
        boxlist?.forEach( (box:any) => {
        
          //only post if the box is recieved / acknowledged
          if(box.recieved){
    
          //create product warehouse
          let productWarehouse: ProductWarehouse ={
              "warehouseId": warehouse?.warehouseid,
              "warehouseName": warehouse?.warehousename,
              "qty": box.recievingQty * box.qty_per_box
          }
    
          //Post to inventory 
          let product: Product = new Product(box.sku,box.imgUrl, box.product_name, productWarehouse)
          
          //add product
          this.inventoryService.addProduct(product).subscribe( (res:any)=>{
            console.log(res);
            //route to inventory
            this.routingService.openInventory();
          });
  
        
        }//end if
      });//end forloop

    }),
    (err:any)=>{
      console.log(err.error);
    }// end update order subscribe
  }
  
}


uploadImage(event:any){

  let file = <File> event.target.files[0];
  console.log(file.name)
  this.order.receptionSig=file.name;
//   this.imgservice.uploadImage(file).subscribe(
//     (event: any) => {
//         if (typeof (event) === 'object') {

//             // Short link via api response
//             console.log(event.link)
//             //this.shortLink = event.link;

          
//         }
//     }
// );

}


}
