package dates.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import dates.Dates;
import dates.Dates.Day;

/**
 * The following class aim to test the class method dats.Dates.dayOfWeek().
 * 
 * 
 * Justification of not 100% coverage (line 92):
 * To get to line 92, the method must not throw an IllegalArugmentException at line 72.
 * This implies the month must be from 1 to 12 inclusive. Since array in doomsdaysByMonth
 * includes all month. All value that enter line 92 must match to 1 month which enter the 
 * if statement at line 93 and break the loop. This means the for loop will never exit
 * naturally by exhausting all the item in the collection.
 * 
 * This implies predicate of the for loop will never be evaluate the false, because 
 * 1. Month is never < 1
 * 2. if month is 12, it exit the loop before line 92 checks it again
 * 
 * 
 * 
 * @author Neville
 */
public class BranchTests {
	
    // --------------------------- Test with Invalid input  ------------------------------
	
	/**
	 * Test year before the requirement 1753, coverage for line 60
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testYearBeforeParameters() {
    	int year = 1752; 
    	int month = 4;
    	int day = 1;
        try {
            Dates.dayOfWeek(year,month,day);
            fail();
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }
    }
    
	/**
	 * Test month = 0, condition coverage for line 61,62
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testMonthZero() {
    	int year = 1801; 
    	int month = 0;
    	int day = 4;
        try {
            Dates.dayOfWeek(year,month,day);
            fail();
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }
    }
    
	/**
	 * Test day = 0, condition coverage for line 61, 62
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testDayZero() {
    	int year = 1801; 
    	int month = 4;
    	int day = 0;
        try {
            Dates.dayOfWeek(year,month,day);
            fail();
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }
    }
    
	/**
	 * Test month > 12 ,coverage for line 63
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testExtraMonth() {
    	int year = 1801; 
    	int month = 13;
    	int day = 15;
        try {
            Dates.dayOfWeek(year,month,day);
            fail();
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }
    }
    
	/**
	 * Test invalid day, coverage for line 70,71
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testExtraDay() {
    	int year = 2000; 
    	int month = 4;
    	int day = 59;
        try {
            Dates.dayOfWeek(year,month,day);
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }

    }
    
	/**
	 * Test date > 29 in leap year , coverage for line 66,67
	 * expect IllegalArugmentException to be thrown
	 */
    @Test
    public void testExtraDayInFebOfLeapYear() {
    	int year = 2000; 
    	int month = 2;
    	int day = 30;
        try {
            Dates.dayOfWeek(year,month,day);
            fail();
        } catch (IllegalArgumentException e) {
        	assertEquals("Invalid date: year=" + year + ", month=" + month + ", day=" + day, e.getMessage());
        }
    }
    
    // --------------------------- Test with valid input  ------------------------------
    
	/**
	 * Test 29th of February in a leap year to cover the true branch of line 96
	 * and see if day is correctly shifted back by 1.
	 */
    @Test
    public void testLeapDayInFebOfLeapYear() {
    	assertEquals(Day.Tuesday ,Dates.dayOfWeek(2000, 2, 29));
    }
    
    /**
     * Test a day that is after the month doomsday such that when combined 
     * with the ordinal value of the doomsday give a positive number, cover 
     * the true branch of line 103,104.
     */
    @Test
    public void testDayAfterDoomsdayInLeapYear() {
    	assertEquals(Day.Sunday ,Dates.dayOfWeek(2008, 11, 30));
    }
    
    /**
     * Test a day that is before the month's doomsday such that when combined
     * with the ordinal value of the doomsday gives a negative number, cover
     * the true branch of line 107,108.
     */
    @Test
    public void testDayBeforeDoomsdayInNonLeapYear() {
    	assertEquals(Day.Monday ,Dates.dayOfWeek(2100, 2, 1));
    }
    
    

}
