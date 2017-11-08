package com.wenzhiquan.qrdialog.dialogs.common;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.wenzhiquan.qrdialog.R;

import org.json.JSONObject;

/**
 * Created by wenzhiquan on 2017/11/7.
 */
public abstract class QRBaseDialog extends DialogFragment {

    private static final String ALERT_DIALOG_TAG = "Alert_Dialog_Tag";
    public static final String TAG_POSITIVE_BUTTON_COLOR = "positiveButtonColor";
    public static final String TAG_NEGATIVE_BUTTON_COLOR = "negativeButtonColor";
    public static final String TAG_NEUTRAL_BUTTON_COLOR = "neutralButtonColor";

    public static final String TAG_TITLE = "title";
    public static final String TAG_POSITIVE_BUTTON = "positiveButton";
    public static final String TAG_NEGATIVE_BUTTON = "negativeButton";
    public static final String TAG_NEUTRAL_BUTTON = "neutralButton";
    public static final String TAG_IS_CANCELABLE = "canCancel";
    public static final String TAG_AUTO_DISMISS = "autoDismiss";

    protected JSONObject paramsJson;
    protected AlertDialog.Builder builder;

    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;
    private View.OnClickListener positiveListener;
    private View.OnClickListener negativeListener;
    private View.OnClickListener neutralListener;
    private boolean canCancel;
    private boolean autoDismiss;
    private AlertDialog dialog;

    /**
     * This function is used to create the components of dialog,
     * such as title, buttons and so on.
     */
    public abstract void initComponents(Bundle savedInstanceState);

    /**
     * This function is used to bind listeners to buttons
     */
    public abstract void bindListenerAndRecoverStatus(Bundle savedInstanceState);

    /**
     * This function will create the AlertDialog.Builder according to paramsJson.
     */
    public void initDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getContext(), R.style.BlueButtonAlertDialog);
        int titleId = paramsJson.optInt(TAG_TITLE);
        if (titleId != 0) {
            builder.setTitle(titleId);
        }

        boolean canCancel = paramsJson.optBoolean(TAG_IS_CANCELABLE);
        boolean autoDismiss = paramsJson.optBoolean(TAG_AUTO_DISMISS);

        int positiveButtonId = paramsJson.optInt(TAG_POSITIVE_BUTTON);
        int negativeButtonId = paramsJson.optInt(TAG_NEGATIVE_BUTTON);
        int neutralButtonId = paramsJson.optInt(TAG_NEUTRAL_BUTTON);

        if (positiveButtonId != 0) {
            builder.setPositiveButton(getResourceString(positiveButtonId), null);
        }
        if (negativeButtonId != 0) {
            builder.setNegativeButton(getResourceString(negativeButtonId), null);
        }
        if (neutralButtonId != 0) {
            builder.setNeutralButton(getResourceString(neutralButtonId), null);
        }
    }

    public void show(@NonNull FragmentActivity activity) {
        show(activity.getSupportFragmentManager(), ALERT_DIALOG_TAG);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setCancelable(canCancel);
        initComponents(savedInstanceState);
        initDialog(savedInstanceState);
        dialog = builder.create();

        if (showKeyBoard() && dialog.getWindow() != null) {
            dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }

        rewriteShowListener(dialog, savedInstanceState);

        return dialog;
    }

    private void rewriteShowListener(AlertDialog dialog, Bundle savedInstanceState) {
        dialog.setOnShowListener(tmpDialog -> {
            if (dialog.getButton(AlertDialog.BUTTON_POSITIVE) != null) {
                positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            }
            if (dialog.getButton(AlertDialog.BUTTON_NEGATIVE) != null) {
                negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            }
            if (dialog.getButton(AlertDialog.BUTTON_NEUTRAL) != null) {
                neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
            }
            bindListenerAndRecoverStatus(savedInstanceState);
            if (null != negativeListener) {
                setNegativeButton(dialog);
            }
            if (null != positiveListener) {
                setPositiveButton(dialog);
            }
            if (null != neutralListener) {
                setNeutralButton(dialog);
            }
        });
    }

    public void setPositiveButton(AlertDialog dialog) {
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if (positiveButton != null && positiveListener != null) {
            positiveButton.setOnClickListener(positiveListener);
        }
        int positiveColorId = paramsJson.optInt(TAG_POSITIVE_BUTTON_COLOR);
        if (positiveColorId != 0) {
            positiveButton.setTextColor(positiveColorId);
        }
    }

    public void setNegativeButton(AlertDialog dialog) {
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        if (negativeButton != null && negativeListener != null) {
            negativeButton.setOnClickListener(negativeListener);
        }
        int negativeColorId = paramsJson.optInt(TAG_NEGATIVE_BUTTON_COLOR);
        if (negativeColorId != 0) {
            negativeButton.setTextColor(negativeColorId);
        }
    }

    public void setNeutralButton(AlertDialog dialog) {
        Button neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        if (neutralButton != null && neutralListener != null) {
            neutralButton.setOnClickListener(neutralListener);
        }
        int neutralColorId = paramsJson.optInt(TAG_NEUTRAL_BUTTON_COLOR);
        if (neutralColorId != 0) {
            neutralButton.setTextColor(neutralColorId);
        }
    }

    public void setPositiveOnclickListener(View.OnClickListener listener) {
        this.positiveListener = listener;
    }

    public void setNegativeOnclickListener(View.OnClickListener listener) {
        this.negativeListener = listener;
    }

    public void setNeutralOnclickListener(View.OnClickListener listener) {
        this.neutralListener = listener;
    }

    public boolean showKeyBoard() {
        return false;
    }

    /**
     * This function transfer the string resource to string characters
     *
     * @param stringId
     * @return
     */
    public String getResourceString(@StringRes int stringId) {
        return getResources().getString(stringId);
    }

    public int getResolvedColor(int color) {
        return ContextCompat.getColor(getContext(), color);
    }

    public Button getPositiveButton() {
        return positiveButton;
    }

    public Button getNegativeButton() {
        return negativeButton;
    }

    public Button getNeutralButton() {
        return neutralButton;
    }
}
