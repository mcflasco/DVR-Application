package week12;

import java.util.ArrayList;
import java.util.HashMap;



public class DVR
{

	public ArrayList<Recording> recordings = new ArrayList<>();

	public DVR()
	{
		recordings.add(new Recording("Friends", 10,  2100, 2200));
		recordings.add(new Recording("How I Met Your Mother", 13, 2230, 2300));
		recordings.add(new Recording("Seinfeld", 7, 2000, 2030));
	}
	
	
}
