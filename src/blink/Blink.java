/*
 *	Blink.java
 * 
 *	Copyright (c) 2012 DiSBeF, University of Urbino.
 * 
 *	This file is part of VirtualSense.
 * 
 *	VirtualSense is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	VirtualSense is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 * 
 *	You should have received a copy of the GNU General Public License
 *	along with VirtualSense.  If not, see <http://www.gnu.org/licenses/>.
 */

import javax.virtualsense.actuators.Leds;
import javax.virtualsense.powermanagement.PowerManager;

import java.lang.Runtime;

public class Blink {

	public static void motemain() {

		boolean state = true;

		/*
		 * slow down the system clock (normally it is configured at 10 ms) to
		 * reduce power consumption leaves the CPU in the LPM3 state
		 */
		PowerManager.setSystemClockMillis(500);
		while (true) {
			for (short i = 0; i < 3; i++) {

				Leds.setLed(i, state);
				Thread.sleep(1000);
			}
			state = !state;
			System.out.print("Free mem: ");
			System.out.println(Runtime.freeMemory());
		}

	}
}
