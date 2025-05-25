package transvic.transviconn.model.procedimento;

import transvic.transviconn.model.setor.Setor;

public record ProcedimentoDto(
        String descricao,
        Double valor,
        Setor setor) {
}
