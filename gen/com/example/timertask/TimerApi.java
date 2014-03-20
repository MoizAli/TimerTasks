/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\TestTasks\\TimerTask\\src\\com\\example\\timertask\\TimerApi.aidl
 */
package com.example.timertask;
/**
* This interface will help us communicate with the worker thread.
*/
public interface TimerApi extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.example.timertask.TimerApi
{
private static final java.lang.String DESCRIPTOR = "com.example.timertask.TimerApi";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.example.timertask.TimerApi interface,
 * generating a proxy if needed.
 */
public static com.example.timertask.TimerApi asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.example.timertask.TimerApi))) {
return ((com.example.timertask.TimerApi)iin);
}
return new com.example.timertask.TimerApi.Stub.Proxy(obj);
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
case TRANSACTION_setCurrentState:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.setCurrentState(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
com.example.timertask.IUIUpdate _arg0;
_arg0 = com.example.timertask.IUIUpdate.Stub.asInterface(data.readStrongBinder());
this.addListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeListener:
{
data.enforceInterface(DESCRIPTOR);
com.example.timertask.IUIUpdate _arg0;
_arg0 = com.example.timertask.IUIUpdate.Stub.asInterface(data.readStrongBinder());
this.removeListener(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.example.timertask.TimerApi
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
* This method will notify the worker to start or stop the process.
*/
@Override public void setCurrentState(java.lang.String state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(state);
mRemote.transact(Stub.TRANSACTION_setCurrentState, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
* This method will add the UI Update listener needed for the worker thread to communicate back to the client.
*/
@Override public void addListener(com.example.timertask.IUIUpdate listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeListener(com.example.timertask.IUIUpdate listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_setCurrentState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
* This method will notify the worker to start or stop the process.
*/
public void setCurrentState(java.lang.String state) throws android.os.RemoteException;
/**
* This method will add the UI Update listener needed for the worker thread to communicate back to the client.
*/
public void addListener(com.example.timertask.IUIUpdate listener) throws android.os.RemoteException;
public void removeListener(com.example.timertask.IUIUpdate listener) throws android.os.RemoteException;
}
