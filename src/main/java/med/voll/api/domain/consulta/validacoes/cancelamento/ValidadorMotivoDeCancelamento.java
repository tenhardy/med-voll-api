package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.MotivoCancelamento;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class ValidadorMotivoDeCancelamento implements ValidadorCancelamentoDeConsulta {
    public void validar(DadosCancelamentoConsulta dados) {
        var motivo = dados.motivo();
        boolean motivoValido = Arrays.stream(MotivoCancelamento.values()).anyMatch(m -> m.equals(motivo));

        if (!motivoValido)
            throw new ValidacaoException("Motivo de cancelamento não é válido");

    }
}
