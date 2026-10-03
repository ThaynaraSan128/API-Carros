package com.seuprojeto.carros.service.serviceImpl;


import com.seuprojeto.carros.entity.Carro;
import com.seuprojeto.carros.repository.CarroRepository;
import com.seuprojeto.carros.service.CarroService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;

    public CarroServiceImpl(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    @Override
    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    @Override
    public Carro buscarPorId(Long id) {
        return carroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    @Override
    public Carro atualizar(Long id, Carro carro) {
        Carro carroExistente = buscarPorId(id);

        carroExistente.setMarca(carro.getMarca());
        carroExistente.setModelo(carro.getModelo());
        carroExistente.setAno(carro.getAno());
        carroExistente.setCor(carro.getCor());
        carroExistente.setPreco(carro.getPreco());

        return carroRepository.save(carroExistente);
    }

    @Override
    public void deletar(Long id) {
        buscarPorId(id);
        carroRepository.deleteById(id);
    }
}
