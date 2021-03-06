package fr.jmini.asciidoctorj.converter.html;

import java.util.Map;

import org.asciidoctor.ast.Document;

import fr.jmini.asciidoctorj.converter.html.testing.AbstractTableColumnFormattingHalignTesting;

/**
 * Test for {@link fr.jmini.asciidoctorj.testcases.TableColumnFormattingHalignTestCase} (mocked AST, java html backend) .
 */
public class TableColumnFormattingHalignTest extends AbstractTableColumnFormattingHalignTesting {

    @Override
    protected Document createAstDocument(String asciiDoc, Map<String, Object> options) {
        Document mock = testCase.createMock();
        return mock;
    }

    @Override
    protected String convertToHtml(Document astDocument) {
        return HtmlConverterTestUtility.convertToHtml(astDocument);
    }
}
