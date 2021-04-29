# Android -Google Sign-In Intigration to android application with Google Account 

* Source From Offical Documentation https://developers.google.com/identity/sign-in/android/sign-in
* sample app design shown below 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign.png">

* Step-1:Create new android studio project with **empty activtiy**
* And open this site https://developers.google.com/identity/sign-in/android/start-integrating
     -  Login the Gmail-account
     -  Read the Prerequisites and Add the below dependancy (at build.gradle file module:app)

``` XML 
     //at build.gradle file
  dependencies {
        //for google sign-in activity need to add below dependancy 
        implementation 'com.google.android.gms:play-services-auth:19.0.0'
    }
```  
* In the WEB follow the below steps:
* Click on the **Configure a project** button

<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(41).png">

* Give the project name. (you may create new or else use exist project).Here creating new project
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(42).png">

* project name My Project
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(43).png">
* next,Configure your OAuth Client (Just fill the any refarence name) .here **mygooglesign** were giving 
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(44).png">
 
<img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(45).png">
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(46).png">
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(47).png ">      
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(48).png">  
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(49).png">  
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(50).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(51).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(52).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(53).png"> 
* <img src="https://raw.githubusercontent.com/AP-Skill-Development-Corporation/android-pstp-aits-tirupathi/master/g-sign%20images/Screenshot%20(54).png">  
## Practical Implimenation code:(android studio ide version 4.1.3 used ) 
* After creation of new project open the gradle script file(build.gradle (module:app)level
```XML
plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 29
    buildToolsVersion "29.0.3"
 
    defaultConfig {
        applicationId "com.example.gsignin_intigration"
        minSdkVersion 16
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.3.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.+'

    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    /*below dependaancy for Google Sign*/
    implementation 'com.google.android.gms:play-services-auth:19.0.0'
    implementation 'com.github.bumptech.glide:glide:3.7.0'
}
```

    
      
