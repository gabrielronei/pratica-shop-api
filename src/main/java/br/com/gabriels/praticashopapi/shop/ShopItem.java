package br.com.gabriels.praticashopapi.shop;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String productIdentifier;

    private int amout;

    @NotNull
    private BigDecimal price;

    @Deprecated
    public ShopItem() {}

    public ShopItem(String productIdentifier, int amout, BigDecimal price) {
        this.productIdentifier = productIdentifier;
        this.amout = amout;
        this.price = price;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
