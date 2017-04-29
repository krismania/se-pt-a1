package main;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * Keeps track of a recurring shift. A shift is associated with an employee,
 * a day of the week and a time.
 * @author krismania
 */
public class Shift implements Comparable<Shift>
{
	public final int ID;
	public final int employeeID;
	
	private DayOfWeek day;
	private LocalTime time;
	
	public Shift(int ID, int employeeID, DayOfWeek day, LocalTime time)
	{
		this.ID = ID;
		this.employeeID = employeeID;
		this.day = day;
		this.time = time;
	}
	
	public Shift(){employeeID = 0; ID = 0;}
	
	public DayOfWeek getDay()
	{
		return day;
	}
	
	public LocalTime getTime()
	{
		return time;
	}
	
	public void setDay(DayOfWeek day)
	{
		this.day = day;
	}
	
	public void setTime(LocalTime time)
	{
		this.time = time;
	}
	
	@Override
	public String toString()
	{
		return String.format("ID: %s, EmployeeID: %s, Day: %s, Time: %s",
						ID, employeeID, day.toString(), time.toString());
	}

	@Override
	public int compareTo(Shift s)
	{
		int byDay = day.compareTo(s.day);
		
		if (byDay == 0)
		{
			return time.compareTo(s.time);
		}
		
		return byDay;
	}
}
