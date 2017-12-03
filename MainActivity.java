package ru.drivermql.p0016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.Gravity.CENTER_HORIZONTAL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //создание LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        //установим вертикальную ориентацию
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        //Создаем LayoutParams
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        //устанавливаем linearLayout как корневой элемент экрана
        setContentView(linearLayout,layoutParams);

        LinearLayoutCompat.LayoutParams ipView = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ipView.gravity= CENTER_HORIZONTAL;
        TextView textView = new TextView(this);
        textView.setText("TextView");
        textView.setLayoutParams(ipView);
        linearLayout.addView(textView);



        Button button = new Button(this);
        button.setText("Button");
        linearLayout.addView(button,ipView);

        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;
    }
}
