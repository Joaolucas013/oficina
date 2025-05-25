package transvic.transviconn.repository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import transvic.transviconn.model.veiculo.Veiculo;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {



    Page<Veiculo> findAllByAtivoTrue(Pageable paginacao);

    @Modifying
    @Transactional
    @Query(value = "UPDATE veiculo v set v.ativo=false where v.placa= :placa", nativeQuery = true)
    int inativar(@Param("placa") String placa);


    Veiculo findByPlaca(@Param("placa") String placa);


    @Query(value = "SELECT * FROM veiculos v WHERE upper(v.placa) = upper(:placa)", nativeQuery = true)
    Veiculo buscarVeiculo(@Param("placa") String placa);



}

