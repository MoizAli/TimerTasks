TimerTasks
==========

A simple timer application implemented using Android Inter Process Communication(IPC).

This application exposes a service which can be accessed from any process in the android os.

Interaction to and fro the service and the connected clients is done by implementing the Android Interface Definition Language (AIDL). It allows you to define the programming interface that both the client and service agree upon in order to communicate with each other using interprocess communication (IPC).

Interfaces worth checking:

IUIUpdate.aidl This interface will help us communicate back with the calling client (In this case the MainActivity).

Timerapi.aidl This interface will help us communicate with the worker thread.
