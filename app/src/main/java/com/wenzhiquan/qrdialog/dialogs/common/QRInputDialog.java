package com.wenzhiquan.qrdialog.dialogs.common;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wenzhiquan.qrdialog.R;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by wenzhiquan on 17-8-23.
 */

public abstract class QRInputDialog extends QRExtendDialog {

    private static final String TAG = "InputDialog";
    protected static final int INPUT_NORMAL = 0;
    protected static final int INPUT_PPASSWORD = 1;
    protected final static String TAG_LABEL = "label";
    protected TextView textView;
    protected EditText editText;
    protected int editType = 0;


    @Override
    public void initComponents(Bundle savedInstanceState) {
        paramsJson = new JSONObject();
        try {
            if (editType == INPUT_NORMAL) {
                paramsJson.put(TAG_VIEW, TAG_EDIT_TEXT_VIEW);
            } else if (editType == INPUT_PPASSWORD) {
                paramsJson.put(TAG_VIEW, TAG_PASSWORD_VIEW);
            }
        } catch (JSONException e) {
            Log.e(TAG, "initComponents: " + e);
        }
    }

    @Override
    public void initDialog(Bundle savedInstanceState) {
        super.initDialog(savedInstanceState);
        int viewId = paramsJson.optInt(TAG_VIEW);
        int labelId = paramsJson.optInt(TAG_LABEL);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final ViewGroup nullParent = null;
        View dialogView = inflater.inflate(viewId, nullParent);
        builder.setView(dialogView);

        textView = dialogView.findViewById(R.id.alert_input_label);
        if (textView != null) {
            textView.setText(labelId == 0 ? "" : getResourceString(labelId));
        }
        if (editType == INPUT_NORMAL) {
            editText = dialogView.findViewById(R.id.alert_input);
        } else if (editType == INPUT_PPASSWORD) {
            editText = dialogView.findViewById(R.id.alert_input_password);
        }
    }
}
