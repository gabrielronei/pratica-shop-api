package br.com.gabriels.praticashopapi.shop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ShopController {

    private final ShopRepository shopRepository;

    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Transactional
    @PostMapping("/shop")
    public ResponseEntity create(@Valid @RequestBody NewShopRequest newShopRequest) {

        shopRepository.save(newShopRequest.toModel());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/shop")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(shopRepository.findAll().stream().map(ShopOutputDTO::new).toList());
    }


}
