package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class windialog extends Dialog {

    private final String message;
    private final MainActivity mainActivity;
    public windialog(@NonNull Context context,String message,MainActivity mainActivity) {
        super(context);
        this.message=message;
        this.mainActivity=mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.windialoglayout);

        final TextView messagetxt=findViewById(R.id.messagetxt);
        final Button startagainbtn=findViewById(R.id.startagainbutton);
        messagetxt.setText(message);

        startagainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.restartmatch();
                dismiss();
            }
        });
    }
}
