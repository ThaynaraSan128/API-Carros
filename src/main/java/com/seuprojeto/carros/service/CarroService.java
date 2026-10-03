package com.seuprojeto.carros.service;


import com.seuprojeto.carros.entity.Carro;

import java.util.List;

public interface CarroService {

    Carro salvar(Carro carro);

    List<Carro> listarTodos();

    Carro buscarPorId(Long id);

    Carro atualizar(Long id, Carro carro);

    void deletar(Long id);
}
