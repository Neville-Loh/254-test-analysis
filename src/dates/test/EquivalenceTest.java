package dates.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dates.Dates;
import dates.Dates.Day;

/**
 * Input Space partitioning for dates.Dates.dayOfWeek
 * Consider the Standard input partition of date with requirement that year cannot be < 1753.
 * 
 * ---------------------------------------------------------------------------------------------
 * The equivalence classes for the Day
 * 	{ Day < 1}					(Tested in BranchTests.testDayZero)
 * 	{ 1 <= Day <= 28 } 			(Tested in BranchTests.testDayBeforeDoomsdayInNonLeapYear)
 * 	{ Day = 29 } 				(Tested in BranchTests.testLeapDayInFebOfLeapYear)
 * 	{ Day = 30 } 				(Tested in BranchTests.testDayAfterDoomsdayInLeapYear)
 * 	{ Day = 31 } 				(Not Tested)
 * 	{ Day > 31 }				(Tested in BranchTests.testExtraDay)
 * 
 * The equivalence classes for the Month
 * 	{ Month < 1 } 				(Tested in BranchTests.testMonthZero)
 * 	{ Month with 30 days } 		(Tested in BranchTests.testDayAfterDoomsdayInLeapYear)
 * 	{ Month has 31 days } 		(Not Tested)
 * 	{ Month = February } 		(Tested in BranchTests.testLeapDayInFebOfLeapYear)
 * 	{ Month > 12 } 				(Tested in BranchTests.testExtraMonth)
 * 
 * The equivalence class for Year
 * 	{ Year < 1753 } 			(Tested in BranchTests.testYearBeforeParameters)
 * 	{ Year is not leap year } 	(Tested in BranchTests.testDayBeforeDoomsdayInNonLeapYear)
 * 	{ Year is leap year } 		(Tested in BranchTests.testLeapDayInFebOfLeapYear)
 * 
 * ---------------------------------------------------------------------------------------------
 * 
 * It is shown that equivalence class of day = 31 and month with 31 days is not tested.
 * Although testing all combination of input partition may not be feasible. The partition of
 * months with 31 days is not represented in any tests. The function may yield error when the 
 * value of the partition is inputed. By representing all input partition, it reduce the 
 * chance of not finding existing fault related to the partition.
 * 
 * By using equivalence class testing, the number of test cases can be reduce without 
 * compromising the test coverage. The bellow test is included to represent the missing 
 * partition of the origin test suit, which increase the overall quality of the test.
 * 
 * @author Neville
 *
 */
public class EquivalenceTest {
	/**
	 * Test that represents the input partition of months with 31 days.
	 */
    @Test
    public void testMonthWith31Days() {
    	assertEquals(Day.Thursday ,Dates.dayOfWeek(2020, 12, 31));
    }
}
