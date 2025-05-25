package transvic.transviconn.model.funcionario;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record FuncionarioDto(
        Long funcionarioId,
        Long setorId,

        @NotBlank
        String nome,
        @NotBlank
        String cpf,

        LocalDate dataAdmissao,
        LocalDate dataDemissao,
        LocalDate dataNascimento,
        String profissao

) {

}
