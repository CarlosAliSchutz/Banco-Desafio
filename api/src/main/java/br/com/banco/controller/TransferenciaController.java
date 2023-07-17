package br.com.banco.controller;

import br.com.banco.controller.response.TransferenciaResponse;
import br.com.banco.service.TransferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transferencias")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<TransferenciaResponse> filtrarTransferencias(
            @RequestParam(required = false) String dataInicial,
            @RequestParam(required = false) String dataFinal,
            @RequestParam(required = false) String nomeOperador
    ) {

        if (dataInicial == null && dataFinal == null && nomeOperador == null) {
            return transferenciaService.listarTodas();
        } else {
            return transferenciaService.listarComFiltro(dataInicial, dataFinal, nomeOperador);
        }
    }
}