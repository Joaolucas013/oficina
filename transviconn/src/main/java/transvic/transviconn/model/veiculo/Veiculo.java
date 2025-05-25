package transvic.transviconn.model.veiculo;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.marca.Marca;
import transvic.transviconn.model.modelo.Modelo;
import transvic.transviconn.model.motorista.Motorista;
import transvic.transviconn.model.veiculoMotorista.VeiculoMotorista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "veiculos")
@Entity(name = "Veiculo")
public class Veiculo {


    @Id
    private String placa;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "modelo_id")
    private Modelo modelo;

    private LocalDate anoFabricacao;
    private int quilometragem;
    private String cor;
    private String chassi;
    private boolean  ativo;

    @OneToMany(mappedBy = "veiculo")
    private List<VeiculoMotorista> veiculoMotoristas = new ArrayList<>();


    public void ativar() {
        this.ativo=true;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<VeiculoMotorista> getVeiculoMotoristas() {
        return veiculoMotoristas;
    }

    public void setVeiculoMotoristas(List<VeiculoMotorista> veiculoMotoristas) {
        this.veiculoMotoristas = veiculoMotoristas;
    }
}
