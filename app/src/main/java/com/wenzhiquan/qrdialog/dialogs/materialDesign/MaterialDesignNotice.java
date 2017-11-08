package com.wenzhiquan.qrdialog.dialogs.materialDesign;

import android.os.Bundle;

import com.wenzhiquan.qrdialog.dialogs.common.QRTextDialog;
import com.wenzhiquan.qrdialog.R;

import org.json.JSONException;

/**
 * Created by wenzhiquan on 17-11-8.
 */

public class MaterialDesignNotice extends QRTextDialog {
    @Override
    public void initComponents(Bundle savedInstanceState) {
        super.initComponents(savedInstanceState);
        try {
            paramsJson.put(TAG_LABEL, R.string.dialog_notice);
            paramsJson.put(TAG_POSITIVE_BUTTON, R.string.ok);
            paramsJson.put(TAG_POSITIVE_BUTTON_COLOR, getResolvedColor(R.color.dialog_blue));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bindListenerAndRecoverStatus(Bundle savedInstanceState) {
        setPositiveOnclickListener((dialog) -> dismiss());
    }
}
