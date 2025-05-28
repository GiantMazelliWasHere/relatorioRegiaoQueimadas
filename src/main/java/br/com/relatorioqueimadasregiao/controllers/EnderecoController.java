package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.Endereco;
import br.com.relatorioqueimadasregiao.services.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public void salvarEndereco(@RequestBody @Valid Endereco endereco) {enderecoService.criarEndereco(endereco);}

    @GetMapping(params = {"cep"})
    public List<Endereco> buscarEnderecoPorCep(@RequestParam long cep) {
        List<Endereco> enderecos = (List) enderecoService.buscarEnderecoPorCep(cep);
        return enderecos;
    }

    @GetMapping
    public List<Endereco> buscarEndereco() {return enderecoService.listarEndereco();}
}
