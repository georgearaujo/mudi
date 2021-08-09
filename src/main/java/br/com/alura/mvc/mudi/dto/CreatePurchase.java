package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.PurchaseOrder;

import javax.validation.constraints.NotBlank;

public class CreatePurchase {

    @NotBlank
    private String productName;

    @NotBlank
    private String productUrl;

    @NotBlank
    private String imageUrl;

    @NotBlank
    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PurchaseOrder toPurchaseOrder() {
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setName(this.getProductName());
        purchaseOrder.setUrlProduct(this.getProductUrl());
        purchaseOrder.setUrlImage(this.getImageUrl());
        purchaseOrder.setDescription(this.getDescription());

        return purchaseOrder;
    }
}
