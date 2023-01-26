package ta.ligado.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ta.ligado.domain.Fornecedor;

/**
 * Spring Data JPA repository for the Fornecedor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {}
