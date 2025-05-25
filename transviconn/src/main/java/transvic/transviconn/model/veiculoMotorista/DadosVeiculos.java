package transvic.transviconn.model.veiculoMotorista;

import java.time.LocalDate;

public record DadosVeiculos(
        long motoristaId,
        String placa,
        LocalDate dataInicio,
        LocalDate dataFim

)
{

}
