package transvic.transviconn.model.procedimento;

import transvic.transviconn.model.setor.Setor;

public record ProcedimentoResponse(
        Long id,
        String descricao,
        Double valor,
        Setor setor
) {
}
