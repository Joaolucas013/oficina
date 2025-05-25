package transvic.transviconn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transvic.transviconn.model.procedimento.Procedimento;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
}
