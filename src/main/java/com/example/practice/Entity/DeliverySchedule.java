package com.example.practice.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery_schedule")
public class DeliverySchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false, length = 50)
    private String itemName;

    @Column(name = "delivery_number", nullable = false)
    private Integer deliveryNumber;

    @Column(name = "delivery_date", nullable = false)
    private LocalDate deliveryDate;

    @Column(name = "supplier", nullable = false, length = 50)
    private String supplier;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unloading_shop", nullable = false, length = 50)
    private String unloadingShop;

    @Column(name = "additional_info")
    private String additionalInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(Integer deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnloadingShop() {
        return unloadingShop;
    }

    public void setUnloadingShop(String unloadingShop) {
        this.unloadingShop = unloadingShop;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
