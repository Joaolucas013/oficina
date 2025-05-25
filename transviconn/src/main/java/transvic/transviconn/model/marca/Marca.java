package transvic.transviconn.model.marca;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.veiculo.Veiculo;

import java.util.List;

@JsonIgnoreProperties
@Table(name = "Marca")
@Entity(name = "Marca")
@AllArgsConstructor
@NoArgsConstructor
public class Marca {

    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    private Long marcaId;

   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "marca")
    private List<Veiculo> veiculo;  // uma marca tem varios veiculos;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Long marcaId) {
        this.marcaId = marcaId;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
}
