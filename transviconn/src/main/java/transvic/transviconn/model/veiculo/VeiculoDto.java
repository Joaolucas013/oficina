package transvic.transviconn.model.veiculo;

import jakarta.validation.constraints.NotNull;
import transvic.transviconn.model.marca.Marca;
import transvic.transviconn.model.modelo.Modelo;

import java.time.LocalDate;

public record VeiculoDto(String placa,
                         @NotNull
                         Marca marca,
                         @NotNull
                         Modelo modeloId, LocalDate anoFabricacao,
                         int quilometragem, String chassi, String cor) {

    public VeiculoDto(Veiculo v, Marca m, Modelo modelo){
        this(v.getPlaca(), m, modelo, v.getAnoFabricacao(),
                v.getQuilometragem(), v.getChassi(), v.getCor());
    }
}
