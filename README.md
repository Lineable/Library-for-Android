# Lineable
Lineable is a smart wristband to prevent children from going missing.  
Visit our web page : http://lineable.net/

# Lineable Library
You can implement Lineable library in your App.  

# Feature
- Detect active Lineables near the users.
- If there are missing Lineables nearby, the data(The picture of a missing child, phone numbers of the parents and etc) will be provided and you can choose whether to notify the user or not. If you choose to notifty the user, the user can contribute to find the child.

# Download
Use gradle :  
<pre>compile 'net.lineable:library:0.1.7'</pre>

or check bintray.com  
  https://bintray.com/lineable/maven/library/view  

# Code Sample
#### - Start Library  
<pre>LineableLibrary.start(Context, "YOUR_API_KEY", SCAN_INTERVAL_MIN, StateReceiver);</pre>
1. YOUR_API_KEY : To get api key, please contact with support@lineable.net.
2. SCAN_INTERVAL_MIN : means sleep duration between BLE scan in minutes. min 1 ~ max 5 minutes.
#### - Stop Library  
<pre>LineableLibrary.stop(Context);</pre>

#### - StateReceiver  
You can get variable library states with StateReceiver.
<pre>
- DEPRECATED : this library is deprecated, and not working. update library.
- MISSING_LINEABLE : library detected missing lineable. please notice to user to find child. 
- BLE_SCAN_START : scan started.
- BLE_SCAN_STOP : scan end.
- SET_NEXT_ALARM : library set next starting intent.
- CANCEL_NEXT_ALARM : library cancelled next starting intent. 
- ERR_BT_NULL : Bluetooth is not available.
- ERR_BT_OFF : Bluetooth switch is off.
- ERR_LOCATION_NEED_M : if your app does not have location permission (from Android M version)
- SERVER_RESPONSE : you can show server response message
- APIKEY_INVALID : api key is wrong.
- APIKEY_EXPIRED : api key is expired. please issue apikey again.
</pre>

# Environment
For Bluetooth LE scan, Library support over Android 4.3  
Also need bluetooth and location permission to get location.
