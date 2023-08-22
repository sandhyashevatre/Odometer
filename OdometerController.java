package com.learning.hello.contoller;


import com.learning.hello.contoller.exception.UnsupportedActionException.UnsupportedActionException;

import odometer.Odometer;

public class OdometerController {
  private Odometer odometer;
  private static OdometerController inst;
  
  private OdometerController() {
    
  }
  
  public static OdometerController get() {
    if (inst == null) {
      inst = new OdometerController();
    }
    return inst;
  }
  
  public void init(int size) {
    odometer = new Odometer(size);
  }
  
  public void reset(String val) throws UnsupportedActionException {
    odometer.reset();
    if(val == "")
    	throw new UnsupportedActionException("Enter something");
    odometer = new Odometer(Integer.parseInt(val));
  }
  
  public void increment() {
    odometer.increment();
  }
  
  public void decrement() {
    odometer.decrementReading();
  }
  
  public int getReading() {
    return odometer.getReading();
  }
  
  public void performAction(String action,String val) throws UnsupportedActionException{
    switch(action) {
    case "prev":
      decrement();
      break;
    case "next":
      increment();
      break;
    case "reset":
      reset(val);
      break;
    default:
      throw new UnsupportedActionException("This action not supported");
    }
  }
  
}