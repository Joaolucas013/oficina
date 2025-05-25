package transvic.transviconn.model.veiculoMotorista;

import java.time.LocalDate;

public record DeleteVeiculoMotorista(
        String placa,
        Long motoristaId,
        LocalDate dataInicio
) {

}
