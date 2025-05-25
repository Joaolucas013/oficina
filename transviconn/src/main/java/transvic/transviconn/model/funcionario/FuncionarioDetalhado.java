package transvic.transviconn.model.funcionario;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.setor.Setor;


import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDetalhado{

       private  String nome;
      private  String cpf;
       private  Long funcionarioId;
      private  LocalDate dataNascimento;
       private LocalDate dataAdmissao;
      private Setor setor;
       private String profissao;



    public  FuncionarioDetalhado(Funcionario f, Setor s) {
     this.cpf=f.getCpf();
     this.nome = f.getNome();
     this.funcionarioId = f.getFuncionarioId();
    this.setor = s;
     this.profissao = f.getProfissao();
     this.dataAdmissao = f.getDataAdmissao();
     this.dataNascimento = f.getDataNascimento();
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

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}

