package com.example.firebasecurd;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int SELECT_PICTURE = 1;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 22;
    EditText et_name, et_mobile, et_email;
    Button b_cam, b_upload, b_submit, b_next;
    ImageView iv;
    private static final int Image_Capture_Code = 0;

    FirebaseDatabase database;
    DatabaseReference myRef;

    FirebaseStorage storage;
    StorageReference storageReference;
    Uri filepath,img_uri;
    String fileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobile);
        et_email = findViewById(R.id.email);
        b_cam = findViewById(R.id.camera);
        b_upload = findViewById(R.id.g);
        b_submit = findViewById(R.id.submit);
        b_next = findViewById(R.id.view);
        iv = findViewById(R.id.pic);
        b_cam.setOnClickListener(this);
        b_upload.setOnClickListener(this);
        b_submit.setOnClickListener(this);
        b_next.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("contacts");

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
    }

    private void uploadImage() {

        if (filepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.setCancelable(false);
            progressDialog.show();
            storageReference = storageReference.child("images/"+ UUID.randomUUID().toString());
            storageReference.putFile(filepath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    firebasefilepath= taskSnapshot.getStorage().getDownloadUrl();
                    progressDialog.dismiss();
                    //Toast.makeText(MainActivity.this, ""+firebasefilepath, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Uploaded....", Toast.LENGTH_SHORT).show();
                    saveData();


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                            .getTotalByteCount());
                    progressDialog.setMessage("Uploaded "+(int)progress+"%");
                }
            });


        }
        //return firebasefilepath;
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera:
                openCamera();
                break;
            case R.id.g:
                openGallery();
                break;
            case R.id.submit:
                uploadImage();
                break;
            case R.id.view:
                naviGatetoDetailActivity();
                break;
//            case R.id.upload:
//                uploadImage();
        }

    }

    private void naviGatetoDetailActivity() {
        Intent i = new Intent(this, DetailsActivity.class);
        startActivity(i);
    }

    private void saveData() {
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                fileUrl = uri.toString();
                //Toast.makeText(MainActivity.this, ""+fileUrl, Toast.LENGTH_SHORT).show();
                String name = et_name.getText().toString();
                String mobile = et_mobile.getText().toString();
                String email = et_email.getText().toString();
                if (fileUrl!=null){
                    User u = new User(name,mobile,email,fileUrl);
                    myRef.push().setValue(u).
                            addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(MainActivity.this, "Your Details are Saved....", Toast.LENGTH_SHORT).show();
                                    filepath = Uri.EMPTY;
                                    et_name.setText("");
                                    et_mobile.setText("");
                                    et_email.setText("");
                                    iv.setImageURI(filepath);
                                    Intent i = new Intent(MainActivity.this,DetailsActivity.class);
                                    startActivity(i);
                                }
                            });
                }
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        startActivityForResult(Intent.createChooser(intent,
                "Select Picture"), SELECT_PICTURE);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    private void openCamera() {

        Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //cInt.putExtra(MediaStore.EXTRA_OUTPUT,img_uri);
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        startActivityForResult(cInt, Image_Capture_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Image_Capture_Code:
//                   Uri camera_uri = Uri.parse(String.valueOf(data.getExtras().get("data")));
                    // filepath = String.valueOf(data.getData());
                    Bitmap photo = (Bitmap) data.getExtras().get("data");

                    String partFilename = currentDateFormat();
                    storeCameraPhotoInSDCard(photo, partFilename);
                    String storeFilename = "photo_" + partFilename + ".jpg";
                    Bitmap mBitmap = getImageFileFromSDCard(storeFilename);
                    iv.setImageBitmap(mBitmap);
                    filepath = Uri.parse(String.valueOf(mBitmap));
                  /* iv.setImageURI(img_uri);
                   img_uri = filepath;
                    Toast.makeText(this, ""+img_uri, Toast.LENGTH_SHORT).show();*/

                    break;
                case SELECT_PICTURE:
                    filepath = data.getData();
                    iv.setImageURI(filepath);
                    Toast.makeText(this, "" + filepath, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private String currentDateFormat(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
        String  currentTimeStamp = dateFormat.format(new Date());
        return currentTimeStamp;
    }

    private void storeCameraPhotoInSDCard(Bitmap bitmap, String currentDate){
        File outputFile = new File(Environment.getExternalStorageDirectory(), "photo_" + currentDate + ".jpg");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Bitmap getImageFileFromSDCard(String filename){
        Bitmap bitmap = null;
        File imageFile = new File(Environment.getExternalStorageDirectory() + filename);
        try {
            FileInputStream fis = new FileInputStream(imageFile);
            bitmap = BitmapFactory.decodeStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}