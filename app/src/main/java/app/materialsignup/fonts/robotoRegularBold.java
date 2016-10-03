package app.materialsignup.fonts;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class robotoRegularBold extends TextView {
	public robotoRegularBold(Context context) {
		super(context);
		setFont();
	}
	public robotoRegularBold(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFont();
	}
	public robotoRegularBold(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		setFont();
	}

	private void setFont() {
		Typeface font = Typeface.createFromAsset(getContext().getAssets(), "fonts/Roboto-Regular.ttf");
		setTypeface(font, Typeface.BOLD);
//		setTextSize(Constants.fontsize);
//		setTextSize(40);
//		setLineSpacing(5,2.5f);
//		setTextColor(getResources().getColor(R.color.priwhite));
	}
	
	
	public void updateTextSize(Context context) {
	    getTypeface();
	    float currentTextSize = getTextSize();
	    SharedPreferences otherSettings = context.getSharedPreferences("settings", 0);
	    float newScale = otherSettings.getFloat("key_scaling", 1f);
	    setTextSize(newScale * currentTextSize); 
	}
}