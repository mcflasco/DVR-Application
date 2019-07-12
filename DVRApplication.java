package week12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DVRApplication
{

	static Scanner input;
	static DVR dvr;

	public static void main(String[] args) throws FileNotFoundException
	{
		PrintStream print = new PrintStream(new File("Schedule.txt"));

		PrintWriter pw = new PrintWriter(print);
		dvr = new DVR();

		input = new Scanner(System.in);

		boolean run = true;

		while(run)
		{

			System.out.println();
			System.out.print("Enter command ('help' for help): ");
			String menu = input.nextLine();
			System.out.println();

			switch(menu)
			{
				case "help":

					System.out.println("add-recording - add a recording");
					System.out.println("edit-recording - edit a recording");
					System.out.println("delete-recording - delete a recording");
					System.out.println("show-recordings - show recordings");
					System.out.println("exit - exit the program");
					System.out.println("help - show help");
					break;

				case "add-recording":
					addRecording();
					break;

				case "edit-recording":
					editRecording();
					break;

				case "delete-recording":
					deleteRecording();
					break;

				case "show-recordings":
					for(Recording recording : dvr.recordings)
					{
						pw.println(recording);
					}
					pw.close();
					showRecordings();

					break;

				case "exit":
					run = false;
					break;

			}

		}
		input.close();
	}

	public static void showRecordings()
	{
		for(Recording recording : dvr.recordings)
			System.out.println(recording);

	}

	public static void addRecording()
	{
		int startTime;
		String test;
		int test1;
		boolean isTrue;
		int i = 0;
		
		System.out.print("Enter recording name: ");
		String title = input.nextLine();

		System.out.print("Enter channel: ");
		int channel = Integer.parseInt(input.nextLine());

//		do {
		isTrue = false;
		System.out.print("Enter start time (Military time): ");
		startTime = input.nextInt();
//		test = String.valueOf(startTime);
//		test1 = Integer.parseInt(test.substring(2, 4));
//		if(test1 == 00 || test1 == 30) {
//			isTrue = true;
//		}
//		}while(isTrue);
		
//		if(recording.startTime == startTime) {
//		i++;
//		if(i == 3) {
//			System.out.println("only 3 shows can be recorded at once");
//		}
//	}

		System.out.print("Enter end time(Military time): ");
		int endTime = input.nextInt();

		Recording recording = new Recording(title, channel, startTime, endTime);
		dvr.recordings.add(recording);

	}

	private static void editRecording()
	{

		System.out.print("Enter the show title: ");
		String title = input.nextLine();

		for(int i = 0; i < dvr.recordings.size(); i++)
		{
			if(dvr.recordings.get(i).title.equals(title))
			{
				System.out.println(
						"Selected Recording: " + dvr.recordings.get(i));
				dvr.recordings.remove(i);
			}

		}
		System.out.print("Enter the new show title: ");
		String newTitle = input.nextLine();

		System.out.print("Enter the channel: ");
		int channel = input.nextInt();
		System.out.print("Enter start time: ");
		int startTime = input.nextInt();
		System.out.print("Enter the end time: ");
		int endTime = input.nextInt();

		Recording recording = new Recording(newTitle, channel, startTime,
				endTime);
		dvr.recordings.add(recording);

	}

	public static void deleteRecording()
	{
		System.out.print("Enter the show title: ");
		String title = input.nextLine();
		for(int i = 0; i < dvr.recordings.size(); i++)
		{
			if(dvr.recordings.get(i).title.equals(title))
			{
				System.out.println(
						"Cancelled Recording: " + dvr.recordings.get(i));
				dvr.recordings.remove(i);

			}
		}
	}

}
