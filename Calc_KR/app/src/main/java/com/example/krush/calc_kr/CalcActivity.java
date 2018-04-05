package com.example.krush.calc_kr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;



public class CalcActivity extends AppCompatActivity {

    Button btn_sin,btn_cos,btn_tan,btn_log,btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_add, btn_sub, btn_mul, btn_div, btn_equals, btn_dp, btn_clr, btn_del, btn_mp, btn_mm, btn_mc, btn_mr, btn_percent, btn_sqrt;
    TextView tv_display, tv_opt;
    Double result, mem;
    char operator;
    Switch switch_scientific;
    LinearLayout layout_scientific;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calc);
        initialize();
        registerOnClick();

    }

    void initialize() {

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_equals = (Button) findViewById(R.id.btn_equals);
        btn_dp = (Button) findViewById(R.id.btn_decimal);
        btn_clr = (Button) findViewById(R.id.btn_clr);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_mp = (Button) findViewById(R.id.btn_mplus);
        btn_mm = (Button) findViewById(R.id.btn_mminus);
        btn_mc = (Button) findViewById(R.id.btn_mClear);
        btn_mr = (Button) findViewById(R.id.btn_mRecall);
        btn_percent = (Button) findViewById(R.id.btn_percent);
        btn_sqrt = (Button) findViewById(R.id.btn_sqrt);
        btn_sin = (Button)findViewById(R.id.btn_sin);
        btn_cos = (Button)findViewById(R.id.btn_cos);
        btn_tan = (Button)findViewById(R.id.btn_tan);
        btn_log = (Button)findViewById(R.id.btn_log);

        tv_display = (TextView) findViewById(R.id.tv_display);
        tv_opt = (TextView) findViewById(R.id.tv_opt);
        switch_scientific = (Switch)findViewById(R.id.switch_scientific);
        layout_scientific = (LinearLayout)findViewById(R.id.layout_scientific);
        switch_scientific.setChecked(false);
        layout_scientific.setVisibility(View.INVISIBLE);

        operator = '0';
        result = 0.0;
        mem = 0.0;

    }

    void registerOnClick() {

        switch_scientific.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked)
                {
                    layout_scientific.setVisibility(View.VISIBLE);
                }
                else
                {
                    layout_scientific.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append("9");
            }
        });

        btn_dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.append(".");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = 'a';
                tv_opt.setText("+");

                result = Double.valueOf(tv_display.getText().toString());
                tv_display.setText(null);
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = 's';
                tv_opt.setText("-");

                result = Double.valueOf(tv_display.getText().toString());
                tv_display.setText(null);
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = 'm';
                tv_opt.setText("x");

                result = Double.valueOf(tv_display.getText().toString());
                tv_display.setText(null);
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                operator = 'd';
                tv_opt.setText("÷");

                result = Double.valueOf(tv_display.getText().toString());
                tv_display.setText(null);
            }
        });

        btn_mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    mem += Double.valueOf(tv_display.getText().toString());
                    tv_opt.setText("M+");
                }
            }
        });

        btn_mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    mem -= Double.valueOf(tv_display.getText().toString());
                    tv_opt.setText("M-");
                }
            }
        });

        btn_mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_display.setText(mem.toString());
                tv_opt.setText("MRecall");
            }
        });

        btn_mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mem = 0.0;
                tv_opt.setText("MClear");
            }
        });

        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_display.setText(""+Double.valueOf(tv_display.getText().toString())/100.0);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_display.setText(""+Math.sqrt(Double.valueOf(tv_display.getText().toString())));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_opt.setText("sin");
                    tv_display.setText(""+Math.toRadians(Math.sin(Double.valueOf(tv_display.getText().toString()))));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_opt.setText("cos");
                    tv_display.setText(""+Math.toRadians(Math.cos(Double.valueOf(tv_display.getText().toString()))));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_opt.setText("tan");
                    tv_display.setText(""+Math.toRadians(Math.tan(Double.valueOf(tv_display.getText().toString()))));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!TextUtils.isEmpty(tv_display.getText().toString()))
                {
                    tv_opt.setText("log");
                    tv_display.setText(""+Math.log(Double.valueOf(tv_display.getText().toString())));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"No input value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (operator) {

                    case 'a':
                        tv_opt.setText(result.toString()+" + "+tv_display.getText().toString());
                        result += Double.valueOf(tv_display.getText().toString());
                        tv_display.setText(result.toString());
                        break;
                    case 's':
                        tv_opt.setText(result.toString()+" - "+tv_display.getText().toString());
                        result -= Double.valueOf(tv_display.getText().toString());
                        tv_display.setText(result.toString());
                        break;
                    case 'm':
                        tv_opt.setText(result.toString()+" x "+tv_display.getText().toString());
                        result *= Double.valueOf(tv_display.getText().toString());
                        tv_display.setText(result.toString());
                        break;
                    case 'd':
                        tv_opt.setText(result.toString()+" ÷ "+tv_display.getText().toString());
                        result /= Double.valueOf(tv_display.getText().toString());
                        tv_display.setText(result.toString());
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"Select an operation",Toast.LENGTH_SHORT).show();
                }
            }

        });

        btn_clr.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){

                tv_display.setText(null);
                tv_opt.setText(null);
                result = 0.0;
                operator = '0';
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View view){
                String display = tv_display.getText().toString();
                if (!TextUtils.isEmpty(display)) {
                    display = display.substring(0, display.length() - 1);
                    tv_display.setText(display);
                }
            }
        });


    }


}

