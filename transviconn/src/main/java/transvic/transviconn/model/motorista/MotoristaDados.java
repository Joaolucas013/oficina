package transvic.transviconn.model.motorista;

import transvic.transviconn.model.veiculoMotorista.VeiculoMotorista;

import java.time.LocalDate;
import java.util.List;

public record MotoristaDados(
        long motoristaId,
        String habilitacao,
        String cpf,
        String nome,
        LocalDate dataAdmissao,
        LocalDate dataDemissao
) {

    public MotoristaDados(Motorista m ) {
        this(m.getMotoristaId(),m.getHabilitacao(), m.getCpf(), m.getNome(), m.getDataAdmissao(), m.getDataDemissao());
    }

}
