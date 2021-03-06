package ru.drivermql.p0016;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "myLogs";
    LinearLayout llMain;
    RadioGroup rbGravity;
    EditText etName;
    Button btnCreate;
    Button dtnClear;
    Button btnNew;
    final int NEWID = 564654;
    int g;
    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //находим элементы
        llMain = (LinearLayout) findViewById(R.id.llMain);
        rbGravity = (RadioGroup) findViewById(R.id.rbGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        dtnClear = (Button) findViewById(R.id.btnClear);
        dtnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreate:
                //создание LayoutParams с шириной и высотой по содержимому
                LinearLayout.LayoutParams iParams = new LinearLayout.LayoutParams(wrapContent,wrapContent);
        //переменная для хранения значения выравнивания
        //по умолчанию будет LEFT
                int btnGravity = Gravity.LEFT;
                //определяем, какой RadioButton чекнут и заполняем
                //btnGravity
                switch (rbGravity.getCheckedRadioButtonId()){
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                //переносим полученное значение выравнивания в LinearLayout
                iParams.gravity = btnGravity;
                //создаем Button, пишем текст и добавляем в LinearLayout
                btnNew = new Button(this);
                btnNew.setId(NEWID+1);
                g = btnNew.getId();
                String s = Integer.toString(g);
                btnNew.setText(etName.getText()+ " " +s.toString());
                llMain.addView(btnNew,iParams);
                break;

                case R.id.btnClear:
                    llMain.removeAllViews();
                    Toast.makeText(this,"Удалено",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

