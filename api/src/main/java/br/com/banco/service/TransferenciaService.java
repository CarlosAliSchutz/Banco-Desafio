package br.com.banco.service;

import br.com.banco.controller.response.TransferenciaResponse;
import br.com.banco.domain.Transferencia;
import br.com.banco.mapper.TransferenciaMapper;
import br.com.banco.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<TransferenciaResponse> listarTodas() {
        List<Transferencia> transferencias = transferenciaRepository.findAll();
        return transferencias.stream()
                .map(TransferenciaMapper::toResponse)
                .collect(toList());
    }

    public List<TransferenciaResponse> listarComFiltro(String dataInicial, String dataFinal, String nomeOperador) {
        LocalDateTime dataInicialConvertida = parseDataHora(dataInicial);
        LocalDateTime dataFinalConvertida = parseDataHora(dataFinal);

        List<Transferencia> transferencias = transferenciaRepository.findByFilters(
                dataInicialConvertida,
                dataFinalConvertida,
                nomeOperador
        );

        return transferencias.stream()
                .map(TransferenciaMapper::toResponse)
                .collect(Collectors.toList());
    }

    private LocalDateTime parseDataHora(String dataHoraString) {
        if (dataHoraString == null || dataHoraString.isEmpty()) {
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return LocalDateTime.parse(dataHoraString, formatter);
    }
}
