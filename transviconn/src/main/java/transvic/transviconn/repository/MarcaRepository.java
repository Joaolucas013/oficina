package transvic.transviconn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transvic.transviconn.model.marca.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
