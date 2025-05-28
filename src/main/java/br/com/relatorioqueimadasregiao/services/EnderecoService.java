package br.com.relatorioqueimadasregiao.services;

import br.com.relatorioqueimadasregiao.entities.Endereco;
import br.com.relatorioqueimadasregiao.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void criarEndereco(Endereco endereco) {this.enderecoRepository.save(endereco);}

    public Endereco buscarEnderecoPorCep(long cep){return enderecoRepository.findByCep(cep);}

    public List<Endereco> listarEndereco() {return enderecoRepository.findAll();}
    }
