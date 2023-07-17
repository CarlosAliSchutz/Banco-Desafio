package br.com.banco.mapper;

import br.com.banco.controller.response.TransferenciaResponse;
import br.com.banco.domain.Transferencia;

public class TransferenciaMapper {

    public static TransferenciaResponse toResponse(Transferencia transferencia) {
        return TransferenciaResponse.builder()
                .dataTransferencia(transferencia.getDataTransferencia())
                .valor(transferencia.getValor())
                .tipo(transferencia.getTipo().name())
                .nomeOperadorTransacao(transferencia.getNomeOperadorTransacao())
                .build();
    }
}
