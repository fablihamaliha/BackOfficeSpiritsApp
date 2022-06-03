
export class Box{
    sku?: string;
    qty_of_boxes?: number;
    product_name?: string;
    box_type?: string;
    qty_per_box?: number;
    comment?: string;

    //In angular only
    recieved?: boolean;
    recievingQty?:number;
}