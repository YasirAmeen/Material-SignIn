package app.materialsignup.fonts;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hp on 5/16/2016.
 */
public class robotoThinItalic extends TextView {
    public robotoThinItalic (Context context) {
        super(context);
        setFont();
    }
    public robotoThinItalic (Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }
    public robotoThinItalic (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void setFont() {
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Thin.ttf");
        setTypeface(font, Typeface.ITALIC);
    }


    public void updateTextSize(Context context) {
        getTypeface();
        float currentTextSize = getTextSize();
        SharedPreferences otherSettings = context.getSharedPreferences("settings", 0);
        float newScale = otherSettings.getFloat("key_scaling", 1f);
        setTextSize(newScale * currentTextSize);
    }
}
