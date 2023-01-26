package ta.ligado.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ta.ligado.domain.Produto;
import ta.ligado.repository.ProdutoRepository;
import ta.ligado.service.dto.ProdutoDTO;
import ta.ligado.service.mapper.ProdutoMapper;

/**
 * Service Implementation for managing {@link Produto}.
 */
@Service
@Transactional
public class ProdutoService {

    private final Logger log = LoggerFactory.getLogger(ProdutoService.class);

    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;

    public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }

    /**
     * Save a produto.
     *
     * @param produtoDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        log.debug("Request to save Produto : {}", produtoDTO);
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    /**
     * Update a produto.
     *
     * @param produtoDTO the entity to save.
     * @return the persisted entity.
     */
    public ProdutoDTO update(ProdutoDTO produtoDTO) {
        log.debug("Request to update Produto : {}", produtoDTO);
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    /**
     * Partially update a produto.
     *
     * @param produtoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ProdutoDTO> partialUpdate(ProdutoDTO produtoDTO) {
        log.debug("Request to partially update Produto : {}", produtoDTO);

        return produtoRepository
            .findById(produtoDTO.getId())
            .map(existingProduto -> {
                produtoMapper.partialUpdate(existingProduto, produtoDTO);

                return existingProduto;
            })
            .map(produtoRepository::save)
            .map(produtoMapper::toDto);
    }

    /**
     * Get all the produtos.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Produtos");
        return produtoRepository.findAll(pageable).map(produtoMapper::toDto);
    }

    /**
     *  Get all the produtos where ProdutoFornecedor is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<ProdutoDTO> findAllWhereProdutoFornecedorIsNull() {
        log.debug("Request to get all produtos where ProdutoFornecedor is null");
        return StreamSupport
            .stream(produtoRepository.findAll().spliterator(), false)
            .filter(produto -> produto.getProdutoFornecedor() == null)
            .map(produtoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one produto by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ProdutoDTO> findOne(Long id) {
        log.debug("Request to get Produto : {}", id);
        return produtoRepository.findById(id).map(produtoMapper::toDto);
    }

    /**
     * Delete the produto by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Produto : {}", id);
        produtoRepository.deleteById(id);
    }
}
