package com.wenzhiquan.qrdialog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenzhiquan.qrdialog.dialogs.MyDialog;

import java.util.List;

/**
 * Created by wenzhiquan on 2017/11/7.
 */

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogViewHolder> {
    private List<MyDialog> myDialogList;

    public class DialogViewHolder extends RecyclerView.ViewHolder {
        View dialogView;
        TextView dialogTextView;

        public DialogViewHolder(View view) {
            super(view);
            dialogView = view;
            dialogTextView = view.findViewById(R.id.dialog_item);
        }
    }

    public DialogAdapter(List<MyDialog> dialogList) {
        this.myDialogList = dialogList;
    }

    @Override
    public DialogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_item, parent, false);
        final DialogViewHolder viewHolder = new DialogViewHolder(view);
        viewHolder.dialogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                MyDialog myDialog = myDialogList.get(position);
                myDialog.showDialog();
            }
        });
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
