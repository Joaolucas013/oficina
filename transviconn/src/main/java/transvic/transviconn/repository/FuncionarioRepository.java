package transvic.transviconn.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import transvic.transviconn.model.funcionario.Funcionario;
import transvic.transviconn.model.setor.Setor;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Page<Funcionario> findAllByAtivoTrue(Pageable pageable);


    @Modifying
    @Transactional
    @Query(value = "UPDATE funcionarios f SET f.ativo=false where f.funcionario_id= :id",
            nativeQuery = true)
    void inativar(long id);


    Funcionario findByCpf(String cpf);
    Funcionario findByCpfAndSetorId(String cpf, Setor setor);



}
