package ta.ligado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ta.ligado.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
