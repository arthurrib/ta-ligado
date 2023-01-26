package ta.ligado.service.mapper;

import org.mapstruct.*;
import ta.ligado.domain.Pedido;
import ta.ligado.service.dto.PedidoDTO;

/**
 * Mapper for the entity {@link Pedido} and its DTO {@link PedidoDTO}.
 */
@Mapper(componentModel = "spring")
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido> {}
