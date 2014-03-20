package com.example.timertask;

import com.example.timertask.IUIUpdate;
import java.lang.String;


/**
* This interface will help us communicate with the worker thread.
*/
interface TimerApi {

/**
* This method will notify the worker to start or stop the process.
*/
	void setCurrentState (String state);

/**
* This method will add the UI Update listener needed for the worker thread to communicate back to the client.
*/	
	void addListener(IUIUpdate listener);

	void removeListener(IUIUpdate listener);
}