package br.com.gabriels.praticashopapi.shop;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

final class ShopOutputDTO {

    private final String identifier;
    private final Shop.Status status;
    private final LocalDate creationDate;
    private final List<Map<String, String>> items;

    public ShopOutputDTO(Shop shop) {
        this.identifier = shop.getIdentifier();
        this.status = shop.getStatus();
        this.creationDate = shop.getCreationDate();
        this.items = shop.getItems().stream().map(x -> Map.of("price", x.getPrice().toString(), "identifier", x.getProductIdentifier())).toList();
    }

    public String getIdentifier() {
        return identifier;
    }

    public Shop.Status getStatus() {
        return status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<Map<String, String>> getItems() {
        return items;
    }
}
