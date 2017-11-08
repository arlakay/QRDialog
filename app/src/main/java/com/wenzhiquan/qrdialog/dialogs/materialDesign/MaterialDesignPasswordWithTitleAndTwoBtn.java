package com.wenzhiquan.qrdialog.dialogs.materialDesign;

import android.os.Bundle;
import android.widget.Toast;

import com.wenzhiquan.qrdialog.R;
import com.wenzhiquan.qrdialog.dialogs.common.QRInputDialog;

import org.json.JSONException;

/**
 * Created by wenzhiquan on 17-11-8.
 */

public class MaterialDesignPasswordWithTitleAndTwoBtn extends QRInputDialog {
    @Override
    public void initComponents(Bundle savedInstanceState) {
        editType = INPUT_PPASSWORD;
        super.initComponents(savedInstanceState);
        try {
            paramsJson.put(TAG_TITLE, R.string.dialog_title);
            paramsJson.put(TAG_LABEL, R.string.dialog_password);
            paramsJson.put(TAG_POSITIVE_BUTTON, R.string.ok);
            paramsJson.put(TAG_POSITIVE_BUTTON_COLOR, getResolvedColor(R.color.dialogBlue));
            paramsJson.put(TAG_NEGATIVE_BUTTON, R.string.cancel);
            paramsJson.put(TAG_NEGATIVE_BUTTON_COLOR, getResolvedColor(R.color.dialogGrey));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bindListenerAndRecoverStatus(Bundle savedInstanceState) {
        setPositiveOnclickListener(dialog -> {
            dismiss();
            Toast.makeText(getActivity(), R.string.ok, Toast.LENGTH_SHORT).show();
        });
        setNegativeOnclickListener(dialog -> {
            dismiss();
            Toast.makeText(getActivity(), R.string.cancel, Toast.LENGTH_SHORT).show();
        });
    }
}
