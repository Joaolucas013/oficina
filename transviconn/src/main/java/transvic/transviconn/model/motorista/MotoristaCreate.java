package transvic.transviconn.model.motorista;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MotoristaCreate {

        private String cpf;
        private String habilitacao;
        private String nome;
        private LocalDate dataAdmissao;
        private LocalDate dataDemissao;


        public LocalDate getDataDemissao() {
                return dataDemissao;
        }

        public void setDataDemissao(LocalDate dataDemissao) {
                this.dataDemissao = dataDemissao;
        }

        public LocalDate getDataAdmissao() {
                return dataAdmissao;
        }

        public void setDataAdmissao(LocalDate dataAdmissao) {
                this.dataAdmissao = dataAdmissao;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getHabilitacao() {
                return habilitacao;
        }

        public void setHabilitacao(String habilitacao) {
                this.habilitacao = habilitacao;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }
}
