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
    
    // Sort Test Case 1
    private ArrayList<ContentLine> testCase1=new ArrayList<ContentLine>();
    private final String TEST_CASE_1_LINE_1 = "";
    private final String TEST_CASE_1_LINE_2 = "";
    private final String TEST_CASE_1_SORT_EXPECTED = "/n/n";
    
    // Sort Test Case 2
    private ArrayList<ContentLine> testCase2=new ArrayList<ContentLine>();
    private final String TEST_CASE_2_LINE_1 = "A";
    private final String TEST_CASE_2_LINE_2 = "B";
    private final String TEST_CASE_2_SORT_EXPECTED = "A/nB/n";
    
    // Sort Test Case 3
    private ArrayList<ContentLine> testCase3=new ArrayList<ContentLine>();
    private final String TEST_CASE_3_LINE_1 = "B";
    private final String TEST_CASE_3_LINE_2 = "A";
    private final String TEST_CASE_3_SORT_EXPECTED = "A/nB/n";
    
    // Sort Test Case 4
    private ArrayList<ContentLine> testCase4=new ArrayList<ContentLine>();
    private final String TEST_CASE_4_LINE_1 = "Hello World";
    private final String TEST_CASE_4_LINE_2 = "Bye Bye World";
    private final String TEST_CASE_4_LINE_3 = "An Apple a day keeps the Doctor away";
    private final String TEST_CASE_4_LINE_4 = "";
    private final String TEST_CASE_4_SORT_EXPECTED = "/nAn Apple a day keeps the Doctor away/nBye Bye World/nHello World/n";
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testCase1.add(new ContentLine(TEST_CASE_1_LINE_1));
        testCase1.add(new ContentLine(TEST_CASE_1_LINE_2));
        
        testCase2.add(new ContentLine(TEST_CASE_2_LINE_1));
        testCase2.add(new ContentLine(TEST_CASE_2_LINE_2));
        
        testCase3.add(new ContentLine(TEST_CASE_3_LINE_1));
        testCase3.add(new ContentLine(TEST_CASE_3_LINE_2));
        
        testCase4.add(new ContentLine(TEST_CASE_4_LINE_1));
        testCase4.add(new ContentLine(TEST_CASE_4_LINE_2));
        testCase4.add(new ContentLine(TEST_CASE_4_LINE_3));
        testCase4.add(new ContentLine(TEST_CASE_4_LINE_4));
    }

    /**
     * Test method for {@link TextBuddy#executeTestCommand(java.util.ArrayList, TextBuddy.COMMAND_TYPE, java.lang.String)}.
     */
    @Test
    public void testSortCommand() {
        assertEquals(TEST_CASE_1_SORT_EXPECTED,TextBuddy.executeTestCommand(testCase1, TextBuddy.COMMAND_TYPE.SORT, EMPTY_STRING));
        
        assertEquals(TEST_CASE_2_SORT_EXPECTED,TextBuddy.executeTestCommand(testCase2, TextBuddy.COMMAND_TYPE.SORT, EMPTY_STRING));
        
        assertEquals(TEST_CASE_3_SORT_EXPECTED,TextBuddy.executeTestCommand(testCase3, TextBuddy.COMMAND_TYPE.SORT, EMPTY_STRING));
        
        assertEquals(TEST_CASE_4_SORT_EXPECTED,TextBuddy.executeTestCommand(testCase4, TextBuddy.COMMAND_TYPE.SORT, EMPTY_STRING));
    }

}
