package transvic.transviconn.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import transvic.transviconn.model.motorista.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {


    Page<Motorista> findAllByAtivoTrue(Pageable pageable);


    @Modifying
    @Query(value = "UPDATE motoristas m set m.ativo=false where m.motorista_id= :id",
            nativeQuery = true
    )
    void inativar(long id);


    @Transactional
    @Query(value = "SELECT * FROM motoristas m where m.motorista_id= :id", nativeQuery = true)
    Motorista BuscarPeloId(@Param("id") Long id);
}
