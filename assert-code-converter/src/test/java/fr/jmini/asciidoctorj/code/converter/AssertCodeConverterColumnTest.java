package fr.jmini.asciidoctorj.code.converter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.asciidoctor.ast.Column;
import org.asciidoctor.ast.Table;
import org.junit.Test;

public class AssertCodeConverterColumnTest {

    @Test
    public void testColumn() throws Exception {
        Column mockColumn = mock(Column.class);
        when(mockColumn.getStyle()).thenReturn("STYLE");
        when(mockColumn.getTable()).thenReturn(null);
        when(mockColumn.getColumnNumber()).thenReturn(2);
        when(mockColumn.getWidth()).thenReturn(550);
        when(mockColumn.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.CENTER);
        when(mockColumn.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.MIDDLE);

        AssertCodeConverter converter = new AssertCodeConverter(null, null);
        StringBuilder sb = new StringBuilder();
        converter.createColumnCode(sb, mockColumn);
        CodeTestingUtility.testGeneratedCode(sb.toString(), this.getClass());

        checkAst(mockColumn);
    }

    // tag::generated-code[]
    public void checkAst(Column astColumn) {
        Column column1 = astColumn;
        assertThat(column1.getId()).isNull();
        assertThat(column1.getNodeName()).isNull();
        assertThat(column1.getParent()).isNull();
        assertThat(column1.getContext()).isNull();
        assertThat(column1.getDocument()).isNull();
        assertThat(column1.isInline()).isFalse();
        assertThat(column1.isBlock()).isFalse();
        assertThat(column1.getAttributes()).isEmpty();
        assertThat(column1.getRoles()).isEmpty();
        assertThat(column1.isReftext()).isFalse();
        assertThat(column1.getStyle()).isEqualTo("STYLE");
        assertThat(column1.getTable()).isNull();
        assertThat(column1.getColumnNumber()).isEqualTo(2);
        assertThat(column1.getWidth()).isEqualTo(550);
        assertThat(column1.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.CENTER);
        assertThat(column1.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.MIDDLE);
    }
    // end::generated-code[]
}
