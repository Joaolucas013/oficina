package transvic.transviconn.model.funcionario;

import jakarta.validation.constraints.NotBlank;
import transvic.transviconn.model.setor.Setor;

import java.time.LocalDate;

public record UpdateFuncionario(

        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        LocalDate dataAdmissao,
        LocalDate dataNascimento,
        Setor setor,
        String profissao
) {
    public  UpdateFuncionario(Funcionario f, Setor s){
        this(f.getFuncionarioId(),f.getNome(), f.getCpf(), f.getDataAdmissao(), f.getDataNascimento(), s,f.getProfissao());
    }
}
