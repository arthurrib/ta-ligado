package ta.ligado.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ta.ligado.web.rest.TestUtil;

class ProdutoFornecedorDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProdutoFornecedorDTO.class);
        ProdutoFornecedorDTO produtoFornecedorDTO1 = new ProdutoFornecedorDTO();
        produtoFornecedorDTO1.setId(1L);
        ProdutoFornecedorDTO produtoFornecedorDTO2 = new ProdutoFornecedorDTO();
        assertThat(produtoFornecedorDTO1).isNotEqualTo(produtoFornecedorDTO2);
        produtoFornecedorDTO2.setId(produtoFornecedorDTO1.getId());
        assertThat(produtoFornecedorDTO1).isEqualTo(produtoFornecedorDTO2);
        produtoFornecedorDTO2.setId(2L);
        assertThat(produtoFornecedorDTO1).isNotEqualTo(produtoFornecedorDTO2);
        produtoFornecedorDTO1.setId(null);
        assertThat(produtoFornecedorDTO1).isNotEqualTo(produtoFornecedorDTO2);
    }
}
