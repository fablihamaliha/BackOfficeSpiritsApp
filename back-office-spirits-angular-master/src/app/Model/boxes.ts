export class  Boxes{

    sku?: string;
    qty_of_boxes?: number;
    product_name?: string;
    box_type?: string;
    qty_per_box? :number;
    comment? : string;
    imgUrl:string;
    //
    recieved?: boolean;
    recievingQty?:number;

    constructor(sku?: string, qty_of_boxes?: number, product_name?: string, box_type?: string, 
        qty_per_box? :number,  comment? : string, recieved?: boolean, recievingQty?: number ) {
            this.sku = sku;
            this.qty_of_boxes = qty_of_boxes;
            this.product_name = product_name;
            this.box_type = box_type;
            this.qty_per_box = qty_per_box;
            this.comment = comment;
            this.recieved;
            this.recievingQty=recievingQty;
        }


}