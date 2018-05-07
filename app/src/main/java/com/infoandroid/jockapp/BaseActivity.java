package com.infoandroid.jockapp;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by mukesh kumar on 4/16/2018.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog mProgressDialog;


    public static void hideKeyboard(Context context, EditText editText) {
        InputMethodManager in = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public void startNextActivity(Bundle bundle, Class <? extends Activity> activityClass) {
        Intent i = new Intent(this, activityClass);
        if (null != bundle) {
            i.putExtras(bundle);
        }
        startActivity(i);
    }

    public void startNextActivity(Class <? extends Activity> activityClass) {
        Intent i = new Intent(this, activityClass);
        startActivity(i);
    }

    public void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    public void showProgressDialog(String bodyText, final boolean isRequestCancelable) {
        try {
            if (isFinishing()) {
                return;
            }
            if (mProgressDialog == null) {
                mProgressDialog = new ProgressDialog(BaseActivity.this);
                mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                // mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                mProgressDialog.setCancelable(isRequestCancelable);
                //mProgressDialog.setCanceledOnTouchOutside(false);
                mProgressDialog.setOnKeyListener(new Dialog.OnKeyListener() {
                    @Override
                    public boolean onKey(@NonNull DialogInterface dialog, int keyCode, KeyEvent event) {
                        if (keyCode == KeyEvent.KEYCODE_CAMERA || keyCode == KeyEvent.KEYCODE_SEARCH) {
                            return true; //
                        } else if (keyCode == KeyEvent.KEYCODE_BACK && isRequestCancelable) {
                            Log.e("Ondailogback", "cancel dailog");
                            // RequestManager.cancelRequest();
                            dialog.dismiss();
                            return true;
                        }
                        return false;
                    }
                });
            }
            mProgressDialog.setMessage(bodyText);

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
                //mProgressDialog.setContentView(new ProgressBar(this));
            }
        } catch (Exception e) {

        }
    }

    public void removeProgressDialog() {
        try {
            if (mProgressDialog != null && mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
        } catch (Exception e) {

        }
    }
}
