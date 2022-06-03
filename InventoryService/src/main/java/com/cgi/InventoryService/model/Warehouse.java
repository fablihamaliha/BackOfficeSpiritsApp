package com.cgi.InventoryService.model;

public class Warehouse {

    private String warehouseId;
    private String warehouseName;
    private int qty;


    public Warehouse(){}

    public Warehouse(String warehouseId, String warehouseName, int qty) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId='" + warehouseId + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", qty=" + qty +
                '}';
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
