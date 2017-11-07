package com.wenzhiquan.qrdialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wenzhiquan on 2017/11/7.
 */

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {
    private List<MyDialog> myDialogList;

    public class DialogViewHolder extends RecyclerView.ViewHolder {
        TextView dialogTextView;

        public DialogViewHolder(View view) {
            super(view);
            dialogTextView = view.findViewById(R.id.dialog_item);
        }
    }

    public DialogAdapter(List<MyDialog> dialogList) {
        this.myDialogList = dialogList;
    }

    @Override
    public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_item, parent, false);
        DialogViewHolder viewHolder = new DialogViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DialogViewHolder holder, int position) {
        MyDialog dialog = myDialogList.get(position);
        holder.dialogTextView.setText(dialog.getName());
    }

    @Override
    public int getItemCount() {
        return myDialogList.size();
    }
}
