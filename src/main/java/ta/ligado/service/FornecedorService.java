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
import ta.ligado.domain.Fornecedor;
import ta.ligado.repository.FornecedorRepository;
import ta.ligado.service.dto.FornecedorDTO;
import ta.ligado.service.mapper.FornecedorMapper;

/**
 * Service Implementation for managing {@link Fornecedor}.
 */
@Service
@Transactional
public class FornecedorService {

    private final Logger log = LoggerFactory.getLogger(FornecedorService.class);

    private final FornecedorRepository fornecedorRepository;

    private final FornecedorMapper fornecedorMapper;

    public FornecedorService(FornecedorRepository fornecedorRepository, FornecedorMapper fornecedorMapper) {
        this.fornecedorRepository = fornecedorRepository;
        this.fornecedorMapper = fornecedorMapper;
    }

    /**
     * Save a fornecedor.
     *
     * @param fornecedorDTO the entity to save.
     * @return the persisted entity.
     */
    public FornecedorDTO save(FornecedorDTO fornecedorDTO) {
        log.debug("Request to save Fornecedor : {}", fornecedorDTO);
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        return fornecedorMapper.toDto(fornecedor);
    }

    /**
     * Update a fornecedor.
     *
     * @param fornecedorDTO the entity to save.
     * @return the persisted entity.
     */
    public FornecedorDTO update(FornecedorDTO fornecedorDTO) {
        log.debug("Request to update Fornecedor : {}", fornecedorDTO);
        Fornecedor fornecedor = fornecedorMapper.toEntity(fornecedorDTO);
        fornecedor = fornecedorRepository.save(fornecedor);
        return fornecedorMapper.toDto(fornecedor);
    }

    /**
     * Partially update a fornecedor.
     *
     * @param fornecedorDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FornecedorDTO> partialUpdate(FornecedorDTO fornecedorDTO) {
        log.debug("Request to partially update Fornecedor : {}", fornecedorDTO);

        return fornecedorRepository
            .findById(fornecedorDTO.getId())
            .map(existingFornecedor -> {
                fornecedorMapper.partialUpdate(existingFornecedor, fornecedorDTO);

                return existingFornecedor;
            })
            .map(fornecedorRepository::save)
            .map(fornecedorMapper::toDto);
    }

    /**
     * Get all the fornecedors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<FornecedorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Fornecedors");
        return fornecedorRepository.findAll(pageable).map(fornecedorMapper::toDto);
    }

    /**
     *  Get all the fornecedors where ProdutoFornecedor is {@code null}.
     *  @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FornecedorDTO> findAllWhereProdutoFornecedorIsNull() {
        log.debug("Request to get all fornecedors where ProdutoFornecedor is null");
        return StreamSupport
            .stream(fornecedorRepository.findAll().spliterator(), false)
            .filter(fornecedor -> fornecedor.getProdutoFornecedor() == null)
            .map(fornecedorMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one fornecedor by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FornecedorDTO> findOne(Long id) {
        log.debug("Request to get Fornecedor : {}", id);
        return fornecedorRepository.findById(id).map(fornecedorMapper::toDto);
    }

    /**
     * Delete the fornecedor by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Fornecedor : {}", id);
        fornecedorRepository.deleteById(id);
    }
}
