package br.com.gabriels.praticashopapi.shop;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String identifier;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @PastOrPresent
    private LocalDate creationDate;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shop_id")
    private List<ShopItem> items;

    @Deprecated
    public Shop() {
    }

    public Shop(String identifier, Status status, List<ShopItem> items) {
        this.identifier = identifier;
        this.status = status;
        this.creationDate = LocalDate.now();
        this.items = items;

    }

    public String getIdentifier() {
        return identifier;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public List<ShopItem> getItems() {
        return items;
    }

    enum Status {
        PENDING,
    }
}
