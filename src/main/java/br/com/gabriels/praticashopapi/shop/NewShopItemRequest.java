package br.com.gabriels.praticashopapi.shop;

import javax.validation.constraints.*;
import java.math.BigDecimal;

final class NewShopItemRequest {

    @NotBlank
    private String productIdentifier;

    @Min(1)
    private int amout;

    @NotNull
    private BigDecimal price;

    public NewShopItemRequest(String productIdentifier, int amout, BigDecimal price) {
        this.productIdentifier = productIdentifier;
        this.amout = amout;
        this.price = price;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public int getAmout() {
        return amout;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public ShopItem toModel() {
        return new ShopItem(this.productIdentifier, this.amout, this.price);
    }
}
