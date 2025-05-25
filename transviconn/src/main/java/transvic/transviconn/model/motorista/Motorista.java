package transvic.transviconn.model.motorista;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.veiculoMotorista.VeiculoMotorista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "motoristas")
@Entity(name = "Motorista")
@AllArgsConstructor
@NoArgsConstructor
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerado automaticamente
    private long motoristaId;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String habilitacao;


    @OneToMany(mappedBy = "motorista")
    List<VeiculoMotorista> veiculoMotoristaList = new ArrayList<>();

    @Column
    private boolean ativo;
    @Column
    private LocalDate dataAdmissao;
    @Column
    private LocalDate dataDemissao;


    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(long motoristaId) {
        this.motoristaId = motoristaId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VeiculoMotorista> getVeiculoMotoristaList() {
        return veiculoMotoristaList;
    }

    public void setVeiculoMotoristaList(List<VeiculoMotorista> veiculoMotoristaList) {
        this.veiculoMotoristaList = veiculoMotoristaList;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    public void ativar() {
        this.ativo=true;
    }
}
