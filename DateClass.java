import java.util.*;
// Dating project class
/**
@author Steven Nirenberg
*/
public class DateClass implements Interface
{
	// Data members
	int day;
	int dow;
	int month;
	int year;
	String [] DOW  = {"Sunday","Monday","Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	String [] monthName ={"January","February","March","April","May","June","July","August","September","October","November","December"};
	 /** @return the day of the month (1-31) */
    public int getDay() 
	{
	    return day;
	}
  
	/** @return the day of the week (0-6) */
	public int dow()
	{
		return dow;
	}

	/** @return the month of the year (1-12) */
	public int getMonth()
	{
		return month;
	}
	/** @return the year (four digits) */
	public int getYear()
	{
		return year;
	}	
	
	/** sets the date
	  @param m the month of the year (1-12)
	  @param d the day of the mongth (1-31)
	  @param y the year (four digits)
	  @param dow the day of the week (0-6) */
	public void set(int m, int d, int y, int dow)
	{
		month=m;
		day=d;
		year=y;
		this.dow=dow;
	}

	/** moves the date forward by exactly one day */
	public void tomorrow()
	{
	day++;
	dow=dow+1;
	if(dow==7) // after Saturday, sets day of week back to Sunday, or 0.
		dow=0;
	
	int monthLength=31;
	if(month==4 || month==6 || month==9 || month==11) // for months with only 30 days // 3,5,8,10
		{
			monthLength=30;
		}
	else if(month==2) // 1
	{	
		monthLength=28;
		if((year % 4)==0 || (year % 100) ==0 && (year % 400) ==0) // for leap years ; where year is only divisible by 4
		{
			monthLength=29;
		}
	}
	if(day>monthLength)
	{
		month++;
		day=1;
		if(month>12)
		{
			month=1; // 0 
			year++;
		}
	}
}
	/** @return the date as a String in the format "Monday March 18, 2002" */
	public String toString()
	{
		String ds = DOW[dow];
		String ms = monthName[month-1];
		
	return ds+" "+ms+" "+day+", "+year;
	}

	/** sets the date to today;
	  make this empty {} unless you do the extra credit. */
	public void today()
	{
		
	}
	/** Moves the date backword by exactly one day;
	  make this empty {} unless you do the extra credit. */
	public void yesterday()
	{
		
	}
}