/**
 * Print out the moments during a day when hour and minute hands overlap. Starting from 12:00:00AM
 *
 * @author kchung
 */
public class ClockNeedle {
	static final int MINUTES_IN_DAY = 24 * 60*60;

	/**
	 * Quanta is 1 minute (i.e. the smallest clock tick considered is 1 minute).
	 * So we print the 2 times (separated by 1 minute) during which (in the transition)
	 * the hour and minute hands overlap.
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		Clock clock = new Clock();

		printOverlap(clock);
	}

	private static void printOverlap(Clock clock) {
		for (int i = 0; i < MINUTES_IN_DAY - 1; i++){
			double hourInDegrees = clock.getHourInDegrees();
			double minuteInDegrees = clock.getMinuteInDegrees();


			//quanta is minute (6 degrees) so we have to account for the delta
			boolean minHandBeforeHrHand = minuteInDegrees <= hourInDegrees;
			int prevHour = clock.hour;
			int prevMin = clock.minute;
			int prevSec = clock.second;
			String prevAMPM = clock.getAMPM();

			//advance by 1 min
			clock.advanceOneSecond();

			hourInDegrees = clock.getHourInDegrees();
			minuteInDegrees = clock.getMinuteInDegrees();

			if (minuteInDegrees > hourInDegrees){
				if (minHandBeforeHrHand){
					System.out.print("Between ");
					printTime(prevHour, prevMin, prevSec, prevAMPM);
					System.out.print(" and ");
					printTime(clock.hour, clock.minute, clock.second, clock.getAMPM());
					System.out.println();
				}
			}
		}
	}

	private static void printTime(int hour, int minute, String amPM) {
		String time = String.format("%02d:%02d%s", hour, minute, amPM);
		System.out.print(time);
	}

	private static void printTime(int hour, int minute, int second, String amPM) {
		String time = String.format("%02d:%02d:%02d%s", hour, minute, second, amPM);
		System.out.println(time);
	}

	/**
	 * Represents a 12-HR clock.
	 */
	static class Clock {
		static final int MINUTES_IN_HOUR = 60;
		static final int HOURS_IN_CLOCK = 12;

		static final int DEGREES_PER_MINUTE = 6;
		static final double HOUR_DEGREES_PER_MINUTE = 0.5d;

		int second;
		int minute;
		int hour;
		boolean isAM;

		//starts at 12:00 AM
		Clock() {
			second = 0;
			minute = 0;
			hour = 0;
			isAM = true;
		}

		void advanceOneSecond() {
			second++;
			if (second == 60){
				minute++;

				if (minute == MINUTES_IN_HOUR){
					//advance hour by 1
					hour++;

					if (hour == HOURS_IN_CLOCK){
						//flip day and night
						isAM = !isAM;
					}
				}
			}

			second %= 60;
			minute %= MINUTES_IN_HOUR;
			hour %= HOURS_IN_CLOCK;
		}

		String getAMPM() {
			return isAM ? "AM" : "PM";
		}

		double getMinuteInDegrees() {
			return minute * DEGREES_PER_MINUTE + ((double) second /10);
		}

		double getHourInDegrees() {
			return (hour * 5 * DEGREES_PER_MINUTE) + getMinuteInDegrees() * 1/12d;
		}

	}
}
