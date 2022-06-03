import { Pipe, PipeTransform } from '@angular/core';
import { Order } from '../Model/order';

@Pipe({
  name: 'orderfilter'
})
export class OrderPipe implements PipeTransform {

  transform(orderlist: Order[] , searchtext: any): any {

    if(searchtext == null){
      return orderlist;
    }

    return orderlist.filter( (order:Order) => {
      return order.order_number.toLowerCase().includes(searchtext.toLowerCase())
    }

    )
  }

}
