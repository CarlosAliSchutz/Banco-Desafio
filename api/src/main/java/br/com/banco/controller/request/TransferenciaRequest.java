package br.com.banco.controller.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class TransferenciaRequest {

    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;
    private String nomeOperador;
}
