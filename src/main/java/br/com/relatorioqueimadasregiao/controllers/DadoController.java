package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.Dado;
import br.com.relatorioqueimadasregiao.services.DadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping({"/v1/dados"})
public class DadoController {
    @Autowired
    private DadoService dadoService;

    @PostMapping
    public void adicionarDado(@RequestBody @Valid Dado dado) {
        this.dadoService.criarDados(dado);
    }

    @GetMapping(params = {"municipio"})
    public List<Dado> listarDados(String municipio) {
        List<Dado> dados = (List)this.dadoService.buscarDadoPorMunicipio(municipio);
        return dados;
    }

    @GetMapping
    public List<Dado> listarTodosDados() {
        return this.dadoService.buscarTodosDados();
    }
}
