package ta.ligado.service.mapper;

import org.mapstruct.*;
import ta.ligado.domain.Fornecedor;
import ta.ligado.domain.Pedido;
import ta.ligado.domain.Produto;
import ta.ligado.domain.ProdutoFornecedor;
import ta.ligado.service.dto.FornecedorDTO;
import ta.ligado.service.dto.PedidoDTO;
import ta.ligado.service.dto.ProdutoDTO;
import ta.ligado.service.dto.ProdutoFornecedorDTO;

/**
 * Mapper for the entity {@link ProdutoFornecedor} and its DTO {@link ProdutoFornecedorDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProdutoFornecedorMapper extends EntityMapper<ProdutoFornecedorDTO, ProdutoFornecedor> {
    @Mapping(target = "produto", source = "produto", qualifiedByName = "produtoId")
    @Mapping(target = "fornecedor", source = "fornecedor", qualifiedByName = "fornecedorId")
    @Mapping(target = "produtoFornecedor", source = "produtoFornecedor", qualifiedByName = "pedidoId")
    ProdutoFornecedorDTO toDto(ProdutoFornecedor s);

    @Named("produtoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ProdutoDTO toDtoProdutoId(Produto produto);

    @Named("fornecedorId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FornecedorDTO toDtoFornecedorId(Fornecedor fornecedor);

    @Named("pedidoId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PedidoDTO toDtoPedidoId(Pedido pedido);
}
