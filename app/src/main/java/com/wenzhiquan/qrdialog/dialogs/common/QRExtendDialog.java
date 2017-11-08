package com.wenzhiquan.qrdialog.dialogs.common;

import com.wenzhiquan.qrdialog.R;

/**
 * Created by wenzhiquan on 17-8-3.
 */

public abstract class QRExtendDialog extends QRBaseDialog {

    public final static String TAG_VIEW = "view";

    // Different views of alert dialog view, which is located between title and buttons.
    public final static int TAG_PASSWORD_VIEW = R.layout.alert_label_input_password;
    public final static int TAG_EDIT_TEXT_VIEW = R.layout.alert_label_input;
    public final static int TAG_TEXT_VIEW = R.layout.alert_label;
}
