/**
 * Document  : Reminder.java
 * Created on: 03-04-2020, 08:48:34 PM
 * Author    : Nivesh-GC
 */

				///Jenkins integration with GIT
/*
 * Simple demo that uses java.util.Timer to schedule a task to execute
 * once 5 seconds have passed.
 */
 
package thread;

import java.util.Timer;
import java.util.TimerTask;

public class Reminder {
    Timer timer;

    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }

    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Time's up!");
	    timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
		System.out.println("Get ready");
		System.out.println("About to schedule task.");
        new Reminder(5);
		System.out.println("Task scheduled.");
    }
}
