/*
 * Copyright 2021. Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 package com.huawei.apms.demo;

import android.os.Bundle;
import com.huawei.agconnect.apms.APMS;
import com.huawei.agconnect.apms.androiddemo.R;
import com.huawei.agconnect.apms.custom.CustomTrace;
import com.huawei.agconnect.apms.instrument.AddCustomTrace;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button triggeranrBtn = findViewById(R.id.anr_test);
        triggeranrBtn.setOnClickListener(v -> {
            Log.d("apmsAndroidDemo", "trigger ANR");
            anrTestEnable = true;
        });

    }


    private boolean anrTestEnable = false;
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (anrTestEnable) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (anrTestEnable) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.dispatchTouchEvent(ev);
    }


}