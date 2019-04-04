package com.lib.frame.view;

import android.graphics.Point;
import android.support.v4.app.DialogFragment;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/14/16
 * Time: 2:03 AM
 * Desc: BaseDialogFragment
 */
public class BaseDialogFragment extends DialogFragment {

    private static final float DIALOG_WIDTH_PROPORTION = 0.35f;

    protected void resizeDialogSize() {
//        Window window = getDialog().getWindow();
//        Point size = new Point();
//        window.getWindowManager().getDefaultDisplay().getSize(size);
//        window.setLayout((int) (size.x * DIALOG_WIDTH_PROPORTION), WindowManager.LayoutParams.WRAP_CONTENT);
        resizeDialogSize(DIALOG_WIDTH_PROPORTION);
    }

    protected void resizeDialogSize(float proportion) {
        Window window = getDialog().getWindow();
        Point size = new Point();
        window.getWindowManager().getDefaultDisplay().getSize(size);
        window.setLayout((int) (size.x * proportion), WindowManager.LayoutParams.WRAP_CONTENT);
    }

    protected void resizeDialogSizeMax(){
        Window window = getDialog().getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
    }

}
