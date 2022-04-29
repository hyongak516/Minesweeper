package com.example.minesweeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Copyright (c) 2022 by Hosung.Kim <hyongak516@mail.hongik.ac.kr>
 *
 * Minesweeper
 *
 * AppName   : 지뢰남윤배찾기 (Temp)
 * Language  : Java
 * Tool      : Android Studio
 * Developer : Hosung.Kim, Seongha.Jeon
 * Github    : https://github.com/hyongak516/Minesweeper
 */

public class MainActivity extends AppCompatActivity {
    private Button mGameStartButton;
    private Button mShutDownButton;

    private Dialog mDiffDialog;

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGameStartButton = findViewById(R.id.gamestartbtn);
        mShutDownButton = findViewById(R.id.shutdownbtn);

        mGameStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDiffDialog = new Dialog(MainActivity.this);
                mDiffDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                mDiffDialog.setContentView(R.layout.difficulty_setting);
                mDiffDialog.show();
                Button mBeginnerBtn = mDiffDialog.findViewById(R.id.biginnerbtn);
                Button mIntermediateBtn = mDiffDialog.findViewById(R.id.intermediatebtn);
                Button mAdvancedBtn = mDiffDialog.findViewById(R.id.advancedbtn);
                mBeginnerBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("mode", 0);
                        getBaseContext().startActivity(intent);
                    }
                });
                mIntermediateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("mode", 1);
                        getBaseContext().startActivity(intent);
                    }
                });
                mAdvancedBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("mode", 2);
                        getBaseContext().startActivity(intent);
                    }
                });
            }
        });
        mShutDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameShutDlg();
            }
        });
    }
    void GameShutDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("게임 종료");
        builder.setMessage("Tetris 게임을 종료하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.show();
    }
}