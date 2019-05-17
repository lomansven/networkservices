package com.nike.mysneakerapp.CompoundControls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.nike.mysneakerapp.R;

public class NumberOfShoesBarView extends View {
    private Paint paintBar;
    private Paint paintEdge;
    private Paint paintBlocks;
    private int numberOfShoes;

    public NumberOfShoesBarView(Context context) {
        super(context);
        init();
    }

    public NumberOfShoesBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NumberOfShoesBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public NumberOfShoesBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        paintBar = new Paint();
        paintEdge = new Paint();
        paintBlocks = new Paint();
    }

    public void setNumberOfShoes(int numberOfShoes){
        this.numberOfShoes = numberOfShoes;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paintBar.setColor(Color.GREEN);

        paintEdge.setColor(Color.BLACK);
        paintEdge.setStrokeWidth(10f);

        paintBlocks.setColor(Color.BLACK);
        paintBlocks.setStrokeWidth(5f);

        float barMaxLength = 10f;

        float barLength = (getWidth()*(numberOfShoes/barMaxLength));

        //paint the bar
        canvas.drawRect(0, 0, barLength, getHeight(), paintBar);

        //paint the edges
        canvas.drawLine(0f, 0f, getWidth(), 0f, paintEdge);
        canvas.drawLine(0f, getHeight(), getWidth(), getHeight(), paintEdge);
        canvas.drawLine(getWidth(), 0f, getWidth(), getHeight(), paintEdge);
        canvas.drawLine(0f, 0f, 0f, getHeight(), paintEdge);

        //paint the blocks
        for (int i = 0; i < barMaxLength; i++) {
            canvas.drawLine(((getWidth()/barMaxLength)*i), 0f, ((getWidth()/barMaxLength)*i), getHeight(), paintBlocks);
        }

    }

}
