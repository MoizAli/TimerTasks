package com.example.timertask;

/**
* This interface will help us communicate back with the calling client (In this case the MainActivity).
*/
interface IUIUpdate {

/**
* This method will notify the calling client the current timer value.
* @params counter: the value returned by the worker process.
*/
	void handleUIUpdate(String counter);
	/**
* This method will notify the calling client the current state of the timer.
* @params state: the value returned by the worker process.
*/
	void notifyCurrentState(String state);
}