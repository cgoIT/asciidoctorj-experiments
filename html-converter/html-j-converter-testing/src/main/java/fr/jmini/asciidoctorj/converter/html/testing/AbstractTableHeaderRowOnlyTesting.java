package fr.jmini.asciidoctorj.converter.html.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.asciidoctor.ast.Cell;
import org.asciidoctor.ast.Column;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.Row;
import org.asciidoctor.ast.Table;
import org.junit.Test;

public abstract class AbstractTableHeaderRowOnlyTesting {

    @Test
    public void test() throws Exception {
        String asciiDoc = createAsciiDocInput();
        Document astDocument = createAstDocument(asciiDoc);
        checkAst(astDocument);
        String html = convertToHtml(astDocument);
        assertThat(html).isEqualTo(EXPECTED_HTML);
    }

    public static final String ASCIIDOC = "" +
            "[cols=2*,options=\"header\"]\n" +
            "|===\n" +
            "|Name of Column 1\n" +
            "|Name of Column 2\n" +
            "|===";

    // tag::expected-html[]
    public static final String EXPECTED_HTML = "<table class=\"tableblock frame-all grid-all spread\">\n" +
            "<colgroup>\n" +
            "<col style=\"width: 50%;\" />\n" +
            "<col style=\"width: 50%;\" />\n" +
            "</colgroup>\n" +
            "<thead>\n" +
            "<tr>\n" +
            "<th class=\"tableblock halign-left valign-top\">Name of Column 1</th>\n" +
            "<th class=\"tableblock halign-left valign-top\">Name of Column 2</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "</table>";
    // end::expected-html[]

    public String createAsciiDocInput() {
        return ASCIIDOC;
    }

    protected abstract Document createAstDocument(String asciiDoc);

    protected abstract String convertToHtml(Document astDocument);

