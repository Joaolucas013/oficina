package transvic.transviconn.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import transvic.transviconn.model.setor.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {


    @Transactional
    @Modifying
    @Query(value = "UPDATE setores s SET s.ativo=false where s.id= :id", nativeQuery = true)
    void inativar(
            @Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE setores s SET s.ativo=true where s.id= :id", nativeQuery = true)
    void ativar(
            @Param("id") Long id);
}
