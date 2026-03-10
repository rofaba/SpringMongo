package com.springmongo.controller;

import com.springmongo.model.Item;
import com.springmongo.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @PostMapping("items")
    public ResponseEntity<Item> crear(@Valid @RequestBody Item producto) {
        Item nuevo = itemService.crear(producto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> listar() {

        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id) {
        return itemService.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Producto no encontrado"));
    }

    @GetMapping("/items/categoria/{categoria}")
    public ResponseEntity<List<Item>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(itemService.findByCategoria(categoria));
    }


    @DeleteMapping("/items/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        itemService.deleteById(String.valueOf(Integer.parseInt(id)));
        return ResponseEntity.ok("Producto eliminado");
    }

    @PutMapping("/admin/items/{category}")
    //actualizar la categoria de todos los productos de una categoria

    public ResponseEntity<String> actualizarCategoria(@PathVariable String category, @RequestBody String newCategory) {
        itemService.updateCategory(category, newCategory);
        return ResponseEntity.ok("Categoría actualizada");
    }
}