    // tag::assert-code[]
    public void checkAst(Document astDocument) {
        Document document1 = astDocument;
        assertThat(document1.getId()).isNull();
        assertThat(document1.getNodeName()).isEqualTo("document");
        assertThat(document1.getContext()).isEqualTo("document");
        assertThat(document1.getDocument()).isSameAs(document1);
        assertThat(document1.isInline()).isFalse();
        assertThat(document1.isBlock()).isTrue();
        assertThat(document1.getAttributes()).containsEntry("doctype", "article")
                .containsEntry("example-caption", "Example")
                .containsEntry("filetype", "html")
                .containsEntry("notitle", "")
                .containsEntry("prewrap", "")
                .containsEntry("table-caption", "Table");
        assertThat(document1.getRoles()).isNullOrEmpty();
        assertThat(document1.isReftext()).isFalse();
        assertThat(document1.getReftext()).isNull();
        assertThat(document1.getTitle()).isNull();
        assertThat(document1.getStyle()).isNull();
        assertThat(document1.getLevel()).isEqualTo(0);
        assertThat(document1.getContentModel()).isEqualTo("compound");
        assertThat(document1.getSourceLocation()).isNull();
        assertThat(document1.getSubstitutions()).isNullOrEmpty();
        assertThat(document1.getBlocks()).hasSize(1);
        Table table1 = (Table) document1.getBlocks()
                .get(0);
        assertThat(table1.getId()).isNull();
        assertThat(table1.getNodeName()).isEqualTo("table");
        assertThat(table1.getContext()).isEqualTo("table");
        assertThat(table1.getDocument()).isSameAs(document1);
        assertThat(table1.isInline()).isFalse();
        assertThat(table1.isBlock()).isTrue();
        assertThat(table1.getAttributes()).containsEntry("colcount", 2L)
                .containsEntry("cols", "2*")
                .containsEntry("header-option", "")
                .containsEntry("options", "header")
                .containsEntry("rowcount", 1L)
                .containsEntry("style", "table")
                .containsEntry("tablepcwidth", 100L);
        assertThat(table1.getRoles()).isNullOrEmpty();
        assertThat(table1.isReftext()).isFalse();
        assertThat(table1.getReftext()).isNull();
        assertThat(table1.getTitle()).isNull();
        assertThat(table1.getStyle()).isEqualTo("table");
        assertThat(table1.getLevel()).isEqualTo(0);
        assertThat(table1.getContentModel()).isEqualTo("compound");
        assertThat(table1.getSourceLocation()).isNull();
        assertThat(table1.getSubstitutions()).isNullOrEmpty();
        assertThat(table1.getBlocks()).isNullOrEmpty();
        assertThat(table1.hasHeaderOption()).isTrue();
        assertThat(table1.getColumns()).hasSize(2);
        Column column1 = (Column) table1.getColumns()
                .get(0);
        assertThat(column1.getId()).isNull();
        assertThat(column1.getNodeName()).isEqualTo("column");
        assertThat(column1.getParent()).isSameAs(table1);
        assertThat(column1.getContext()).isEqualTo("column");
        assertThat(column1.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            column1.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            column1.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(column1.getAttributes()).containsEntry("colnumber", 1L)
                .containsEntry("colpcwidth", 50L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(column1.getRoles()).isNullOrEmpty();
        assertThat(column1.isReftext()).isFalse();
        assertThat(column1.getReftext()).isNull();
        assertThat(column1.getStyle()).isNull();
        assertThat(column1.getTable()).isSameAs(table1);
        assertThat(column1.getColumnNumber()).isEqualTo(1);
        assertThat(column1.getWidth()).isEqualTo(1);
        assertThat(column1.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(column1.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        Column column2 = (Column) table1.getColumns()
                .get(1);
        assertThat(column2.getId()).isNull();
        assertThat(column2.getNodeName()).isEqualTo("column");
        assertThat(column2.getParent()).isSameAs(table1);
        assertThat(column2.getContext()).isEqualTo("column");
        assertThat(column2.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            column2.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            column2.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(column2.getAttributes()).containsEntry("colnumber", 2L)
                .containsEntry("colpcwidth", 50L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(column2.getRoles()).isNullOrEmpty();
        assertThat(column2.isReftext()).isFalse();
        assertThat(column2.getReftext()).isNull();
        assertThat(column2.getStyle()).isNull();
        assertThat(column2.getTable()).isSameAs(table1);
        assertThat(column2.getColumnNumber()).isEqualTo(2);
        assertThat(column2.getWidth()).isEqualTo(1);
        assertThat(column2.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(column2.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(table1.getHeader()).hasSize(1);
        Row row1 = (Row) table1.getHeader()
                .get(0);
        assertThat(row1.getCells()).hasSize(2);
        Cell cell1 = (Cell) row1.getCells()
                .get(0);
        assertThat(cell1.getId()).isNull();
        assertThat(cell1.getNodeName()).isEqualTo("cell");
        assertThat(cell1.getParent()).isSameAs(column1);
        assertThat(cell1.getContext()).isEqualTo("cell");
        assertThat(cell1.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell1.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell1.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell1.getAttributes()).containsEntry("colnumber", 1L)
                .containsEntry("colpcwidth", 50L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell1.getRoles()).isNullOrEmpty();
        assertThat(cell1.isReftext()).isFalse();
        assertThat(cell1.getReftext()).isNull();
        assertThat(cell1.getColumn()).isSameAs(column1);
        assertThat(cell1.getColspan()).isEqualTo(0);
        assertThat(cell1.getRowspan()).isEqualTo(0);
        assertThat(cell1.getText()).isEqualTo("Name of Column 1");
        assertThat(cell1.getSource()).isEqualTo("Name of Column 1");
        assertThat(cell1.getStyle()).isNull();
        assertThat(cell1.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell1.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell1.getInnerDocument()).isNull();
        Cell cell2 = (Cell) row1.getCells()
                .get(1);
        assertThat(cell2.getId()).isNull();
        assertThat(cell2.getNodeName()).isEqualTo("cell");
        assertThat(cell2.getParent()).isSameAs(column2);
        assertThat(cell2.getContext()).isEqualTo("cell");
        assertThat(cell2.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell2.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell2.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell2.getAttributes()).containsEntry("colnumber", 2L)
                .containsEntry("colpcwidth", 50L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell2.getRoles()).isNullOrEmpty();
        assertThat(cell2.isReftext()).isFalse();
        assertThat(cell2.getReftext()).isNull();
        assertThat(cell2.getColumn()).isSameAs(column2);
        assertThat(cell2.getColspan()).isEqualTo(0);
        assertThat(cell2.getRowspan()).isEqualTo(0);
        assertThat(cell2.getText()).isEqualTo("Name of Column 2");
        assertThat(cell2.getSource()).isEqualTo("Name of Column 2");
        assertThat(cell2.getStyle()).isNull();
        assertThat(cell2.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell2.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell2.getInnerDocument()).isNull();
        assertThat(table1.getFooter()).isNullOrEmpty();
        assertThat(table1.getBody()).isNullOrEmpty();
        assertThat(table1.getFrame()).isEqualTo("all");
        assertThat(table1.getGrid()).isEqualTo("all");
        assertThat(document1.getStructuredDoctitle()).isNull();
        assertThat(document1.getDoctitle()).isNull();
        assertThat(document1.getOptions()).containsEntry("header_footer", false);
    }
    // end::assert-code[]

}
