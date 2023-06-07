package com.kiran.speakingclock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpeakingClockApplicationTests {

	@Test
	void contextLoads() {
	}
	    @Test
	    public void testConvertToWords_ValidMidday() {
	        // Test case: Valid midday time - 12:00
	        String result = convertToWords("12:00");
	        assertEquals("Midday", result);
	    }

	    @Test
	    public void testConvertToWords_ValidMidnight() {
	        // Test case: Valid midnight time - 00:00
	        String result = convertToWords("00:00");
	        assertEquals("Midnight", result);
	    }


	    @Test
	    public void testConvertToWords_InvalidMinute() {
	        // Test case: Invalid minute - 10:75
	        String result = convertToWords("10:75");
	        assertEquals("Invalid format", result);
	    }

	    @Test
	    public void testConvertToWords_ValidTime() {
	        // Test case: Valid time - 14:30
	        String result = convertToWords("14:30");
	        assertEquals("two thirty", result);
	    }
	



	public String convertToWords(String time) {
		String[] timeParts = time.split(":");
		int hours = Integer.parseInt(timeParts[0]);

		int minutes = Integer.parseInt(timeParts[1]);
		if ((hours >= 0 && hours <= 23) && (minutes == 60)) {
			hours += 1;
			minutes = 0;
		}
		if (minutes > 60 || (hours >= 24 && minutes <= 60 && minutes > 0) || (minutes > 0 && hours > 24))
			return "Invalid format";

		if (hours == 12 && minutes == 0) {

			return "Midday";
		} else if (hours == 0 && minutes == 0 || (hours == 23 && minutes == 60) || hours == 24) {
			return "Midnight";
		} else {
			StringBuilder timeInWords = new StringBuilder();

			if (hours >= 13) {
				hours -= 12;
			}

			HashMap<Integer, String> hoursValue = new HashMap<>();
			hoursValue.put(1, "one");
			hoursValue.put(2, "two");
			hoursValue.put(3, "three");
			hoursValue.put(4, "four");
			hoursValue.put(5, "five");
			hoursValue.put(6, "six");
			hoursValue.put(7, "seven");
			hoursValue.put(8, "eight");
			hoursValue.put(9, "nine");
			hoursValue.put(10, "ten");
			hoursValue.put(11, "eleven");
			hoursValue.put(12, "twelve");

			HashMap<Integer, String> minutesValue = new HashMap<>();
			minutesValue.put(0, "o'clock");
			minutesValue.put(1, "one");
			minutesValue.put(2, "two");
			minutesValue.put(3, "three");
			minutesValue.put(4, "four");
			minutesValue.put(5, "five");
			minutesValue.put(6, "six");
			minutesValue.put(7, "seven");
			minutesValue.put(8, "eight");
			minutesValue.put(9, "nine");
			minutesValue.put(10, "ten");
			minutesValue.put(11, "eleven");
			minutesValue.put(12, "twelve");
			minutesValue.put(13, "thirteen");
			minutesValue.put(14, "fourteen");
			minutesValue.put(15, "fifteen");
			minutesValue.put(16, "sixteen");
			minutesValue.put(17, "seventeen");
			minutesValue.put(18, "eighteen");
			minutesValue.put(19, "nineteen");
			minutesValue.put(20, "twenty");
			minutesValue.put(30, "thirty");
			minutesValue.put(40, "forty");
			minutesValue.put(50, "fifty");

			if (hoursValue.containsKey(hours)) {
				timeInWords.append(hoursValue.get(hours));
				timeInWords.append(" ");
			}

			if (minutesValue.containsKey(minutes)) {
				if (hoursValue.containsKey(hours)) {
					// timeInWords.append(" ");
				}
				timeInWords.append(minutesValue.get(minutes));
			} else {
				int tens = (minutes / 10) * 10;
				int ones = minutes % 10;

				if (minutesValue.containsKey(tens)) {
					timeInWords.append(minutesValue.get(tens));
					timeInWords.append(" ");
				}

				if (minutesValue.containsKey(ones)) {
					if (minutesValue.containsKey(tens)) {
						// timeInWords.append(" ");
					}
					timeInWords.append(minutesValue.get(ones));
				}
			}

			return timeInWords.toString();
		}
	}
	}
	
	


