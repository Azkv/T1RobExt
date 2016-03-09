package com.testing.azarkovic.testing;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by azarkovic on 4.3.2016..
 */
public class Icon extends ImageView
{
    public static enum IconType
    {
        PROFILE,
        MESSAGE,
        ADD_FRIEND
    }
    private LinearLayout container;
    private Icon.IconType iconType ;
    public Icon(Context ctx, Icon.IconType iconType)
    {
        super(ctx);
        this.iconType = iconType;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT));
        lp.weight = 7;
        lp.rightMargin = 5;
        this.setLayoutParams(lp);
        this.setScaleType(ScaleType.FIT_CENTER);
        setIconImage();

    }

    boolean doOnce = true;
    @Override
    protected void onDraw(Canvas canvas)
    {


        super.onDraw(canvas);
    }

    private void setIconImage()
    {
        switch(iconType)
        {

            case PROFILE:
                this.setImageResource(R.drawable.icon_profile); break;

            case MESSAGE:
                this.setImageResource(R.drawable.icon_message); break;
            case ADD_FRIEND:
                this.setImageResource(R.drawable.icon_add_friend); break;
        }
    }
}
