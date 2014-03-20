package com.example.timertask;





import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView txtCount , txtCurrentState;
	Button btnAction;
	
	protected static final String TAG = null;
	TimerApi api;
	String intialState = "stopped";
	String currentState = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtCount = (TextView)findViewById(R.id.txtCount);
		txtCurrentState = (TextView)findViewById(R.id.txtCurrentState);
		btnAction = (Button)findViewById(R.id.btnAction);
		
		
		btnAction.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
					if(btnAction.getText().toString().equals("Start")){
						//Starts the service.
						startService();
					}else if(btnAction.getText().toString().equals("Stop")){
						// Notifies the service to move to stop state.
						try {
							api.setCurrentState("stop");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		});
	}

	private void startService() {
		Intent intent = new Intent(RemoteService.class.getName());

		// start the service explicitly. 
		// otherwise it will only run while the IPC connection is up.        
		startService(intent); 

		bindService(intent, serviceConnection, 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Creating a connection with the background service. 
	 */
	private ServiceConnection serviceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.i(TAG, "Service connection established");
	
			// that's how we get the client side of the IPC connection
			api = TimerApi.Stub.asInterface(service);
			try {
				api.addListener(collectorListener);
			} catch (RemoteException e) {
				Log.e(TAG, "Failed to add listener", e);
			}
			
			//updateTweetView();
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i(TAG, "Service connection closed");			
		}
	};
	
	
	private IUIUpdate.Stub collectorListener = new IUIUpdate.Stub() {

		@Override
		public void handleUIUpdate(final String counter) throws RemoteException {
			runOnUiThread(new Runnable() {
				public void run() {
					txtCount.setText(counter);
				}
			});
		}

		@Override
		public void notifyCurrentState(final String state) throws RemoteException {
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					txtCurrentState.setText(state);
					Log.e("Current state", state);
					currentState = state;
					if(currentState.equals("Started"))
						btnAction.setText("Stop");
					else if(currentState.equals("Stopped")){
						btnAction.setText("Start");
						txtCount.setText("0");
					}
				}
			});
			
		}
		
	};

}
