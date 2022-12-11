package advisingQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Josh Flatt
 * CS 200 Final Project
 * 10 December 2022
 */
public class ExportToCSV {

	private ArrayList<Meeting> meetings;
	
	// Constructors
	public ExportToCSV(ArrayList<Meeting> meetings) {
		this.meetings = meetings;
	}
	
	// Sorting methods - Both use Insertion Sort
	public void descendSortByDuration() {
		int meetingCount = meetings.size();
		for (int i = 1; i < meetingCount; ++i) {
			
			int j = i;
			while (j > 0 && meetings.get(j).getDuration().compareTo(meetings.get(j - 1).getDuration()) > 0) {
				
				Meeting temp = meetings.get(j);
				meetings.set(j, meetings.get(j - 1));
				meetings.set(j - 1, temp);
				--j;
			}
		}
	}
	public void ascendSortByStartTimeDate() {
		int meetingCount = meetings.size();
		for (int i = 1; i < meetingCount; ++i) {
			
			int j = i;
			while (j > 0 && meetings.get(j).getStartDateTime().compareTo(meetings.get(j - 1).getStartDateTime()) > 0) {
				
				Meeting temp = meetings.get(j);
				meetings.set(j, meetings.get(j - 1));
				meetings.set(j - 1, temp);
				--j;
			}
		}
	}
	
	// Export to CSV
	public void exportMeetings() {
		try {
			FileOutputStream fileStream = new FileOutputStream("export/meetingExport.csv");
			PrintWriter outFS = new PrintWriter(fileStream);
			String endDateTime = "";
			outFS.println("ID" + "," + "Student" + "," + "StudentEmail" + "," + "Advisor" + ","
						+ "StartDateTime" + "," + "EndDateTime" + "," + "Duration");
			for (Meeting meeting : meetings) {
				endDateTime = meeting.getEndDateTime() + ""; // Handle null values
				
				outFS.println(meeting.getID() + "," + meeting.getTableStudentFullName() + ","
						+ meeting.getTableStudentEmail() + "," + meeting.getTableAdvisorFirstName() + ","
						+ meeting.getStartDateTime() + "," + endDateTime + "," + meeting.getTableDuration());
			}
			outFS.close();
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
