package transvic.transviconn.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import transvic.transviconn.model.veiculoMotorista.UpdateVeiculoMotorista;
import transvic.transviconn.model.veiculoMotorista.VeiculoMotorista;
import transvic.transviconn.model.veiculoMotorista.VeiculoMotoristaId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface VeiculoMotoristaRepository extends JpaRepository<VeiculoMotorista, VeiculoMotoristaId> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE  veiculo_motorista mv SET  mv.data_fim= :dataFim WHERE mv.placa= :placa AND mv.motorista_id= :motoristaId", nativeQuery = true)
    void update(
            @Param("dataFim") LocalDate dataFim,
            @Param("placa") String placa,
            @Param("motoristaId") long motoristaId);


    @Transactional
    @Query(value = "SELECT * FROM  veiculo_motorista mv  WHERE mv.placa= :placa AND mv.motorista_id= :motoristaId", nativeQuery = true)
    VeiculoMotorista buscar(@Param("placa") String placa,
                            @Param("motoristaId") Long motoristaId);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM veiculo_motorista mv where mv.placa= :placa and mv.motorista_id= :idMotorista and mv.data_inicio= :dataInicio", nativeQuery = true)
    void deletar(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("idMotorista") Long idMotorista,
            @Param("placa") String placa);

}


