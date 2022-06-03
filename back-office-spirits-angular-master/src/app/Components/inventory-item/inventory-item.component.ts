import { Component, Input, OnInit } from '@angular/core';
import { Product } from '../../Model/product';
import { ProductWarehouse } from '../../Model/productwarehouse';

@Component({
  selector: 'app-inventory-item',
  templateUrl: './inventory-item.component.html',
  styleUrls: ['./inventory-item.component.css']
})
export class InventoryItemComponent implements OnInit {

  @Input() item?:Product = new Product();
  totalInventory : number=0;
  warehouseList: ProductWarehouse[];

  constructor() { }

  ngOnInit(): void {
    console.log(this.item)

    this.warehouseList = this.item?.warehouseList;

    this.warehouseList?.forEach( (w)=> this.totalInventory=this.totalInventory+w.qty);
    console.log(this.item.productName+""+ this.totalInventory);

  }



}
