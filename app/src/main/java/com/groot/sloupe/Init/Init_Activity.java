package com.groot.sloupe.Init;

import android.widget.TextView;
import com.groot.sloupe.R;
import org.w3c.dom.Text;

public class Init_Activity {
    private static TextView textView;

    public  TextView initTextView(){
        return textView.findViewById(R.id.textview1);
    }
}
