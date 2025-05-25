package transvic.transviconn.model.setor;

import transvic.transviconn.model.funcionario.Funcionario;

import java.util.List;

public record SetorReturn(
        Long id,
        String descricao
) {

    public SetorReturn(Setor s) {
        this(s.getId(), s.getDescricao());
    }

}
