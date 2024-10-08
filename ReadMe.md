# Handling Location permission in Android
Basic Demo project cover scenarios  when your app requests the ACCESS_FINE_LOCATION runtime permission in Android

<p align="center">
<img alt="location-permission"  src="https://github.com/aman1sr/locationPermissionDemo/blob/master/screenshot/api30_home.png?raw=true" width="360" height="640"> 
<img alt="location-permission2"  src="https://github.com/aman1sr/locationPermissionDemo/blob/master/screenshot/api31_home.png?raw=true" width="360" height="640"> 
</p>

### Major Highlights:
- Covered API >=31 Android gives an option to select following levels of location accuracy:
  - Approximate : estimated accuracy is within about 3 square kilometers
  - precise: estimated accuaracy is usually within about 50 meters - 10meters
- Covered scenarios of deny and don't ask again wrt old API and new API >=31
- ....

### Code Components
- **MainActivity:** Contains the button to ask Location permission, also save in Shared Pref and Display in TextView the status of user interaction with runtime Location permission dialog 
- **LocationPermissionHelper:** : 
  - The `hasAccessFinePermission` function checks and return a boolean if permission is granted or not
  - The `requestFineLocationPermission` function generate runtime Location permission prompt to user 
  - The `shouldShowRequestPermissionRationale` functions checks if has clicked don’t ask again button.


## Main Article
- [Article Link: Handling Location permission in Android | Kotlin](https://medium.com/@aman1024/handling-location-permission-in-android-kotlin-a1bc4c1cd9da)

<p align="center">
  <img alt="location-permission-screenshot1" src="https://github.com/aman1sr/locationPermissionDemo/blob/master/screenshot/home.png?raw=true" width="360" height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
  <img alt="location-permission-screenshot2" src="https://github.com/aman1sr/locationPermissionDemo/blob/master/screenshot/Screenshot%202024-09-27%20at%2002.02.02.png?raw=true" width="360" height="640"> &nbsp;&nbsp;&nbsp;&nbsp;
  <img alt="location-permission-screenshot3" src="https://github.com/aman1sr/locationPermissionDemo/blob/master/screenshot/Screenshot%202024-09-27%20at%2001.57.49.png?raw=true" width="360" height="640">
</p>


## References
- [Official Android Doc - Request location permissions](https://developer.android.com/develop/sensors-and-location/location/permissions#:~:text=On%20Android%2012%20(API%20level,the%20ACCESS_FINE_LOCATION%20permission%20by%20itself.)

