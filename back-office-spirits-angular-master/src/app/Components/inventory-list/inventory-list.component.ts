import { Component, OnInit } from '@angular/core';
import { InventoryService } from 'src/app/Services/Inventory/inventory.service';
import { Product } from '../../Model/product';

@Component({
  selector: 'app-inventory-list',
  templateUrl: './inventory-list.component.html',
  styleUrls: ['./inventory-list.component.css']
})
export class InventoryListComponent implements OnInit {
  
  searchtext?:string;
  productsList ?: Product[];


  constructor(private inventoryService: InventoryService ) { }

  ngOnInit(): void {

    this.inventoryService.getAllProducts().subscribe( (response:any)=>{
      //console.log(response);
      this.productsList=response;
      console.log(this.productsList);

    })


  }

}
