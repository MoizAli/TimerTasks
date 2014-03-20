package com.example.timertask;

import java.util.ArrayList;
import java.util.List;












import android.app.Service;
import android.content.Intent;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service{

	private static final String TAG = "timerTask";
	String currentState = "";
	private int counter;
	List<IUIUpdate> listUIListeners = new ArrayList<IUIUpdate>();
	Task taskTimer = new Task();
	private Handler serviceHandler;



	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		if (RemoteService.class.getName().equals(intent.getAction())) {
			Log.d(TAG, "Bound by intent " + intent);
			return apiEndpoint;
		} else {
			return null;
		}
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(serviceHandler != null)
			serviceHandler.removeCallbacks(taskTimer);
			serviceHandler = new Handler();
			serviceHandler.postDelayed(taskTimer, 1000);
	}
	
	


	class Task implements Runnable {
		public void run() {
			++counter;
			synchronized (listUIListeners) {
				for(IUIUpdate listener : listUIListeners){
					try {
						listener.handleUIUpdate(counter+"");
						listener.notifyCurrentState("Started");
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			serviceHandler.postDelayed(this,1000L);
			Log.i(getClass().getSimpleName(), "Incrementing counter in the run method");
		}
	}

	private TimerApi.Stub apiEndpoint = new TimerApi.Stub() {

		@Override
		public void setCurrentState(String state) throws RemoteException {
			// TODO Auto-generated method stub
			synchronized (state) {
				currentState = state;
				if(currentState.equals("start")){
					
					notifyUIThread("Starting");
				}else if(currentState.equals("stop")) {
					notifyUIThread("Stopping");
					serviceHandler.removeCallbacks(taskTimer);
					stopSelf();
				}
			}
		}

		@Override
		public void addListener(IUIUpdate listener) throws RemoteException {
			// TODO Auto-generated method stub
			synchronized (listener) {
				listUIListeners.add(listener);
			}
		}

		@Override
		public void removeListener(IUIUpdate listener) throws RemoteException {
			// TODO Auto-generated method stub
			synchronized (listener) {
				listUIListeners.remove(listener);
			}
		}
	};

	private void notifyUIThread(final String message) {
		synchronized (listUIListeners) {
			for(IUIUpdate listener : listUIListeners){
				try {
					listener.notifyCurrentState(message);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		notifyUIThread("Stopped");
		super.onDestroy();
	}
}
