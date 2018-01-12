package fr.jmini.asciidoctorj.testcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.ast.Cell;
import org.asciidoctor.ast.Column;
import org.asciidoctor.ast.Document;
import org.asciidoctor.ast.Row;
import org.asciidoctor.ast.Table;

public class TableWidthTestCase implements AdocTestCase {

    public static final String ASCIIDOC = "" +
            "[width=75%]\n" +
            "|===\n" +
            "|Name of Column 1 |Name of Column 2 |Name of Column 3\n" +
            "\n" +
            "|Cell in column 1, row 1\n" +
            "|Cell in column 2, row 1\n" +
            "|Cell in column 3, row 1\n" +
            "\n" +
            "|Cell in column 1, row 2\n" +
            "|Cell in column 2, row 2\n" +
            "|Cell in column 3, row 2\n" +
            "|===";

    @Override
    public String getAdocInput() {
        return ASCIIDOC;
    }

    @Override
    public Map<String, Object> getInputOptions() {
        return OptionsBuilder.options()
                .asMap();
    }

    // tag::expected-html[]
    public static final String EXPECTED_HTML = "" +
            "<table class=\"tableblock frame-all grid-all\" style=\"width: 75%;\">\n" +
            "<colgroup>\n" +
            "<col style=\"width: 33.3333%;\" />\n" +
            "<col style=\"width: 33.3333%;\" />\n" +
            "<col style=\"width: 33.3334%;\" />\n" +
            "</colgroup>\n" +
            "<thead>\n" +
            "<tr>\n" +
            "<th class=\"tableblock halign-left valign-top\">Name of Column 1</th>\n" +
            "<th class=\"tableblock halign-left valign-top\">Name of Column 2</th>\n" +
            "<th class=\"tableblock halign-left valign-top\">Name of Column 3</th>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "<tbody>\n" +
            "<tr>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 1, row 1</p></td>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 2, row 1</p></td>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 3, row 1</p></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 1, row 2</p></td>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 2, row 2</p></td>\n" +
            "<td class=\"tableblock halign-left valign-top\"><p class=\"tableblock\">Cell in column 3, row 2</p></td>\n" +
            "</tr>\n" +
            "</tbody>\n" +
            "</table>";
    // end::expected-html[]

    @Override
    public String getHtmlOutput() {
        return EXPECTED_HTML;
    }

