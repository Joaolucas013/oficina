package transvic.transviconn.model.veiculoMotorista;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import transvic.transviconn.model.motorista.Motorista;
import transvic.transviconn.model.veiculo.Veiculo;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Table(name = "veiculo_Motorista")
@Entity(name = "VeiculoMotorista")
public class VeiculoMotorista {


    @EmbeddedId
    private VeiculoMotoristaId id;

    public VeiculoMotorista(Veiculo veiculo, Motorista motorista, LocalDate dataInicio, LocalDate dataFim) {
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.dataFim = dataFim;
        this.id = new VeiculoMotoristaId(veiculo.getPlaca(), motorista.getMotoristaId(), dataInicio);
    }

    public VeiculoMotorista() {
    }

    @MapsId("placa")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placa")
    private Veiculo veiculo;

    @MapsId("motoristaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

    @Column
    private LocalDate dataFim;


    public VeiculoMotoristaId getId() {
        return id;
    }

    public void setId(VeiculoMotoristaId id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
