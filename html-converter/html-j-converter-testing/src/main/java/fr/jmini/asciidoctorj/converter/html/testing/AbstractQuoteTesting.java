package fr.jmini.asciidoctorj.converter.html.testing;

import static org.assertj.core.api.Assertions.assertThat;

import org.asciidoctor.ast.Block;
import org.asciidoctor.ast.Document;
import org.junit.Test;

public abstract class AbstractQuoteTesting {

    @Test
    public void test() throws Exception {
        String asciiDoc = createAsciiDocInput();
        Document astDocument = createAstDocument(asciiDoc);
        checkAst(astDocument);
        String html = convertToHtml(astDocument);
        assertThat(html).isXmlEqualTo(EXPECTED_HTML);
    }

    public static final String ASCIIDOC = "" +
            "[quote]\n" +
            "____\n" +
            "Quoted text.\n" +
            "\n" +
            "Another paragraph in quote.\n" +
            "____";

    // tag::expected-html[]
    public static final String EXPECTED_HTML = "<div class=\"quoteblock\">\n" +
            "<blockquote>\n" +
            "<div class=\"paragraph\">\n" +
            "<p>Quoted text.</p>\n" +
            "</div>\n" +
            "<div class=\"paragraph\">\n" +
            "<p>Another paragraph in quote.</p>\n" +
            "</div>\n" +
            "</blockquote>\n" +
            "</div>";
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
        Block block1 = (Block) document1.getBlocks()
                .get(0);
        assertThat(block1.getId()).isNull();
        assertThat(block1.getNodeName()).isEqualTo("quote");
        assertThat(block1.getParent()).isSameAs(document1);
        assertThat(block1.getContext()).isEqualTo("quote");
        assertThat(block1.getDocument()).isSameAs(document1);
        assertThat(block1.isInline()).isFalse();
        assertThat(block1.isBlock()).isTrue();
        assertThat(block1.getAttributes()).containsEntry("style", "quote");
        assertThat(block1.getRoles()).isNullOrEmpty();
        assertThat(block1.isReftext()).isFalse();
        assertThat(block1.getReftext()).isNull();
        assertThat(block1.getTitle()).isNull();
        assertThat(block1.getStyle()).isEqualTo("quote");
        assertThat(block1.getLevel()).isEqualTo(0);
        assertThat(block1.getContentModel()).isEqualTo("compound");
        assertThat(block1.getSourceLocation()).isNull();
        assertThat(block1.getSubstitutions()).isNullOrEmpty();
        assertThat(block1.getBlocks()).hasSize(2);
        Block block2 = (Block) block1.getBlocks()
                .get(0);
        assertThat(block2.getId()).isNull();
        assertThat(block2.getNodeName()).isEqualTo("paragraph");
        assertThat(block2.getParent()).isSameAs(block1);
        assertThat(block2.getContext()).isEqualTo("paragraph");
        assertThat(block2.getDocument()).isSameAs(document1);
        assertThat(block2.isInline()).isFalse();
        assertThat(block2.isBlock()).isTrue();
        assertThat(block2.getAttributes()).isNullOrEmpty();
        assertThat(block2.getRoles()).isNullOrEmpty();
        assertThat(block2.isReftext()).isFalse();
        assertThat(block2.getReftext()).isNull();
        assertThat(block2.getTitle()).isNull();
        assertThat(block2.getStyle()).isNull();
        assertThat(block2.getLevel()).isEqualTo(0);
        assertThat(block2.getContentModel()).isEqualTo("simple");
        assertThat(block2.getSourceLocation()).isNull();
        assertThat(block2.getSubstitutions()).containsExactly("specialcharacters", "quotes", "attributes", "replacements", "macros", "post_replacements");
        assertThat(block2.getBlocks()).isNullOrEmpty();
        assertThat(block2.getLines()).containsExactly("Quoted text.");
        assertThat(block2.getSource()).isEqualTo("Quoted text.");
        Block block3 = (Block) block1.getBlocks()
                .get(1);
        assertThat(block3.getId()).isNull();
        assertThat(block3.getNodeName()).isEqualTo("paragraph");
        assertThat(block3.getParent()).isSameAs(block1);
        assertThat(block3.getContext()).isEqualTo("paragraph");
        assertThat(block3.getDocument()).isSameAs(document1);
        assertThat(block3.isInline()).isFalse();
        assertThat(block3.isBlock()).isTrue();
        assertThat(block3.getAttributes()).isNullOrEmpty();
        assertThat(block3.getRoles()).isNullOrEmpty();
        assertThat(block3.isReftext()).isFalse();
        assertThat(block3.getReftext()).isNull();
        assertThat(block3.getTitle()).isNull();
        assertThat(block3.getStyle()).isNull();
        assertThat(block3.getLevel()).isEqualTo(0);
        assertThat(block3.getContentModel()).isEqualTo("simple");
        assertThat(block3.getSourceLocation()).isNull();
        assertThat(block3.getSubstitutions()).containsExactly("specialcharacters", "quotes", "attributes", "replacements", "macros", "post_replacements");
        assertThat(block3.getBlocks()).isNullOrEmpty();
        assertThat(block3.getLines()).containsExactly("Another paragraph in quote.");
        assertThat(block3.getSource()).isEqualTo("Another paragraph in quote.");
        assertThat(block1.getLines()).isNullOrEmpty();
        assertThat(block1.getSource()).isEqualTo("");
        assertThat(document1.getStructuredDoctitle()).isNull();
        assertThat(document1.getDoctitle()).isNull();
        assertThat(document1.getOptions()).containsEntry("header_footer", false);
    }
    // end::assert-code[]

}
