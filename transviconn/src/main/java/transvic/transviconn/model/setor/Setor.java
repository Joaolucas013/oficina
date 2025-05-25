package transvic.transviconn.model.setor;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.funcionario.Funcionario;
import transvic.transviconn.model.procedimento.Procedimento;


import java.util.List;

@Entity(name = "Setor")
@Table(name = "setores")
@AllArgsConstructor
@NoArgsConstructor
public class Setor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    private List<Funcionario> funcionarios;        // um setor tem varios funcionários

    @Column(nullable = false)
    private String descricao;

    @Column
    private Boolean ativo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "setor", fetch = FetchType.EAGER)
    private List<Procedimento> procedimento;


    public List<Procedimento> getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(List<Procedimento> procedimento) {
        this.procedimento = procedimento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public void ativar() {
        this.ativo=true;
    }
}
