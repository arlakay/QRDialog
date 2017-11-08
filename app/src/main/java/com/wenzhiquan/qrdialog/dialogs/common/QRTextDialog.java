package com.wenzhiquan.qrdialog.dialogs.common;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenzhiquan.qrdialog.R;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by wenzhiquan on 17-8-23.
 */

public abstract class QRTextDialog extends QRExtendDialog {

    private static final String LOG_TAG = "SpreadsheetTextDialog";
    protected final static String TAG_LABEL = "label";
    protected TextView textView;


    @Override
    public void initComponents(Bundle savedInstanceState) {
        paramsJson = new JSONObject();
        try {
            paramsJson.put(TAG_VIEW, TAG_TEXT_VIEW);
        } catch (JSONException e) {
            Log.e(LOG_TAG, "initComponents: " + e);
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
    }
}
