/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\TestTasks\\TimerTask\\src\\com\\example\\timertask\\IUIUpdate.aidl
 */
package com.example.timertask;
/**
* This interface will help us communicate back with the calling client (In this case the MainActivity).
*/
public interface IUIUpdate extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.timertask.IUIUpdate
{
private static final java.lang.String DESCRIPTOR = "com.example.timertask.IUIUpdate";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.timertask.IUIUpdate interface,
 * generating a proxy if needed.
 */
public static com.example.timertask.IUIUpdate asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.timertask.IUIUpdate))) {
return ((com.example.timertask.IUIUpdate)iin);
}
return new com.example.timertask.IUIUpdate.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_handleUIUpdate:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.handleUIUpdate(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyCurrentState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.notifyCurrentState(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.timertask.IUIUpdate
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
* This method will notify the calling client the current timer value.
* @params counter: the value returned by the worker process.
*/
@Override public void handleUIUpdate(java.lang.String counter) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(counter);
mRemote.transact(Stub.TRANSACTION_handleUIUpdate, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
* This method will notify the calling client the current state of the timer.
* @params state: the value returned by the worker process.
*/
@Override public void notifyCurrentState(java.lang.String state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(state);
mRemote.transact(Stub.TRANSACTION_notifyCurrentState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_handleUIUpdate = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_notifyCurrentState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
/**
* This method will notify the calling client the current timer value.
* @params counter: the value returned by the worker process.
*/
public void handleUIUpdate(java.lang.String counter) throws android.os.RemoteException;
/**
* This method will notify the calling client the current state of the timer.
* @params state: the value returned by the worker process.
*/
public void notifyCurrentState(java.lang.String state) throws android.os.RemoteException;
}
