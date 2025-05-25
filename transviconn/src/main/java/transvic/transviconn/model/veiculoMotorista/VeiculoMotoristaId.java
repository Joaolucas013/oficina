package transvic.transviconn.model.veiculoMotorista;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class VeiculoMotoristaId implements Serializable {

    private String placa;
    private Long motoristaId;
    private LocalDate dataInicio;

    public VeiculoMotoristaId(String placa, Long motoristaId, LocalDate dataInicio) {
        this.placa = placa;
        this.motoristaId = motoristaId;
        this.dataInicio = dataInicio;
    }

    public VeiculoMotoristaId() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoMotoristaId that = (VeiculoMotoristaId) o;
        return Objects.equals(placa, that.placa) && Objects.equals(motoristaId, that.motoristaId) && Objects.equals(dataInicio, that.dataInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa, motoristaId, dataInicio);
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Long motoristaId) {
        this.motoristaId = motoristaId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
}
