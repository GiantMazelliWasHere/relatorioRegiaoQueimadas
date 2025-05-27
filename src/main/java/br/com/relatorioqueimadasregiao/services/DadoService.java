package br.com.relatorioqueimadasregiao.services;

import br.com.relatorioqueimadasregiao.entities.Dado;
import br.com.relatorioqueimadasregiao.repositories.DadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DadoService {
    @Autowired
    private DadoRepository dadoRepository;

    public void criarDados(Dado dado) {
        this.dadoRepository.save(dado);
    }

    public Dado buscarDadoPorMunicipio(String municipio) {
        return this.dadoRepository.findByMunicipio(municipio);
    }

    public List<Dado> buscarTodosDados() {
        return this.dadoRepository.findAll();
    }
}
