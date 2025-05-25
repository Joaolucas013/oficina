package transvic.transviconn.model.veiculo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import transvic.transviconn.model.marca.Marca;
import transvic.transviconn.model.modelo.Modelo;

import java.time.LocalDate;

@JsonIgnoreProperties
public record DadosVeiculos(String placa, Marca marca, Modelo modelo, LocalDate anoFabricacao,
                            int quilometragem, String chassi) {


    public DadosVeiculos(Veiculo v, Marca m, Modelo modelo){
        this(v.getPlaca(), m, modelo, v.getAnoFabricacao(), v.getQuilometragem(),
                v.getChassi());
    }


}

