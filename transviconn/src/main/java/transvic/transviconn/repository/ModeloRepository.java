package transvic.transviconn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transvic.transviconn.model.modelo.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
