package oop.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout mainLayout;

    String[] volumes = { "куб", "паралелограмм", "сфера" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner volumesSpinner = findViewById(R.id.volumes_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, volumes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumesSpinner.setAdapter(adapter);

        chooseVolumes(volumesSpinner);
    }

    private void chooseVolumes(Spinner volumesSpinner) {
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)parent.getItemAtPosition(position);
                createField(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        volumesSpinner.setOnItemSelectedListener(itemSelectedListener);
    }

    private void createField(String item) {
        mainLayout = findViewById(R.id.main_layout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        mainLayout.removeAllViews();
        switch(item) {
            case "куб":
                EditText cubeSquare = new EditText(this);
                mainLayout.addView(cubeSquare, layoutParams);
                break;
            case "паралелограмм":

                break;
        }
    }
}