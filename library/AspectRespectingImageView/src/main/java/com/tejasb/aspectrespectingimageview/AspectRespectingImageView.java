package com.tejasb.aspectrespectingimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * @author Tejas Bhong (dev-tejasb)
 * @version 1.0
 */
public class AspectRespectingImageView extends AppCompatImageView {

    //Values
    //AspectRatio related
    public static final int MEASUREMENT_WIDTH = 0;
    public static final int MEASUREMENT_HEIGHT = 1;
    public static final float DEFAULT_ASPECT_RATIO = 0f;
    public static final boolean DEFAULT_ENABLED = false;
    public static final int DEFAULT_DOMINANT_MEASUREMENT = MEASUREMENT_WIDTH;

    //Internal values
    //AspectRatio related
    private boolean aspectRatioEnabled = DEFAULT_ENABLED;
    private int dominantMeasurement = DEFAULT_DOMINANT_MEASUREMENT;
    private float aspectRatio = DEFAULT_ASPECT_RATIO;

    public AspectRespectingImageView(@NonNull Context context) {
        super(context);
    }

    public AspectRespectingImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectRespectingImageView);

        aspectRatioEnabled = a.getBoolean(R.styleable.AspectRespectingImageView_aspectRatioEnabled, DEFAULT_ENABLED);
        dominantMeasurement = a.getInt(R.styleable.AspectRespectingImageView_dominantMeasurement, DEFAULT_DOMINANT_MEASUREMENT);
        aspectRatio = a.getFloat(R.styleable.AspectRespectingImageView_aspectRatio, DEFAULT_ASPECT_RATIO);

        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (!aspectRatioEnabled) return;
        int newWidth, newHeight;
        switch (dominantMeasurement) {
            case MEASUREMENT_WIDTH:
                newWidth = getMeasuredWidth();
                newHeight = (int) (newWidth * aspectRatio);
                break;
            case MEASUREMENT_HEIGHT:
                newHeight = getMeasuredHeight();
                newWidth = (int) (newHeight * aspectRatio);
                break;
            default:
                throw new IllegalArgumentException("Unknown dominant measurement: " + dominantMeasurement);
        }

        setMeasuredDimension(newWidth, newHeight);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        requestLayout();
    }

    //Public methods
    //AspectRatio related

    /**
     * <p>Returns aspect ratio is enabled or not</p>
     *
     * @return <code>true</code> if aspect ratio is enabled else <code>false</code>. Defaults to <code>false</code>.
     */
    public boolean isAspectRatioEnabled() {
        return aspectRatioEnabled;
    }

    /**
     * <p>Enables or disables aspect ratio.</p>
     *
     * @param aspectRatioEnabled Set <code>true</code> to enable, <code>false</code> to disable.
     */
    public void setAspectRatioEnabled(boolean aspectRatioEnabled) {
        this.aspectRatioEnabled = aspectRatioEnabled;
        requestLayout();
    }

    /**
     * <p>Returns current aspect ratio.</p>
     *
     * @return current aspect ratio. Defaults to {@link #DEFAULT_ASPECT_RATIO}.
     */
    public float getAspectRatio() {
        return aspectRatio;
    }

    /**
     * <p>Sets aspect ratio.</p>
     *
     * @param aspectRatio Aspect ratio to be set. Works only if aspect ratio is enabled.
     */
    public void setAspectRatio(float aspectRatio) {
        this.aspectRatio = aspectRatio;
        if (aspectRatioEnabled)
            requestLayout();
    }

    /**
     * <p>Returns current dominant measurement.</p>
     *
     * @return current dominant measurement. Defaults to {@link #DEFAULT_DOMINANT_MEASUREMENT}.
     */
    public int getDominantMeasurement() {
        return dominantMeasurement;
    }

    /**
     * <p>Sets dominant measurement</p>
     *
     * @param dominantMeasurement Dominant measurement to be set. Works only if aspect ratio is enabled.
     *                            Possible value {@link #MEASUREMENT_WIDTH} or {@link #MEASUREMENT_HEIGHT}.
     */
    public void setDominantMeasurement(int dominantMeasurement) {
        if (dominantMeasurement != MEASUREMENT_WIDTH && dominantMeasurement != MEASUREMENT_HEIGHT)
            throw new IllegalArgumentException("Unknown dominant measurement: " + dominantMeasurement);
        this.dominantMeasurement = dominantMeasurement;
        requestLayout();
    }
}
