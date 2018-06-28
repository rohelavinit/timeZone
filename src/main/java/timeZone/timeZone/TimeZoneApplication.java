package timeZone.timeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@SpringBootApplication
public class TimeZoneApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("US/Hawaii"));
	}

	public static void main(String[] args) {
		SpringApplication.run(TimeZoneApplication.class, args);
		Calendar localTime = Calendar.getInstance();

		int hour = localTime.get(Calendar.HOUR);
		int minute = localTime.get(Calendar.MINUTE);
		int second = localTime.get(Calendar.SECOND);
		int year = localTime.get(Calendar.YEAR);
		int date = localTime.get(Calendar.DATE);

//		Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));

		DateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss z");
//		formatter.setTimeZone(localTime.getTimeZone());

		String newZealandTime = formatter.format(localTime.getTime());

		System.out.printf("Local time: %02d:%02d:%02d %02d %02d \n", hour, minute, second, year,date);
		System.out.println(newZealandTime);
	}

//	public static void main(String[] args) {
//
//		Calendar localTime = Calendar.getInstance();
//
//		int hour = localTime.get(Calendar.HOUR);
//		int minute = localTime.get(Calendar.MINUTE);
//		int second = localTime.get(Calendar.SECOND);
//		int year = localTime.get(Calendar.YEAR);
//		int date = localTime.get(Calendar.DATE);
//
//		// Print the local time
//		System.out.printf("Local time: %02d:%02d:%02d %02d %02d\n", hour, minute, second, year,date);
//
//		// Create a calendar object for representing a Singapore time zone.
//		Calendar indiaTime = new GregorianCalendar(TimeZone.getTimeZone("US/Hawaii"));
//		indiaTime.setTimeInMillis(localTime.getTimeInMillis());
//		hour = indiaTime.get(Calendar.HOUR);
//		minute = indiaTime.get(Calendar.MINUTE);
//		second = indiaTime.get(Calendar.SECOND);
//		year = indiaTime.get(Calendar.YEAR);
//		date = indiaTime.get(Calendar.DATE);
//
//		// Print the local time in Germany time zone
//		System.out.printf("India time: %02d:%02d:%02d %02d %02d\n", hour, minute, second, year,date);
//	}
}
