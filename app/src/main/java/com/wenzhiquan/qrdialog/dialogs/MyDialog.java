package com.wenzhiquan.qrdialog.dialogs;

import android.util.Log;

import com.wenzhiquan.qrdialog.MainActivity;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignInputWithTitleAndTwoBtn;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignNotice;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignNoticeWithTitle;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignNoticeWithTitleAndThreeBtn;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignNoticeWithTitleAndTwoBtn;
import com.wenzhiquan.qrdialog.dialogs.materialDesign.MaterialDesignPasswordWithTitleAndTwoBtn;

/**
 * Created by wenzhiquan on 2017/11/7.
 */

public class MyDialog {
    private static final String TAG = "MyDialog";
    public static final String MATERIAL_DESIGN_NOTICE = "Material Design Notice";
    public static final String MATERIAL_DESIGN_NOTICE_WITH_TITLE = "Material Design Notice With Title";
    public static final String MATERIAL_DESIGN_NOTICE_WITH_TITLE_TWO_BTN = "Material Design Notice With Title And Two Btn";
    public static final String MATERIAL_DESIGN_NOTICE_WITH_TITLE_THREE_BTN = "Material Design Notice With Title And Three Btn";
    public static final String MATERIAL_DESIGN_INPUT_WITH_TITLE_TWO_BTN = "Material Design Input With Title And Two Btn";
    public static final String MATERIAL_DESIGN_PASSWORD_WITH_TITLE_TWO_BTN = "Material Design Password With Title And Two Btn";

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
            case MATERIAL_DESIGN_NOTICE_WITH_TITLE:
                MaterialDesignNoticeWithTitle materialDesignNoticeWithTitle = new MaterialDesignNoticeWithTitle();
                materialDesignNoticeWithTitle.show(activity);
                break;
            case MATERIAL_DESIGN_NOTICE_WITH_TITLE_TWO_BTN:
                MaterialDesignNoticeWithTitleAndTwoBtn materialDesignNoticeWithTitleAndTwoBtn = new MaterialDesignNoticeWithTitleAndTwoBtn();
                materialDesignNoticeWithTitleAndTwoBtn.show(activity);
                break;
            case MATERIAL_DESIGN_NOTICE_WITH_TITLE_THREE_BTN:
                MaterialDesignNoticeWithTitleAndThreeBtn materialDesignNoticeWithTitleAndThreeBtn = new MaterialDesignNoticeWithTitleAndThreeBtn();
                materialDesignNoticeWithTitleAndThreeBtn.show(activity);
                break;
            case MATERIAL_DESIGN_INPUT_WITH_TITLE_TWO_BTN:
                MaterialDesignInputWithTitleAndTwoBtn materialDesignInputWithTitleAndTwoBtn = new MaterialDesignInputWithTitleAndTwoBtn();
                materialDesignInputWithTitleAndTwoBtn.show(activity);
                break;
            case MATERIAL_DESIGN_PASSWORD_WITH_TITLE_TWO_BTN:
                MaterialDesignPasswordWithTitleAndTwoBtn materialDesignPasswordWithTitleAndTwoBtn = new MaterialDesignPasswordWithTitleAndTwoBtn();
                materialDesignPasswordWithTitleAndTwoBtn.show(activity);
                break;
        }
    }
}
