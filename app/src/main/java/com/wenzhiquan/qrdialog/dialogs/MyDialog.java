package com.wenzhiquan.qrdialog.dialogs;

import android.util.Log;

import com.wenzhiquan.qrdialog.MainActivity;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignNotice;

/**
 * Created by wenzhiquan on 2017/11/7.
 */

public class MyDialog {
    private static final String TAG = "MyDialog";
    public static final String MATERIAL_DESIGN_NOTICE = "Material Design Notice";
    private MainActivity activity;

    private String name;

    public MyDialog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public void showDialog() {
        Log.d(TAG, "showDialog: ");
        switch (this.name) {
            case MATERIAL_DESIGN_NOTICE:
                MaterialDesignNotice materialDesignNotice = new MaterialDesignNotice();
                materialDesignNotice.show(activity);
                break;
        }
    }
}
