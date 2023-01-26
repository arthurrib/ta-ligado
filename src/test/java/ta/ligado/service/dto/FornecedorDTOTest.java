package ta.ligado.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ta.ligado.web.rest.TestUtil;

class FornecedorDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FornecedorDTO.class);
        FornecedorDTO fornecedorDTO1 = new FornecedorDTO();
        fornecedorDTO1.setId(1L);
        FornecedorDTO fornecedorDTO2 = new FornecedorDTO();
        assertThat(fornecedorDTO1).isNotEqualTo(fornecedorDTO2);
        fornecedorDTO2.setId(fornecedorDTO1.getId());
        assertThat(fornecedorDTO1).isEqualTo(fornecedorDTO2);
        fornecedorDTO2.setId(2L);
        assertThat(fornecedorDTO1).isNotEqualTo(fornecedorDTO2);
        fornecedorDTO1.setId(null);
        assertThat(fornecedorDTO1).isNotEqualTo(fornecedorDTO2);
    }
}
