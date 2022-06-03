import { ProductWarehouse } from "./productwarehouse";



export class Product{

    productSku?: string;
    imgUrl?: string;
    productName?: string;
    warehouseList?: ProductWarehouse[];
    
    constructor(productSku?:string, imgUrl?:string, productName?:string, productWarehouse?: ProductWarehouse){
        this.productSku=productSku;
        this.imgUrl=imgUrl;
        this.productName = productName;
        this.warehouseList= [productWarehouse]
    }


}