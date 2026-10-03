package com.seuprojeto.carros.controller;


import com.seuprojeto.carros.entity.Carro;
import com.seuprojeto.carros.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro criar(@RequestBody Carro carro) {
        return carroService.salvar(carro);
    }

    @GetMapping
    public List<Carro> listar() {
        return carroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Carro buscarPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        return carroService.atualizar(id, carro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        carroService.deletar(id);
    }
}

