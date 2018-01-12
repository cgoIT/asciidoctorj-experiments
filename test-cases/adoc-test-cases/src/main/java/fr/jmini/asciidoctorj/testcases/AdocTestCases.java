package fr.jmini.asciidoctorj.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdocTestCases {

    // tag::all-cases[]
    public static List<AdocTestCase> getAllTestCases() {
        List<AdocTestCase> list = new ArrayList<>();
        list.add(new DivMultilineTestCase());
        list.add(new DivSimpleTestCase());
        list.add(new DivWithIdAndRoleTestCase());
        list.add(new ExampleCustomCaptionTestCase());
        list.add(new ExampleCustomCounterTestCase());
        list.add(new ExampleNestedTestCase());
        list.add(new ExampleTestCase());
        list.add(new HorizontalRuleTestCase());
        list.add(new ListingCustomCaptionTestCase());
        list.add(new ListingCustomCounterTestCase());
        list.add(new ListingMultilineTestCase());
        list.add(new ListingParagraphSyntaxTestCase());
        list.add(new ListingTestCase());
        list.add(new ListingUnsetPrewrapTestCase());
        list.add(new ListingWithoutBlockDelimiterTestCase());
        list.add(new ListLabeledNestedMixedTestCase());
        list.add(new ListLabeledNestedTestCase());
        list.add(new ListLabeledTestCase());
        list.add(new ListLabeledWithIdAndRoleTestCase());
        list.add(new ListNestedTestCase());
        list.add(new ListOlDecimalTestCase());
        list.add(new ListOlLoweralphaTestCase());
        list.add(new ListOlLowergreekTestCase());
        list.add(new ListOlLowerromanTestCase());
        list.add(new ListOlReversedTestCase());
        list.add(new ListOlTestCase());
        list.add(new ListOlUpperalphaTestCase());
        list.add(new ListOlUpperromanTestCase());
        list.add(new ListUlTestCase());
        list.add(new MultiDivTestCase());
        list.add(new QuoteTestCase());
        list.add(new QuoteWithIdAndRoleTestCase());
        list.add(new QuoteWithoutBlockDelimiterTestCase());
        list.add(new SectionAllTestCase());
        list.add(new SectionTestCase());
        list.add(new TableAutowidthSpreadTestCase());
        list.add(new TableAutowidthTestCase());
        list.add(new TableBorderFrameNoneTestCase());
        list.add(new TableBorderFrameSidesTestCase());
        list.add(new TableBorderFrameTopbotTestCase());
        list.add(new TableBorderGridColsTestCase());
        list.add(new TableBorderGridNoneTestCase());
        list.add(new TableBorderGridRowsTestCase());
        list.add(new TableCaptionCustomCounterTestCase());
        list.add(new TableCaptionCustomTestCase());
        list.add(new TableCaptionUnsetTestCase());
        list.add(new TableCellAlignedTestCase());
        list.add(new TableCellColspanRowspanTestCase());
        list.add(new TableCellColspanTestCase());
        list.add(new TableCellDuplicatedTestCase());
        list.add(new TableCellRowspanTestCase());
        list.add(new TableColsAttributeTestCase());
        list.add(new TableColumnFormattingHalignTestCase());
        list.add(new TableColumnFormattingValignTestCase());
        list.add(new TableColumnStyleTestCase());
        list.add(new TableColumnWidthTestCase());
        list.add(new TableFooterRowTestCase());
        list.add(new TableHeaderRowImplicitTestCase());
        list.add(new TableHeaderRowNoheaderTestCase());
        list.add(new TableHeaderRowOnlyTestCase());
        list.add(new TableHeaderRowTestCase());
        list.add(new TableNestedTestCase());
        list.add(new TableTestCase());
        list.add(new TableWhithIdAndRoleTestCase());
        list.add(new TableWidthTestCase());
        return Collections.unmodifiableList(list);
    }
    // end::all-cases[]

}
