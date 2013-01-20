package com.twinkle.photodiary;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TCalendarView extends View {

	private Calendar mSelectDay;
	private GregorianCalendar mGCal;
	
	public Paint p;//= new Paint();
	public TCalendarView(Context context){
		super(context);
		p = new Paint();
		
		mSelectDay 	= Calendar.getInstance();
		mGCal 		= new GregorianCalendar();
		
	}
	
	public TCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
        mSelectDay 	= Calendar.getInstance();
		mGCal 		= new GregorianCalendar();
    }

	protected void onDraw(Canvas canvas){
		int nW = canvas.getWidth() / 7;
		float fH = (float)canvas.getHeight() - 50.0f;
		
		p.setColor(Color.argb(255, 0x30, 0x30 , 0x30));
		float fSize = p.getTextSize();
		p.setTextSize(fSize * 2.0f); 
		int iMonth = mSelectDay.get(Calendar.MONTH) + 1;
		
		String s = mSelectDay.get(Calendar.YEAR) + "³â" + iMonth + "¿ù" + mSelectDay.get(Calendar.DAY_OF_MONTH) + "ÀÏ";
		canvas.drawText(s, 20, 20, p);
	
		float fx = 2.0f;
		for(int i = 0 ; i < 8 ; i++)
		{
			canvas.drawLine(fx , 50.0f , fx, fH, p);
			fx += (float)nW;
		}
		float fx2 = canvas.getWidth();
		for(float h = 50.0f ; h <= fH ; h += 80.0f)
		{
			canvas.drawLine(2.0f , h , fx2, h, p);
		}
	}
}

