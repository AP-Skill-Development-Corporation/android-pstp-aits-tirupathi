# Firebase Realtime Database
## What is Firebase Database ?
The Firebase Realtime Database is a cloud-hosted database. Data is stored as JSON and synchronized in realtime to every connected client. When you build cross-platform apps with our iOS, Android, and JavaScript SDKs, all of your clients share one Realtime Database instance and automatically receive updates with the newest data.

![picture alt](https://github.com/chaitanyak963/Documentation/raw/master/images/fb.png)

## Why is Firebase Database ?
#### Realtime 
The data stored in the Firebase Realtime Database will be reflected at realtime i.e. if there is a change in the values in the database then that change will be reflected back to all the users at that instant only and no dealy will be there.

#### Large Accessibility 
The Firebase Realtime Database can be accessed from various platforms like Android, iOS, Web. So, you need not write the same code for different platforms a number of times.

#### Offline Mode 
This is the best advantage of using Firebase Realtime Database. If you are not connected with the internet and you changed something on your application then that change will be reflected in your application at that time only but on the Firebase Database, the change will be updated once you are online i.e. your device is connected to the internet. So, even if there is no internet, the user feels like using the services the same as done when there is the internet.

#### No Application Server 
There is no need for application server here because the data is directly accessed from the mobile device.
Control access to data: By default, no one is allowed to change the data in the Firebase Realtime Database but you can control the access of data i.e. you can set which user can access the data.

## How is Firebase Database ?
#### Step 1 - Connect your App to Firebase 
If you haven't already, add Firebase to your Android project.
Then by clicking on the tools in you android studio and connect the firebase by clicking on connect to firebase from the Firebase Assistant

#### Step 2 - Create a Database 
* If you haven't already, create a Firebase project: In the Firebase console, click Add project, then follow the on-screen instructions to create a Firebase project or to add Firebase services to an existing GCP project.

* Navigate to the Database section of the Firebase console. You'll be prompted to select an existing Firebase project. Follow the database creation workflow.

* Select a starting mode for your Firebase Security Rules:

###### Test mode
Good for getting started with the mobile and web client libraries, but allows anyone to read and overwrite your data. After testing, make sure to review the Understand Firebase Realtime Database Rules section.

To get started with the web, iOS, or Android SDK, select test mode.

###### Locked mode
Denies all reads and writes from mobile and web clients. Your authenticated application servers can still access your database.

* Click Done.

#### Add the Realtime Database SDK to your app 
Add the dependency for the Realtime Database Android library to your module (app-level) Gradle file (usually app/build.gradle):
```gradle
implementation 'com.google.firebase:firebase-database:19.3.1'
```
#### Write to your database 
* Retrieve an instance of your database using getInstance() and reference the location you want to write to.
```java
DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Database");
//To push/write data into database.
reference.setValue("Welcome to Android World");
```

#### Read from your database 
* To make your app data update in realtime, you should add a ValueEventListener to the reference you just created.
* The onDataChange() method in this class is triggered once when the listener is attached and again every time the data changes, including the children.
```java
reference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String value = dataSnapshot.getValue(String.class);
        Toast.maketext(this,"Value is: "+value,Length.short()).show();
        Log.d(TAG, "Value is: " + value);
    }

    @Override
    public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Failed to read value.", error.toException());
    }
});
```
#### Update single data into your database 
* To update any single value in the database we will use updateChildren().
```java
        HashMap<String,Object> map = new HashMap<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query query = ref.child("Database").orderByChild("roll").equalTo(roll);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    map.put("name","apssdc");
                    dataSnapshot.getRef().updateChildren(map);
                    Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
```
#### Delete single data from database 
* To delete any single value from the database we will use removeValue()
```java
reference.child("123").removeValue();
```

## Related Practical

* Create a new project as shown in the below screen.

<img src ="https://github.com/chaitanyak963/Documentation/raw/master/images/screen1.png" width="600" height="300"/>

* Select an empty activity to work from the root of the project.

<img src ="https://github.com/chaitanyak963/Documentation/raw/master/images/screen2.png" width="600" height="300"/>

* Application name is given as ExampleDatabase and without doing any more changes just click on finish.

<img src ="https://github.com/chaitanyak963/Documentation/raw/master/images/screen3.png" width="600" height="300"/>



## Output Screens 

![picture alt](https://github.com/chaitanyak963/Documentation/raw/master/images/img.png)

![picture alt](https://github.com/chaitanyak963/Documentation/raw/master/images/img2.png)

![picture alt](https://github.com/chaitanyak963/Documentation/raw/master/images/imgdb.png)
