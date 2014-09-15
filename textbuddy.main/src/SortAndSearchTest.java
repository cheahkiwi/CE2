import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Kiwi
 *
 */
public class SortAndSearchTest {

    private final String EMPTY_STRING = "";
    
    // Test Case 1
    private ArrayList<ContentLine> testCase1=new ArrayList<ContentLine>();
    private final String TEST_CASE_1_LINE_1 = "";
    private final String TEST_CASE_1_LINE_2 = "";
    private final String TEST_CASE_1_SEARCH_KEYWORD = "";
    private final String TEST_CASE_1_SORT_EXPECTED = "";
    private final String TEST_CASE_1_SEARCH_EXPECTED = "";
    
    // Test Case 2
    private ArrayList<ContentLine> testCase2=new ArrayList<ContentLine>();
    private final String TEST_CASE_2_LINE_1 = "Hello World";
    private final String TEST_CASE_2_LINE_2 = "Goodbye World";
    private final String TEST_CASE_2_SEARCH_KEYWORD = "Hello";
    private final String TEST_CASE_2_SORT_EXPECTED = "Goodbye World/nHelloWorld";
    private final String TEST_CASE_2_SEARCH_EXPECTED = "Hello World";
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testCase1.add(new ContentLine(TEST_CASE_1_LINE_1));
        testCase1.add(new ContentLine(TEST_CASE_1_LINE_2));
    }

    /**
     * Test method for {@link TextBuddy#executeTestCommand(java.util.ArrayList, TextBuddy.COMMAND_TYPE, java.lang.String)}.
     */
    @Test
    public void testExecuteTestCommand() {
        assertEquals("",TextBuddy.executeTestCommand(testCase1, TextBuddy.COMMAND_TYPE.SORT, EMPTY_STRING));
    }

}
