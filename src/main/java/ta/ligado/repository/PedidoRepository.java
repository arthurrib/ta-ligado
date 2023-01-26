package ta.ligado.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import ta.ligado.domain.Pedido;

/**
 * Spring Data JPA repository for the Pedido entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
