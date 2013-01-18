package com.twinkle.photodiary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class TCalendarView extends View {

	public Paint p;//= new Paint();
	public TCalendarView(Context context){
		super(context);
		p = new Paint();
	}
	
	public TCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        p = new Paint();
    }

	protected void onDraw(Canvas canvas){
	
		int nW = canvas.getWidth() / 7;
		float fH = (float)canvas.getHeight() - 50.0f;
		
		p.setColor(Color.BLUE);
		float fx = 2.0f;
		for(int i = 0 ; i < 8 ; i++)
		{
			canvas.drawLine(fx , 50.0f , fx, fH, p);
			fx += (float)nW;
		}
	}
	
}
