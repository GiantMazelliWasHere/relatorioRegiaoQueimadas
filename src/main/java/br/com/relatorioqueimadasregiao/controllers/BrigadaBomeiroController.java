package br.com.relatorioqueimadasregiao.controllers;

import br.com.relatorioqueimadasregiao.entities.BrigadaBombeiro;
import br.com.relatorioqueimadasregiao.services.BrigadaBombeiroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/brigada")
public class BrigadaBomeiroController {
    @Autowired
    private BrigadaBombeiroService brigadaBombeiroService;

    @PostMapping
    public void criarBrigada(@RequestBody @Valid BrigadaBombeiro brigadaBombeiro) {brigadaBombeiroService.criarBrigadaBombeiro(brigadaBombeiro);}

    @GetMapping
    public List<BrigadaBombeiro> listarTodasBrigadas() {return brigadaBombeiroService.buscarTodasBrigadas();}
}
