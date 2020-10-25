package dates.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dates.Dates;
import dates.Dates.Day;

/**
 * 
 * Consider the Define/Use Paths (du-paths) for variable "position",
 * 
 * variable: position
 * define: line 102, 104, 108
 * use: line 102, 103, 104, 107, 108, 111
 * 
 * du-paths
 * -----------------------------------------------------------------------------------------
 * lines
 * <102, 103, 107, 111>		(Not tested)
 * <102, 103, 104>   		(Tested in BranchTests.testDayAfterDoomsdayInLeapYear)
 * <102, 103, 107, 108>		(Tested in BranchTests.testDayBeforeDoomsdayInNonLeapYear)
 * <104, 111>				(Tested in BranchTests.testDayAfterDoomsdayInLeapYear)
 * <108, 107, 111>			(Tested in BranchTests.testDayBeforeDoomsdayInNonLeapYear)
 * 
 * -----------------------------------------------------------------------------------------
 * 
 * From the list above, the first du-path is not examined by any test. The path is trigger when
 * Position is equal 0. This happen in the cases where the input day aligned with the dooms day
 * of the month and the dooms day of the year is Sunday for example.
 * 
 * By covering all du path of a variable, the chance of finding fault is increased where 
 * previously the path is not examined. Although testing all du-path of all variables may
 * not be feasible, testing all du path of crucial variable greatly increase the chance of 
 * finding fault in the function. 
 * 
 * One of the advantages of data flow testing is that user are likely have the ability to 
 * pinpoint the origin of the faults (likely occurs within the path). By including the test 
 * below, it increase the over quality of the test suit due to increase data flow coverage.
 * 
 * @author Neville
 *
 */

public class DataflowTest {
	/**
	 * Test for du path of line 102, 103, 107, 111. Where the input date
	 * is a Doomsday itself. 
	 */
    @Test
    public void testDateIsDoomsday() {
    	assertEquals(Day.Sunday ,Dates.dayOfWeek(1999, 6, 6));
    }
}
