package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.DadosIncendio;
import br.com.relatorioqueimadasregiao.services.DadosIncendioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/dadosIncendio")
public class DadosIncendioController {
    @Autowired
    private DadosIncendioService dadosIncendioService;

    @PostMapping
    public void adicionarDadosIncendio(@Valid @RequestBody DadosIncendio dadosIncendio) {dadosIncendioService.salvar(dadosIncendio);}

    @GetMapping(params={"Local"})
    public List<DadosIncendio> listarDadosIncendio(String local) {
        List<DadosIncendio> dados = (List)dadosIncendioService.buscarPorLocal(local);
        return dados;
    }

    @GetMapping
    public List<DadosIncendio> listarTodosDadosIncendio(){ return dadosIncendioService.buscarTodos(); }
}
