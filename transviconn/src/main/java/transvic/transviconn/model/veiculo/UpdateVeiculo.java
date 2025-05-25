
package transvic.transviconn.model.veiculo;

import java.time.LocalDate;

public record UpdateVeiculo(String placa,
                            LocalDate anoFabricacao,
                            int quilometragem,
                            String cor,
                            String chassi ) {
}


