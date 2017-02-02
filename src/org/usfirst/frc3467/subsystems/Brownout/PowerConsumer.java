package org.usfirst.frc3467.subsystems.Brownout;

import org.usfirst.frc3467.subsystems.Brownout.Brownout;


public interface PowerConsumer {

	  /**
	   * Receive a callback alert
	   *$
	   * @param newLevel The new power alert level
	   */
	  public void callbackAlert(Brownout.PowerLevel newLevel);

}
