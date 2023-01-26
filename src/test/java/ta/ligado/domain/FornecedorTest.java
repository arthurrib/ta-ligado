package ta.ligado.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ta.ligado.web.rest.TestUtil;

class FornecedorTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Fornecedor.class);
        Fornecedor fornecedor1 = new Fornecedor();
        fornecedor1.setId(1L);
        Fornecedor fornecedor2 = new Fornecedor();
        fornecedor2.setId(fornecedor1.getId());
        assertThat(fornecedor1).isEqualTo(fornecedor2);
        fornecedor2.setId(2L);
        assertThat(fornecedor1).isNotEqualTo(fornecedor2);
        fornecedor1.setId(null);
        assertThat(fornecedor1).isNotEqualTo(fornecedor2);
    }
}
