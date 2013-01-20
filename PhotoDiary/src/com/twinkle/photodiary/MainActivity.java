package com.twinkle.photodiary;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Calendar;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;

public class MainActivity extends Activity implements OnClickListener {

	private MediaScannerConnection	mScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  R.layout.activity_main
        setContentView(R.layout.activity_main);
        
        TextView tv = (TextView)findViewById(R.id.todaydate);
        
        Calendar c = Calendar.getInstance();
        
        int iMonth = c.get(Calendar.MONDAY) + 1;
        String s = c.get(Calendar.YEAR) + "년" +  iMonth + "월" + c.get(Calendar.DATE) + "일";
        
        tv.setText(s);
        
        Button btn = (Button)findViewById(R.id.button1);
        
        btn.setOnClickListener(this);
        




        mScanner = new MediaScannerConnection(this , mScanClient);
        
        mScanner.connect();

        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    @Override
    public void onClick(View v)  {
    	Cursor mManagedCursor;

    	

    	mManagedCursor = getContentResolver().query(Images.Media.INTERNAL_CONTENT_URI , null, null, null, null) ;

    	
    	if(mManagedCursor != null)

    	{
    		MediaStore.
    		mManagedCursor.moveToFirst();

			
    		while(true)
    		{
    		
    			String bucket_display_name =

    				mManagedCursor.getString(

    				mManagedCursor.getColumnIndex(

    				Images.ImageColumns.BUCKET_DISPLAY_NAME));
    		
    			String title =

    					mManagedCursor.getString(

    					mManagedCursor.getColumnIndex(

    					Images.ImageColumns.TITLE)); 
    			
    			int nSize = mManagedCursor.getColumnCount();
    			
    			if(mManagedCursor.isLast())
    			{
    				break;
    			}
    			else
    			{
    				mManagedCursor.moveToNext();
    			}
    			
    		}
    	}
    
   // 	Intent intent = new Intent(Intent.ACTION_PICK);    
   // 	intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);    
   // 	startActivityForResult(intent, 0);
    }
    /*
    @Override
    public void onPause(){
    	
    }
    
    @Override 
    public void onResume(){
    	
    }
    
    @Override
    public void onDestroy(){
    	
    }
    */
    
    private MediaScannerConnectionClient mScanClient = new MediaScannerConnectionClient(){

        public void onMediaScannerConnected() {
        	Log.i("PhotoDiary", "onMediaScannerConnected");
            File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES );                // 외장 디렉토리 가져옴 
            
            File[] fileNames = file.listFiles(new FilenameFilter(){               // 특정 확장자만 가진 파일들을 필터링함 
                public boolean accept(File dir, String name){

                return name.endsWith(".jpeg") 
                    || name.endsWith(".jpg")
                    || name.endsWith(".wmv")
                    ;

                }
            });
            
            if (fileNames != null)
            {
                for (int i = 0; i < fileNames.length ; i++)          //  파일 갯수 만큼   scanFile을 호출함 
                {
                	mScanner.scanFile(fileNames[i].getAbsolutePath(), null);
                }
            }
        }

        public void onScanCompleted(String path, Uri uri) {
            Log.i("PhotoDiary", "onScanCompleted(" + path + ", " + uri.toString() + ")");     
        }
  };
    
}

