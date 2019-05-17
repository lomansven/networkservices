package com.nike.mysneakerapp.CompoundControls;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import com.nike.mysneakerapp.R;

public class AddDataView extends ConstraintLayout {

    private EditText name;
    private EditText date;
    private EditText details;

    public AddDataView(Context context) {
        super(context);
        init();
    }

    public AddDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AddDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.add_objectdata_layout, this);

        name = findViewById(R.id.etName);
        date = findViewById(R.id.etDate);
        details = findViewById(R.id.etDetails);
    }

    public void setHints(String[] strings) {
        name.setHint(strings[0]);
        date.setHint(strings[1]);
        details.setHint(strings[2]);
    }

    public void setTexts(String[] strings) {
        name.setText(strings[0]);
        date.setText(strings[1]);
        details.setText(strings[2]);
    }

    public String getName() {
        return name.getText().toString();
    }

    public String getDate() {
        return date.getText().toString();
    }

    public String getDetails() {
        return details.getText().toString();
    }

    public boolean isEmpty() {
        if(getName().equals("") || getDate().equals("") || getDetails().equals("")) {
            return true;
        } else {
            return false;
        }

    }

}