    @Override
    // tag::assert-code[]
    public void checkAst(Document astDocument) {
        Document document1 = astDocument;
        assertThat(document1.getId()).isNull();
        assertThat(document1.getNodeName()).isEqualTo("document");
        assertThat(document1.getParent()).isNull();
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
        assertThat(table1.getParent()).isSameAs(document1);
        assertThat(table1.getContext()).isEqualTo("table");
        assertThat(table1.getDocument()).isSameAs(document1);
        assertThat(table1.isInline()).isFalse();
        assertThat(table1.isBlock()).isTrue();
        assertThat(table1.getAttributes()).containsEntry("colcount", 3L)
                .containsEntry("header-option", "")
                .containsEntry("options", "header")
                .containsEntry("rowcount", 3L)
                .containsEntry("style", "table")
                .containsEntry("tablepcwidth", 75L)
                .containsEntry("width", "75%");
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
        assertThat(table1.getColumns()).hasSize(3);
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
                .containsEntry("colpcwidth", 33.3333)
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
                .containsEntry("colpcwidth", 33.3333)
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
        Column column3 = (Column) table1.getColumns()
                .get(2);
        assertThat(column3.getId()).isNull();
        assertThat(column3.getNodeName()).isEqualTo("column");
        assertThat(column3.getParent()).isSameAs(table1);
        assertThat(column3.getContext()).isEqualTo("column");
        assertThat(column3.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            column3.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            column3.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(column3.getAttributes()).containsEntry("colnumber", 3L)
                .containsEntry("colpcwidth", 33.3334)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(column3.getRoles()).isNullOrEmpty();
        assertThat(column3.isReftext()).isFalse();
        assertThat(column3.getReftext()).isNull();
        assertThat(column3.getStyle()).isNull();
        assertThat(column3.getTable()).isSameAs(table1);
        assertThat(column3.getColumnNumber()).isEqualTo(3);
        assertThat(column3.getWidth()).isEqualTo(1);
        assertThat(column3.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(column3.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(table1.getHeader()).hasSize(1);
        Row row1 = (Row) table1.getHeader()
                .get(0);
        assertThat(row1.getCells()).hasSize(3);
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
        Cell cell3 = (Cell) row1.getCells()
                .get(2);
        assertThat(cell3.getId()).isNull();
        assertThat(cell3.getNodeName()).isEqualTo("cell");
        assertThat(cell3.getParent()).isSameAs(column3);
        assertThat(cell3.getContext()).isEqualTo("cell");
        assertThat(cell3.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell3.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell3.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell3.getAttributes()).containsEntry("colnumber", 3L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell3.getRoles()).isNullOrEmpty();
        assertThat(cell3.isReftext()).isFalse();
        assertThat(cell3.getReftext()).isNull();
        assertThat(cell3.getColumn()).isSameAs(column3);
        assertThat(cell3.getColspan()).isEqualTo(0);
        assertThat(cell3.getRowspan()).isEqualTo(0);
        assertThat(cell3.getText()).isEqualTo("Name of Column 3");
        assertThat(cell3.getSource()).isEqualTo("Name of Column 3");
        assertThat(cell3.getStyle()).isNull();
        assertThat(cell3.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell3.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell3.getInnerDocument()).isNull();
        assertThat(table1.getFooter()).isNullOrEmpty();
        assertThat(table1.getBody()).hasSize(2);
        Row row2 = (Row) table1.getBody()
                .get(0);
        assertThat(row2.getCells()).hasSize(3);
        Cell cell4 = (Cell) row2.getCells()
                .get(0);
        assertThat(cell4.getId()).isNull();
        assertThat(cell4.getNodeName()).isEqualTo("cell");
        assertThat(cell4.getParent()).isSameAs(column1);
        assertThat(cell4.getContext()).isEqualTo("cell");
        assertThat(cell4.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell4.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell4.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell4.getAttributes()).containsEntry("colnumber", 1L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell4.getRoles()).isNullOrEmpty();
        assertThat(cell4.isReftext()).isFalse();
        assertThat(cell4.getReftext()).isNull();
        assertThat(cell4.getColumn()).isSameAs(column1);
        assertThat(cell4.getColspan()).isEqualTo(0);
        assertThat(cell4.getRowspan()).isEqualTo(0);
        assertThat(cell4.getText()).isEqualTo("Cell in column 1, row 1");
        assertThat(cell4.getSource()).isEqualTo("Cell in column 1, row 1");
        assertThat(cell4.getStyle()).isNull();
        assertThat(cell4.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell4.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell4.getInnerDocument()).isNull();
        Cell cell5 = (Cell) row2.getCells()
                .get(1);
        assertThat(cell5.getId()).isNull();
        assertThat(cell5.getNodeName()).isEqualTo("cell");
        assertThat(cell5.getParent()).isSameAs(column2);
        assertThat(cell5.getContext()).isEqualTo("cell");
        assertThat(cell5.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell5.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell5.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell5.getAttributes()).containsEntry("colnumber", 2L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell5.getRoles()).isNullOrEmpty();
        assertThat(cell5.isReftext()).isFalse();
        assertThat(cell5.getReftext()).isNull();
        assertThat(cell5.getColumn()).isSameAs(column2);
        assertThat(cell5.getColspan()).isEqualTo(0);
        assertThat(cell5.getRowspan()).isEqualTo(0);
        assertThat(cell5.getText()).isEqualTo("Cell in column 2, row 1");
        assertThat(cell5.getSource()).isEqualTo("Cell in column 2, row 1");
        assertThat(cell5.getStyle()).isNull();
        assertThat(cell5.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell5.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell5.getInnerDocument()).isNull();
        Cell cell6 = (Cell) row2.getCells()
                .get(2);
        assertThat(cell6.getId()).isNull();
        assertThat(cell6.getNodeName()).isEqualTo("cell");
        assertThat(cell6.getParent()).isSameAs(column3);
        assertThat(cell6.getContext()).isEqualTo("cell");
        assertThat(cell6.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell6.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell6.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell6.getAttributes()).containsEntry("colnumber", 3L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell6.getRoles()).isNullOrEmpty();
        assertThat(cell6.isReftext()).isFalse();
        assertThat(cell6.getReftext()).isNull();
        assertThat(cell6.getColumn()).isSameAs(column3);
        assertThat(cell6.getColspan()).isEqualTo(0);
        assertThat(cell6.getRowspan()).isEqualTo(0);
        assertThat(cell6.getText()).isEqualTo("Cell in column 3, row 1");
        assertThat(cell6.getSource()).isEqualTo("Cell in column 3, row 1");
        assertThat(cell6.getStyle()).isNull();
        assertThat(cell6.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell6.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell6.getInnerDocument()).isNull();
        Row row3 = (Row) table1.getBody()
                .get(1);
        assertThat(row3.getCells()).hasSize(3);
        Cell cell7 = (Cell) row3.getCells()
                .get(0);
        assertThat(cell7.getId()).isNull();
        assertThat(cell7.getNodeName()).isEqualTo("cell");
        assertThat(cell7.getParent()).isSameAs(column1);
        assertThat(cell7.getContext()).isEqualTo("cell");
        assertThat(cell7.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell7.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell7.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell7.getAttributes()).containsEntry("colnumber", 1L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell7.getRoles()).isNullOrEmpty();
        assertThat(cell7.isReftext()).isFalse();
        assertThat(cell7.getReftext()).isNull();
        assertThat(cell7.getColumn()).isSameAs(column1);
        assertThat(cell7.getColspan()).isEqualTo(0);
        assertThat(cell7.getRowspan()).isEqualTo(0);
        assertThat(cell7.getText()).isEqualTo("Cell in column 1, row 2");
        assertThat(cell7.getSource()).isEqualTo("Cell in column 1, row 2");
        assertThat(cell7.getStyle()).isNull();
        assertThat(cell7.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell7.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell7.getInnerDocument()).isNull();
        Cell cell8 = (Cell) row3.getCells()
                .get(1);
        assertThat(cell8.getId()).isNull();
        assertThat(cell8.getNodeName()).isEqualTo("cell");
        assertThat(cell8.getParent()).isSameAs(column2);
        assertThat(cell8.getContext()).isEqualTo("cell");
        assertThat(cell8.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell8.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell8.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell8.getAttributes()).containsEntry("colnumber", 2L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell8.getRoles()).isNullOrEmpty();
        assertThat(cell8.isReftext()).isFalse();
        assertThat(cell8.getReftext()).isNull();
        assertThat(cell8.getColumn()).isSameAs(column2);
        assertThat(cell8.getColspan()).isEqualTo(0);
        assertThat(cell8.getRowspan()).isEqualTo(0);
        assertThat(cell8.getText()).isEqualTo("Cell in column 2, row 2");
        assertThat(cell8.getSource()).isEqualTo("Cell in column 2, row 2");
        assertThat(cell8.getStyle()).isNull();
        assertThat(cell8.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell8.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell8.getInnerDocument()).isNull();
        Cell cell9 = (Cell) row3.getCells()
                .get(2);
        assertThat(cell9.getId()).isNull();
        assertThat(cell9.getNodeName()).isEqualTo("cell");
        assertThat(cell9.getParent()).isSameAs(column3);
        assertThat(cell9.getContext()).isEqualTo("cell");
        assertThat(cell9.getDocument()).isSameAs(document1);
        assertThatThrownBy(() -> {
            cell9.isInline();
        }).hasMessageContaining("NotImplementedError");
        assertThatThrownBy(() -> {
            cell9.isBlock();
        }).hasMessageContaining("NotImplementedError");
        assertThat(cell9.getAttributes()).containsEntry("colnumber", 3L)
                .containsEntry("halign", "left")
                .containsEntry("valign", "top")
                .containsEntry("width", 1L);
        assertThat(cell9.getRoles()).isNullOrEmpty();
        assertThat(cell9.isReftext()).isFalse();
        assertThat(cell9.getReftext()).isNull();
        assertThat(cell9.getColumn()).isSameAs(column3);
        assertThat(cell9.getColspan()).isEqualTo(0);
        assertThat(cell9.getRowspan()).isEqualTo(0);
        assertThat(cell9.getText()).isEqualTo("Cell in column 3, row 2");
        assertThat(cell9.getSource()).isEqualTo("Cell in column 3, row 2");
        assertThat(cell9.getStyle()).isNull();
        assertThat(cell9.getHorizontalAlignment()).isEqualTo(Table.HorizontalAlignment.LEFT);
        assertThat(cell9.getVerticalAlignment()).isEqualTo(Table.VerticalAlignment.TOP);
        assertThat(cell9.getInnerDocument()).isNull();
        assertThat(table1.getFrame()).isEqualTo("all");
        assertThat(table1.getGrid()).isEqualTo("all");
        assertThat(document1.getStructuredDoctitle()).isNull();
        assertThat(document1.getDoctitle()).isNull();
        assertThat(document1.getOptions()).containsEntry("header_footer", false);
    }
    // end::assert-code[]

    @Override
    // tag::mock-code[]
    public Document createMock() {
        Document mockDocument1 = mock(Document.class);
        when(mockDocument1.getId()).thenReturn(null);
        when(mockDocument1.getNodeName()).thenReturn("document");
        when(mockDocument1.getParent()).thenReturn(null);
        when(mockDocument1.getContext()).thenReturn("document");
        when(mockDocument1.getDocument()).thenReturn(mockDocument1);
        when(mockDocument1.isInline()).thenReturn(false);
        when(mockDocument1.isBlock()).thenReturn(true);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("doctype", "article");
        map1.put("example-caption", "Example");
        map1.put("filetype", "html");
        map1.put("notitle", "");
        map1.put("prewrap", "");
        map1.put("table-caption", "Table");
        when(mockDocument1.getAttributes()).thenReturn(map1);
        when(mockDocument1.getRoles()).thenReturn(Collections.emptyList());
        when(mockDocument1.isReftext()).thenReturn(false);
        when(mockDocument1.getReftext()).thenReturn(null);
        when(mockDocument1.getTitle()).thenReturn(null);
        when(mockDocument1.getStyle()).thenReturn(null);
        when(mockDocument1.getLevel()).thenReturn(0);
        when(mockDocument1.getContentModel()).thenReturn("compound");
        when(mockDocument1.getSourceLocation()).thenReturn(null);
        when(mockDocument1.getSubstitutions()).thenReturn(Collections.emptyList());
        Table mockTable1 = mock(Table.class);
        when(mockTable1.getId()).thenReturn(null);
        when(mockTable1.getNodeName()).thenReturn("table");
        when(mockTable1.getParent()).thenReturn(mockDocument1);
        when(mockTable1.getContext()).thenReturn("table");
        when(mockTable1.getDocument()).thenReturn(mockDocument1);
        when(mockTable1.isInline()).thenReturn(false);
        when(mockTable1.isBlock()).thenReturn(true);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("colcount", 3L);
        map2.put("header-option", "");
        map2.put("options", "header");
        map2.put("rowcount", 3L);
        map2.put("style", "table");
        map2.put("tablepcwidth", 75L);
        map2.put("width", "75%");
        when(mockTable1.getAttributes()).thenReturn(map2);
        when(mockTable1.getRoles()).thenReturn(Collections.emptyList());
        when(mockTable1.isReftext()).thenReturn(false);
        when(mockTable1.getReftext()).thenReturn(null);
        when(mockTable1.getTitle()).thenReturn(null);
        when(mockTable1.getStyle()).thenReturn("table");
        when(mockTable1.getLevel()).thenReturn(0);
        when(mockTable1.getContentModel()).thenReturn("compound");
        when(mockTable1.getSourceLocation()).thenReturn(null);
        when(mockTable1.getSubstitutions()).thenReturn(Collections.emptyList());
        when(mockTable1.getBlocks()).thenReturn(Collections.emptyList());
        when(mockTable1.hasHeaderOption()).thenReturn(true);
        Column mockColumn1 = mock(Column.class);
        when(mockColumn1.getId()).thenReturn(null);
        when(mockColumn1.getNodeName()).thenReturn("column");
        when(mockColumn1.getParent()).thenReturn(mockTable1);
        when(mockColumn1.getContext()).thenReturn("column");
        when(mockColumn1.getDocument()).thenReturn(mockDocument1);
        when(mockColumn1.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockColumn1.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map3 = new HashMap<>();
        map3.put("colnumber", 1L);
        map3.put("colpcwidth", 33.3333);
        map3.put("halign", "left");
        map3.put("valign", "top");
        map3.put("width", 1L);
        when(mockColumn1.getAttributes()).thenReturn(map3);
        when(mockColumn1.getRoles()).thenReturn(Collections.emptyList());
        when(mockColumn1.isReftext()).thenReturn(false);
        when(mockColumn1.getReftext()).thenReturn(null);
        when(mockColumn1.getStyle()).thenReturn(null);
        when(mockColumn1.getTable()).thenReturn(mockTable1);
        when(mockColumn1.getColumnNumber()).thenReturn(1);
        when(mockColumn1.getWidth()).thenReturn(1);
        when(mockColumn1.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockColumn1.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        Column mockColumn2 = mock(Column.class);
        when(mockColumn2.getId()).thenReturn(null);
        when(mockColumn2.getNodeName()).thenReturn("column");
        when(mockColumn2.getParent()).thenReturn(mockTable1);
        when(mockColumn2.getContext()).thenReturn("column");
        when(mockColumn2.getDocument()).thenReturn(mockDocument1);
        when(mockColumn2.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockColumn2.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map4 = new HashMap<>();
        map4.put("colnumber", 2L);
        map4.put("colpcwidth", 33.3333);
        map4.put("halign", "left");
        map4.put("valign", "top");
        map4.put("width", 1L);
        when(mockColumn2.getAttributes()).thenReturn(map4);
        when(mockColumn2.getRoles()).thenReturn(Collections.emptyList());
        when(mockColumn2.isReftext()).thenReturn(false);
        when(mockColumn2.getReftext()).thenReturn(null);
        when(mockColumn2.getStyle()).thenReturn(null);
        when(mockColumn2.getTable()).thenReturn(mockTable1);
        when(mockColumn2.getColumnNumber()).thenReturn(2);
        when(mockColumn2.getWidth()).thenReturn(1);
        when(mockColumn2.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockColumn2.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        Column mockColumn3 = mock(Column.class);
        when(mockColumn3.getId()).thenReturn(null);
        when(mockColumn3.getNodeName()).thenReturn("column");
        when(mockColumn3.getParent()).thenReturn(mockTable1);
        when(mockColumn3.getContext()).thenReturn("column");
        when(mockColumn3.getDocument()).thenReturn(mockDocument1);
        when(mockColumn3.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockColumn3.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map5 = new HashMap<>();
        map5.put("colnumber", 3L);
        map5.put("colpcwidth", 33.3334);
        map5.put("halign", "left");
        map5.put("valign", "top");
        map5.put("width", 1L);
        when(mockColumn3.getAttributes()).thenReturn(map5);
        when(mockColumn3.getRoles()).thenReturn(Collections.emptyList());
        when(mockColumn3.isReftext()).thenReturn(false);
        when(mockColumn3.getReftext()).thenReturn(null);
        when(mockColumn3.getStyle()).thenReturn(null);
        when(mockColumn3.getTable()).thenReturn(mockTable1);
        when(mockColumn3.getColumnNumber()).thenReturn(3);
        when(mockColumn3.getWidth()).thenReturn(1);
        when(mockColumn3.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockColumn3.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockTable1.getColumns()).thenReturn(Arrays.asList(mockColumn1, mockColumn2, mockColumn3));
        Row mockRow1 = mock(Row.class);
        Cell mockCell1 = mock(Cell.class);
        when(mockCell1.getId()).thenReturn(null);
        when(mockCell1.getNodeName()).thenReturn("cell");
        when(mockCell1.getParent()).thenReturn(mockColumn1);
        when(mockCell1.getContext()).thenReturn("cell");
        when(mockCell1.getDocument()).thenReturn(mockDocument1);
        when(mockCell1.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell1.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map6 = new HashMap<>();
        map6.put("colnumber", 1L);
        map6.put("halign", "left");
        map6.put("valign", "top");
        map6.put("width", 1L);
        when(mockCell1.getAttributes()).thenReturn(map6);
        when(mockCell1.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell1.isReftext()).thenReturn(false);
        when(mockCell1.getReftext()).thenReturn(null);
        when(mockCell1.getColumn()).thenReturn(mockColumn1);
        when(mockCell1.getColspan()).thenReturn(0);
        when(mockCell1.getRowspan()).thenReturn(0);
        when(mockCell1.getText()).thenReturn("Name of Column 1");
        when(mockCell1.getSource()).thenReturn("Name of Column 1");
        when(mockCell1.getStyle()).thenReturn(null);
        when(mockCell1.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell1.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell1.getInnerDocument()).thenReturn(null);
        Cell mockCell2 = mock(Cell.class);
        when(mockCell2.getId()).thenReturn(null);
        when(mockCell2.getNodeName()).thenReturn("cell");
        when(mockCell2.getParent()).thenReturn(mockColumn2);
        when(mockCell2.getContext()).thenReturn("cell");
        when(mockCell2.getDocument()).thenReturn(mockDocument1);
        when(mockCell2.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell2.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map7 = new HashMap<>();
        map7.put("colnumber", 2L);
        map7.put("halign", "left");
        map7.put("valign", "top");
        map7.put("width", 1L);
        when(mockCell2.getAttributes()).thenReturn(map7);
        when(mockCell2.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell2.isReftext()).thenReturn(false);
        when(mockCell2.getReftext()).thenReturn(null);
        when(mockCell2.getColumn()).thenReturn(mockColumn2);
        when(mockCell2.getColspan()).thenReturn(0);
        when(mockCell2.getRowspan()).thenReturn(0);
        when(mockCell2.getText()).thenReturn("Name of Column 2");
        when(mockCell2.getSource()).thenReturn("Name of Column 2");
        when(mockCell2.getStyle()).thenReturn(null);
        when(mockCell2.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell2.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell2.getInnerDocument()).thenReturn(null);
        Cell mockCell3 = mock(Cell.class);
        when(mockCell3.getId()).thenReturn(null);
        when(mockCell3.getNodeName()).thenReturn("cell");
        when(mockCell3.getParent()).thenReturn(mockColumn3);
        when(mockCell3.getContext()).thenReturn("cell");
        when(mockCell3.getDocument()).thenReturn(mockDocument1);
        when(mockCell3.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell3.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map8 = new HashMap<>();
        map8.put("colnumber", 3L);
        map8.put("halign", "left");
        map8.put("valign", "top");
        map8.put("width", 1L);
        when(mockCell3.getAttributes()).thenReturn(map8);
        when(mockCell3.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell3.isReftext()).thenReturn(false);
        when(mockCell3.getReftext()).thenReturn(null);
        when(mockCell3.getColumn()).thenReturn(mockColumn3);
        when(mockCell3.getColspan()).thenReturn(0);
        when(mockCell3.getRowspan()).thenReturn(0);
        when(mockCell3.getText()).thenReturn("Name of Column 3");
        when(mockCell3.getSource()).thenReturn("Name of Column 3");
        when(mockCell3.getStyle()).thenReturn(null);
        when(mockCell3.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell3.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell3.getInnerDocument()).thenReturn(null);
        when(mockRow1.getCells()).thenReturn(Arrays.asList(mockCell1, mockCell2, mockCell3));
        when(mockTable1.getHeader()).thenReturn(Collections.singletonList(mockRow1));
        when(mockTable1.getFooter()).thenReturn(Collections.emptyList());
        Row mockRow2 = mock(Row.class);
        Cell mockCell4 = mock(Cell.class);
        when(mockCell4.getId()).thenReturn(null);
        when(mockCell4.getNodeName()).thenReturn("cell");
        when(mockCell4.getParent()).thenReturn(mockColumn1);
        when(mockCell4.getContext()).thenReturn("cell");
        when(mockCell4.getDocument()).thenReturn(mockDocument1);
        when(mockCell4.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell4.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map9 = new HashMap<>();
        map9.put("colnumber", 1L);
        map9.put("halign", "left");
        map9.put("valign", "top");
        map9.put("width", 1L);
        when(mockCell4.getAttributes()).thenReturn(map9);
        when(mockCell4.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell4.isReftext()).thenReturn(false);
        when(mockCell4.getReftext()).thenReturn(null);
        when(mockCell4.getColumn()).thenReturn(mockColumn1);
        when(mockCell4.getColspan()).thenReturn(0);
        when(mockCell4.getRowspan()).thenReturn(0);
        when(mockCell4.getText()).thenReturn("Cell in column 1, row 1");
        when(mockCell4.getSource()).thenReturn("Cell in column 1, row 1");
        when(mockCell4.getStyle()).thenReturn(null);
        when(mockCell4.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell4.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell4.getInnerDocument()).thenReturn(null);
        Cell mockCell5 = mock(Cell.class);
        when(mockCell5.getId()).thenReturn(null);
        when(mockCell5.getNodeName()).thenReturn("cell");
        when(mockCell5.getParent()).thenReturn(mockColumn2);
        when(mockCell5.getContext()).thenReturn("cell");
        when(mockCell5.getDocument()).thenReturn(mockDocument1);
        when(mockCell5.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell5.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map10 = new HashMap<>();
        map10.put("colnumber", 2L);
        map10.put("halign", "left");
        map10.put("valign", "top");
        map10.put("width", 1L);
        when(mockCell5.getAttributes()).thenReturn(map10);
        when(mockCell5.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell5.isReftext()).thenReturn(false);
        when(mockCell5.getReftext()).thenReturn(null);
        when(mockCell5.getColumn()).thenReturn(mockColumn2);
        when(mockCell5.getColspan()).thenReturn(0);
        when(mockCell5.getRowspan()).thenReturn(0);
        when(mockCell5.getText()).thenReturn("Cell in column 2, row 1");
        when(mockCell5.getSource()).thenReturn("Cell in column 2, row 1");
        when(mockCell5.getStyle()).thenReturn(null);
        when(mockCell5.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell5.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell5.getInnerDocument()).thenReturn(null);
        Cell mockCell6 = mock(Cell.class);
        when(mockCell6.getId()).thenReturn(null);
        when(mockCell6.getNodeName()).thenReturn("cell");
        when(mockCell6.getParent()).thenReturn(mockColumn3);
        when(mockCell6.getContext()).thenReturn("cell");
        when(mockCell6.getDocument()).thenReturn(mockDocument1);
        when(mockCell6.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell6.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map11 = new HashMap<>();
        map11.put("colnumber", 3L);
        map11.put("halign", "left");
        map11.put("valign", "top");
        map11.put("width", 1L);
        when(mockCell6.getAttributes()).thenReturn(map11);
        when(mockCell6.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell6.isReftext()).thenReturn(false);
        when(mockCell6.getReftext()).thenReturn(null);
        when(mockCell6.getColumn()).thenReturn(mockColumn3);
        when(mockCell6.getColspan()).thenReturn(0);
        when(mockCell6.getRowspan()).thenReturn(0);
        when(mockCell6.getText()).thenReturn("Cell in column 3, row 1");
        when(mockCell6.getSource()).thenReturn("Cell in column 3, row 1");
        when(mockCell6.getStyle()).thenReturn(null);
        when(mockCell6.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell6.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell6.getInnerDocument()).thenReturn(null);
        when(mockRow2.getCells()).thenReturn(Arrays.asList(mockCell4, mockCell5, mockCell6));
        Row mockRow3 = mock(Row.class);
        Cell mockCell7 = mock(Cell.class);
        when(mockCell7.getId()).thenReturn(null);
        when(mockCell7.getNodeName()).thenReturn("cell");
        when(mockCell7.getParent()).thenReturn(mockColumn1);
        when(mockCell7.getContext()).thenReturn("cell");
        when(mockCell7.getDocument()).thenReturn(mockDocument1);
        when(mockCell7.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell7.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map12 = new HashMap<>();
        map12.put("colnumber", 1L);
        map12.put("halign", "left");
        map12.put("valign", "top");
        map12.put("width", 1L);
        when(mockCell7.getAttributes()).thenReturn(map12);
        when(mockCell7.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell7.isReftext()).thenReturn(false);
        when(mockCell7.getReftext()).thenReturn(null);
        when(mockCell7.getColumn()).thenReturn(mockColumn1);
        when(mockCell7.getColspan()).thenReturn(0);
        when(mockCell7.getRowspan()).thenReturn(0);
        when(mockCell7.getText()).thenReturn("Cell in column 1, row 2");
        when(mockCell7.getSource()).thenReturn("Cell in column 1, row 2");
        when(mockCell7.getStyle()).thenReturn(null);
        when(mockCell7.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell7.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell7.getInnerDocument()).thenReturn(null);
        Cell mockCell8 = mock(Cell.class);
        when(mockCell8.getId()).thenReturn(null);
        when(mockCell8.getNodeName()).thenReturn("cell");
        when(mockCell8.getParent()).thenReturn(mockColumn2);
        when(mockCell8.getContext()).thenReturn("cell");
        when(mockCell8.getDocument()).thenReturn(mockDocument1);
        when(mockCell8.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell8.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map13 = new HashMap<>();
        map13.put("colnumber", 2L);
        map13.put("halign", "left");
        map13.put("valign", "top");
        map13.put("width", 1L);
        when(mockCell8.getAttributes()).thenReturn(map13);
        when(mockCell8.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell8.isReftext()).thenReturn(false);
        when(mockCell8.getReftext()).thenReturn(null);
        when(mockCell8.getColumn()).thenReturn(mockColumn2);
        when(mockCell8.getColspan()).thenReturn(0);
        when(mockCell8.getRowspan()).thenReturn(0);
        when(mockCell8.getText()).thenReturn("Cell in column 2, row 2");
        when(mockCell8.getSource()).thenReturn("Cell in column 2, row 2");
        when(mockCell8.getStyle()).thenReturn(null);
        when(mockCell8.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell8.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell8.getInnerDocument()).thenReturn(null);
        Cell mockCell9 = mock(Cell.class);
        when(mockCell9.getId()).thenReturn(null);
        when(mockCell9.getNodeName()).thenReturn("cell");
        when(mockCell9.getParent()).thenReturn(mockColumn3);
        when(mockCell9.getContext()).thenReturn("cell");
        when(mockCell9.getDocument()).thenReturn(mockDocument1);
        when(mockCell9.isInline()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        when(mockCell9.isBlock()).thenThrow(new UnsupportedOperationException("NotImplementedError"));
        Map<String, Object> map14 = new HashMap<>();
        map14.put("colnumber", 3L);
        map14.put("halign", "left");
        map14.put("valign", "top");
        map14.put("width", 1L);
        when(mockCell9.getAttributes()).thenReturn(map14);
        when(mockCell9.getRoles()).thenReturn(Collections.emptyList());
        when(mockCell9.isReftext()).thenReturn(false);
        when(mockCell9.getReftext()).thenReturn(null);
        when(mockCell9.getColumn()).thenReturn(mockColumn3);
        when(mockCell9.getColspan()).thenReturn(0);
        when(mockCell9.getRowspan()).thenReturn(0);
        when(mockCell9.getText()).thenReturn("Cell in column 3, row 2");
        when(mockCell9.getSource()).thenReturn("Cell in column 3, row 2");
        when(mockCell9.getStyle()).thenReturn(null);
        when(mockCell9.getHorizontalAlignment()).thenReturn(Table.HorizontalAlignment.LEFT);
        when(mockCell9.getVerticalAlignment()).thenReturn(Table.VerticalAlignment.TOP);
        when(mockCell9.getInnerDocument()).thenReturn(null);
        when(mockRow3.getCells()).thenReturn(Arrays.asList(mockCell7, mockCell8, mockCell9));
        when(mockTable1.getBody()).thenReturn(Arrays.asList(mockRow2, mockRow3));
        when(mockTable1.getFrame()).thenReturn("all");
        when(mockTable1.getGrid()).thenReturn("all");
        when(mockDocument1.getBlocks()).thenReturn(Collections.singletonList(mockTable1));
        when(mockDocument1.getStructuredDoctitle()).thenReturn(null);
        when(mockDocument1.getDoctitle()).thenReturn(null);
        Map<Object, Object> map15 = new HashMap<>();
        map15.put("attributes", "{}");
        map15.put("header_footer", false);
        when(mockDocument1.getOptions()).thenReturn(map15);
        return mockDocument1;
    }
    // end::mock-code[]
}