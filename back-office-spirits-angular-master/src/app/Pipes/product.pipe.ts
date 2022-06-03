import { Pipe, PipeTransform } from '@angular/core';
import { Product } from '../Model/product';

@Pipe({
  name: 'filter'
})
export class ProductPipe implements PipeTransform {

  transform(productsList:Product[], searchText:any): any {

    if(searchText==null){
      return productsList;
    }

    return productsList.filter( (product:Product)=>{
      return product.productSku?.toLowerCase().includes(searchText.toLowerCase()) ||
      product.productName?.toLowerCase().includes(searchText.toLowerCase());
    })
  }

}
