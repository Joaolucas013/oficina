package transvic.transviconn.model.setor;

import transvic.transviconn.model.funcionario.Funcionario;
import transvic.transviconn.model.procedimento.ListaProcedimentos;

import java.util.List;

public record ListaSetores(Long id, String descricao, List<DadosFuncionariosSetores> funcionarios, List<ListaProcedimentos> procedimentos) {


    public ListaSetores(Setor s) {
        this(s.getId(), s.getDescricao(),
                s.getFuncionarios().stream()
                        .map(f -> new DadosFuncionariosSetores(f.getNome(),
                                f.getCpf(), f.getProfissao())).toList(),
                s.getProcedimento()
                        .stream()
                        .map(p -> new ListaProcedimentos(p.getDescricao(),
                                p.getValorProcedimento())).toList());
    }

}
