package  transvic.transviconn.model.funcionario;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.setor.Setor;


import java.time.LocalDate;

@Table(name="funcionarios")
@Entity(name = "Funcionario")
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long funcionarioId;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name ="setor_id")  // coluna que referencia setor em funcionario
    private Setor setor;


    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataAdmissao;

    @Column
    private LocalDate dataDemissao;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = false)
    private String profissao;

    @Column
    private boolean ativo;


    public void ativar() {
        this.ativo=true;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
