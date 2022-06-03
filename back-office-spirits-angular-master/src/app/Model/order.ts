import { Boxes } from "./boxes";

export class Order {

    order_number?: string;
    gross_weight?: number;
    truck_number?: string;
    creation_date?: string;
    driver? :number;
    receivedBy? : string;
    receptionSig? : string;
    reception_date?: string;
    orderStatus? : string;
    warehouse_id? : number;
    list_box? : Boxes[];

    constructor(order_number?: string, gross_weight?: number, truck_number?: string,creation_date?: string,
        driver? :number, receivedBy? : string, receptionSig? : string, orderStatus? : string, warehouse_id? : number, reception_date?: string,
        list_box? : Boxes[]) {
            this.order_number = order_number,
            this.gross_weight = gross_weight,
            this.truck_number = truck_number;
            this.creation_date = creation_date;
            this.driver = driver;
            this.receivedBy = receivedBy,
            this.receptionSig = receptionSig;
            this.reception_date=reception_date;
            this.orderStatus = orderStatus;
            this.warehouse_id = warehouse_id;
            this.list_box = list_box;
        }
    
}