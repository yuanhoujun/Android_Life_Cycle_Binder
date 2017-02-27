package me.foji.android.sample;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtil
 *
 * @author Scott Smith 2017-02-27 20:24
 */
public class ToastUtil {
    public static final void toast(Context context , Class<?> cls , CharSequence text) {
        Toast.makeText(context , cls.getName() + ":" + text , Toast.LENGTH_SHORT).show();
    }
}
