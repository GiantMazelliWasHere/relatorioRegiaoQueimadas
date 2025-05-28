package br.com.relatorioqueimadasregiao.services;

import br.com.relatorioqueimadasregiao.entities.BrigadaBombeiro;
import br.com.relatorioqueimadasregiao.repositories.BrigadaBombeiroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BrigadaBombeiroService {
    @Autowired
    private BrigadaBombeiroRepository brigadaBombeiroRepository;

    public void criarBrigadaBombeiro(BrigadaBombeiro brigadaBombeiro) {brigadaBombeiroRepository.save(brigadaBombeiro);}

    public BrigadaBombeiro buscarBrigadaPorN(int numero){return brigadaBombeiroRepository.findByNBrigada(numero);}

    public List<BrigadaBombeiro> buscarTodasBrigadas(){return brigadaBombeiroRepository.findAll();}
}
