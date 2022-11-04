package br.com.gabriels.praticashopapi.shop;

import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.*;

final class NewShopRequest {

    @Size(min = 1)
    private List<@Valid NewShopItemRequest> items = new ArrayList<>();

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public NewShopRequest(List<NewShopItemRequest> items) {
        this.items = items;
    }

    public List<NewShopItemRequest> getItems() {
        return items;
    }

    public Shop toModel() {
        return new Shop(UUID.randomUUID().toString(), Shop.Status.PENDING, items.stream().map(NewShopItemRequest::toModel).toList());
    }
}
