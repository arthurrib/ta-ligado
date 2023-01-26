package ta.ligado.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ta.ligado.domain.ProdutoFornecedor;

/**
 * Spring Data JPA repository for the ProdutoFornecedor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProdutoFornecedorRepository extends JpaRepository<ProdutoFornecedor, Long> {}
