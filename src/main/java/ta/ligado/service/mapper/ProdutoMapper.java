package ta.ligado.service.mapper;

import org.mapstruct.*;
import ta.ligado.domain.Produto;
import ta.ligado.service.dto.ProdutoDTO;

/**
 * Mapper for the entity {@link Produto} and its DTO {@link ProdutoDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {}
