package br.com.relatorioqueimadasregiao.services;

import br.com.relatorioqueimadasregiao.entities.DadosIncendio;
import br.com.relatorioqueimadasregiao.repositories.DadosIncendioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DadosIncendioService {
    @Autowired
    private DadosIncendioRepository dadosIncendioRepository;

    public void salvar(DadosIncendio dadosIncendio) {dadosIncendioRepository.save(dadosIncendio);}

    public DadosIncendio buscarPorLocal(String local) {return dadosIncendioRepository.findByLocal(local);}

    public List<DadosIncendio> buscarTodos() {return dadosIncendioRepository.findAll();}
}
