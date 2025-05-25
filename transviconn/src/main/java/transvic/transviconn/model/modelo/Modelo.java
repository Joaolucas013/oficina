package transvic.transviconn.model.modelo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.veiculo.Veiculo;

import java.util.List;


@JsonIgnoreProperties
@Table(name = "modelo")
@Entity(name = "Modelo")
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {

    @Column(nullable = false)
    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "modelo_id")
    private Long modelo;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "modelo", fetch = FetchType.LAZY)
    private List<Veiculo> veiculo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getModelo() {
        return modelo;
    }

    public void setModelo(Long modelo) {
        this.modelo = modelo;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
}
