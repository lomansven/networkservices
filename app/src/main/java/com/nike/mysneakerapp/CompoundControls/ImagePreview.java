package com.nike.mysneakerapp.CompoundControls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.nike.mysneakerapp.R;

public class ImagePreview extends ImageView {

    private ImageView image;
    private Paint paint;
    private boolean hasPicture;

    public ImagePreview(Context context) {
        super(context);
        init();
    }

    public ImagePreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImagePreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ImagePreview(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        this.image = findViewById(R.id.ivPreviewImageView);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Draws a cross on the screen
        //If the user has given the Brand/Shoe a picture, the cross won't be drawn
        if(!hasPicture) {

            paint.setColor(Color.BLACK);
            paint.setStrokeWidth(50f);

            int width = getWidth();
            int height = getHeight();

            canvas.drawLine((width / 20f), (height - (height / 20f)), (width - (width / 20f)), (height / 20f), paint);
            canvas.drawLine((width / 20f), (height / 20f), (width - (width / 20f)), (height - (height / 20f)), paint);
        }
    }

    public void setHasPicture() {
        this.hasPicture = true;
    }
}
