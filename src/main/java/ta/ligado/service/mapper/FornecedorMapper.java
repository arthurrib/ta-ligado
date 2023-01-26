package ta.ligado.service.mapper;

import org.mapstruct.*;
import ta.ligado.domain.Fornecedor;
import ta.ligado.service.dto.FornecedorDTO;

/**
 * Mapper for the entity {@link Fornecedor} and its DTO {@link FornecedorDTO}.
 */
@Mapper(componentModel = "spring")
public interface FornecedorMapper extends EntityMapper<FornecedorDTO, Fornecedor> {}
