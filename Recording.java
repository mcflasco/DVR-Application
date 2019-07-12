package week12;

import week11.Customer;

public class Recording // implements Comparable<Recording>
{

	public String title;
	public int channel;
	public int startTime;
	public int endTime;

	public Recording(String title, int channel, int startTime, int endTime)
	{
		this.title = title;
		this.channel = channel;
		this.startTime = startTime;
		this.endTime = endTime;

	}

	@Override
	public String toString()
	{
		return "Show Title: " + title + ", Channel: " + channel
				+ " (Start Time: " + startTime + " End Time: " + endTime + ")";
	}
	

//	public int compareTo(Recording nextStartTime)
//	{
//		String newStartTime = String.valueOf(startTime);
//		return startTime.compareTo(nextStartTime.);
//	}
}