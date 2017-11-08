package com.wenzhiquan.qrdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wenzhiquan.qrdialog.dialogs.MyDialog;

import java.util.ArrayList;
import java.util.List;

import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_INPUT_WITH_TITLE_TWO_BTN;
import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_NOTICE;
import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_NOTICE_WITH_TITLE;
import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_NOTICE_WITH_TITLE_THREE_BTN;
import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_NOTICE_WITH_TITLE_TWO_BTN;
import static com.wenzhiquan.qrdialog.dialogs.MyDialog.MATERIAL_DESIGN_PASSWORD_WITH_TITLE_TWO_BTN;

public class MainActivity extends AppCompatActivity {

    private List<MyDialog> dialogList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDialogs();
        RecyclerView recyclerView = findViewById(R.id.dialog_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DialogAdapter adapter = new DialogAdapter(dialogList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initDialogs() {
        if (dialogList == null) {
            dialogList = new ArrayList<>();
        }
        MyDialog myDialog = new MyDialog(MATERIAL_DESIGN_NOTICE);
        myDialog.setActivity(this);
        dialogList.add(myDialog);
        myDialog = new MyDialog(MATERIAL_DESIGN_NOTICE_WITH_TITLE);
        myDialog.setActivity(this);
        dialogList.add(myDialog);
        myDialog = new MyDialog(MATERIAL_DESIGN_NOTICE_WITH_TITLE_TWO_BTN);
        myDialog.setActivity(this);
        dialogList.add(myDialog);
        myDialog = new MyDialog(MATERIAL_DESIGN_NOTICE_WITH_TITLE_THREE_BTN);
        myDialog.setActivity(this);
        dialogList.add(myDialog);
        myDialog = new MyDialog(MATERIAL_DESIGN_INPUT_WITH_TITLE_TWO_BTN);
        myDialog.setActivity(this);
        dialogList.add(myDialog);
        myDialog = new MyDialog(MATERIAL_DESIGN_PASSWORD_WITH_TITLE_TWO_BTN);
        myDialog.setActivity(this);
        dialogList.add(myDialog);

    }
}
