# Lineable
Lineable is a smart wristband to prevent children from going missing.  
Visit our web page : http://lineable.net/

# Lineable Library
여러분의 앱에 리니어블 라이브러리를 연동 하여 미아 방지 캠페인에 참여하실 수 있습니다.

# Feature
- 앱 사용자 주변에 리니어블 밴드를 감지하여 전송합니다.
- 미아 신고된 리니어블 밴드가 있으면 알려줍니다.

# Download
Use gradle :  
<pre>compile 'net.lineable:library:0.1.2'</pre>

or check bintray.com  
  https://bintray.com/lineable/maven/library/view  

# Code Sample
Start Library  
<pre>LineableLibrary.start(Context, mLibraryStateReceiver);</pre>

Stop Library  
<pre>LineableLibrary.stop(Context);</pre>

StateReceiver  
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
</pre>

# Environment
For Bluetooth LE scan, Library support over Android 4.3  
Also need bluetooth is ON and location permission to get location.







