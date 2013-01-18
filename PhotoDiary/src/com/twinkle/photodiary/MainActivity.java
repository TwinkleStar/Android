package com.twinkle.photodiary;

import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  R.layout.activity_main
        setContentView(R.layout.activity_main);
      //  setContentView(new CalendarView(this));
//       CalendarView v =  (CalendarView)findViewById(R.id.calendar);
        
 //       int a = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
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
    
}

