package transvic.transviconn.model.procedimento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import transvic.transviconn.model.setor.Setor;

@Entity
@Table(name = "procedimentos")
@AllArgsConstructor
@NoArgsConstructor
public class Procedimento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProcedimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "setor_id")
    private Setor setor;

    @Column(nullable = false)
    private String descricao;

    @Column
    private Double valorProcedimento;

    public Long getIdProcedimento() {
        return idProcedimento;
    }

    public void setIdProcedimento(Long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public void setIdProcedimento(long idProcedimento) {
        this.idProcedimento = idProcedimento;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorProcedimento() {
        return valorProcedimento;
    }

    public void setValorProcedimento(Double valorProcedimento) {
        this.valorProcedimento = valorProcedimento;
    }
}
