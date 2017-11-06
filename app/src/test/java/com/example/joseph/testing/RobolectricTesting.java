package com.example.joseph.testing;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)

/**
 * Created by joseph on 11/5/17.
 */

public class RobolectricTesting {

    private Main2Activity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(Main2Activity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void shouldHaveLeftMargin() throws Exception{
        TextView results = (TextView) activity.findViewById(R.id.result);
        assertEquals(15, ((LinearLayout.LayoutParams) results.getLayoutParams()).leftMargin);
    }

    @Test
    public void clickingButton_shouldChangeResultsViewText() throws Exception {

        Button button = (Button) activity.findViewById(R.id.button);
        TextView results = (TextView) activity.findViewById(R.id.result);

        button.performClick();
        assertEquals("Result!", results.getText().toString());

    }

}
