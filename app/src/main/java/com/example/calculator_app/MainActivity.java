package com.example.calculator_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btn_addition, btn_division,
            btn_result, btn_dec, btn_subtraction, btn_multiplication, btn_backspace,
            btn_clear, btn_percentage;

    TextView screen_view;
    TextView result_view;

    ImageView toggle;

    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DraculaTheme);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_addition = findViewById(R.id.btn_addition);
        btn_backspace = findViewById(R.id.btn_backspace);
        btn_clear = findViewById(R.id.btn_clear);
        btn_dec = findViewById(R.id.btn_dec);
        btn_division = findViewById(R.id.btn_division);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_result = findViewById(R.id.btn_result);
        btn_subtraction = findViewById(R.id.btn_subtraction);
        btn_percentage = findViewById(R.id.btn_percentage);

        screen_view = findViewById(R.id.screen_view);
        result_view = findViewById(R.id.result_view);
        toggle = findViewById(R.id.toggle);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // attached listener to ImageView in order to change between light and dark themes and change images accordingly
                toggle.setActivated(!toggle.isActivated());
                if (toggle.isActivated()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restart();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restart();
                }
            }
        });

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            toggle.setActivated(true);
        }

        btn0.setOnClickListener(new View.OnClickListener() { //added click listener, so that on button click it will be displayed in screen_view TextView
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "0");
                    result_view.setText(calculate(screen_view.getText().toString())); //to display intermediate result
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "1");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "2");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "3");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "4");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "5");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "6");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){//to avoid situations like "56%6"
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "7");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "8");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "9");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                screen_view.setText("");
                result_view.setText("");
            }
        });

        btn_backspace.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (screen_view.length() < 2){
                    screen_view.setText("");
                    result_view.setText("");
                }
                else {
                    screen_view.setText(screen_view.getText().subSequence(0,screen_view.getText().length() - 1));
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
                }
        });

        btn_percentage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){
                    screen_view.setText("");
                }
                else if (check_last_char(screen_view.getText().toString())){//to avoid situation like "2+%"
                    screen_view.setText(screen_view.getText());
                }
                else if(percentage_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "%");
                    result_view.setText(calculate(screen_view.getText().toString()));
                }
            }
        });

        btn_division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){ //to check if nothing is typed into screen view
                    screen_view.setText("");
                }
                else if(check_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "/");
                }
            }
        });

        btn_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){
                    screen_view.setText("");
                }
                else if(check_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "×");
                }
            }
        });

        btn_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){
                    screen_view.setText("");
                }
                else if(check_last_char(screen_view.getText().toString())) {
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "-");
                }
            }
        });

        btn_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){
                    screen_view.setText("");
                }
                else if(check_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else {
                    screen_view.setText(screen_view.getText() + "+");
                }
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){
                    screen_view.setText("0.");
                }
                else if(check_last_char(screen_view.getText().toString())){
                    screen_view.setText(screen_view.getText());
                }
                else{
                    screen_view.setText(screen_view.getText() + ".");
                }
                result_view.setText(calculate(screen_view.getText().toString()));
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen_view.length() == 0){//to check if nothing was typed into screen view
                    result_view.setText("");
                }
                else{
                    screen_view.setText(calculate(screen_view.getText().toString()));
                    result_view.setText("");
                }
            }
        });
    }

    String calculate(String math_expression) {
        if (math_expression.endsWith("×") //because if string ends with x,-,+,/ it will crash calculation methods
                || math_expression.endsWith("/")
                || math_expression.endsWith("-")
                || math_expression.endsWith("+")){
            math_expression = math_expression.substring(0, math_expression.length() - 1);
        }

        String replace = math_expression.replace("×", "*");// had to replace 'x' with '*' so that regex works
        List<String> math_list = new ArrayList<>();
        /*to separate string into array list of format "number, operator, number", so that it is possible to make further calculations*/
        Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\%\\*/\\(\\)]))");
        Matcher m = pattern.matcher(replace);
        while(m.find()) {
            math_list.add(m.group());
        }
        if (math_list.size() >= 2){ // had to check if calculation starts with percentage, and calculate it, so that further calculation is correct
            if (math_list.get(1).contains("%")){
                result = Double.parseDouble(math_list.get(0)) / 100;
                math_list.set(1, result + "");
                math_list = math_list.subList(1, math_list.size());
            }
        }
        /*because there is a possibility that calculation will start with negative number had to check if first element of list contains "-",
         * and if it is true, then will add "-" to second element, to make a negative number*/
        if (math_list.size() > 1){
            if (math_list.get(0).contains("-")){
                math_list.set(1, "-" + math_list.get(1));
                math_list = math_list.subList(1, math_list.size());
            }
        }
        DecimalFormat format = new DecimalFormat("#.##"); //created new format object to use it for rounding up the final number, so it doesn't have a lot of decimals after
        calculate_mult_div(math_list);
        if (math_list.size() == 1){//if it was only multiplication and division there is no need to call method to calculate addition and subtraction and result will be returned
            return math_list.get(0);
        }
        else if (math_list.size() == 2 && math_list.get(0).contains("-")){
            return math_list.toString();
        }
        result = 0;
        return format.format(calculate_add_sub(math_list));//using format in order to round up the result string
    }

    List<String> calculate_mult_div(List<String> input){
            for(int i = 0; i < input.size(); i++) { //need to loop through input list to check if it contains * or /
                if (input.get(i).contains("*") || input.get(i).contains("/")) {
                    List<String> left = new ArrayList<>(input.subList(0, i -1));/*in order to separate numbers, that need to be multiplied
                    or divided, I divide list into left list(before) and right list (after) number pair and operator between them */
                    List<String> right = new ArrayList<>(input.subList(i + 2, input.size()));
                    if (right.size() != 0){
                        if (right.get(0).contains("%")){/*before making calculation had to check if the number is followed by % sign, if yes,
                                                        the percentage result should be count first*/
                            result = Double.parseDouble(input.get(i + 1)) / 100;
                            input.set(i + 1, result + "");
                            right = right.subList(1, right.size());
                        }
                    }
                    if (input.get(i - 1).contains("%")){// to avoid situation %/number, or %*number, because it will crash app
                        result = Double.parseDouble(left.get(left.size() - 1)) / 100;
                        input.set(i - 1, result + "");
                        left = left.subList(0, left.size() - 1);
                    }
                    //here I checked input element contains * or / operator, so that correct calculation is made
                    if (input.get(i).contains("*")) {
                        result = Double.parseDouble(input.get(i - 1)) * Double.parseDouble(input.get(i + 1));
                    }
                    if (input.get(i).contains("/")) {
                        result = Double.parseDouble(input.get(i - 1)) / Double.parseDouble(input.get(i + 1));
                    }

                    DecimalFormat format = new DecimalFormat("#.###");
                    input.clear();//because there will be new elements in input list, had to clear it first
                    input.addAll(left);//to remain correct order first left list should be added
                    input.add(format.format(result));//then add the result of multiplication or division performed
                    input.addAll(right);//and after that right list
                    calculate_mult_div(input);//had to recursively call same method to check if there is more multiplication or division operations
                }
            }
        return input;
    }

    double calculate_add_sub(List<String> input) {
        if (input.contains("-") || input.contains("+")) {
            for (int i = 0; i < input.size(); i++) {
                /*here I also had to divide list into right sublist in order to separate number pair and operator*/
                List<String> right = new ArrayList<>(input.subList(i + 3, input.size()));
                if (right.size() != 0){
                    //check for percentage sign, because additional calculations should be done, first to calculate percentage number
                    if (right.get(0).contains("%")){
                        result = Double.parseDouble(input.get(i)) / 100 * Double.parseDouble(input.get(i + 2));
                        input.set(i + 2, result + "");
                        right = right.subList(1, right.size());
                    }
                }
                if (input.get(i + 1).contains("+")) {
                    result = Double.parseDouble(input.get(i)) + Double.parseDouble(input.get(i + 2));
                }
                if (input.get(i + 1).contains("-")) {
                    result = Double.parseDouble(input.get(i)) - Double.parseDouble(input.get(i + 2));
                }
                input.clear();
                input.add(result + "");
                input.addAll(right);
                calculate_add_sub(input);//again had to check if there are more addition or subtraction operations
            }
        }
        return result;
    }

    boolean check_last_char(String expression){// in order to limit amount of operators, to avoid situations like 2+-/2, that will crash app
        if(expression.endsWith("-")
                || expression.endsWith("+")
                || expression.endsWith("×")
                || expression.endsWith("/")
                || expression.endsWith(".")){
            return true;
        }
        return false;
    }

    boolean percentage_last_char(String expression){
        if (expression.endsWith("%")){
            return true;
        }
        else return false;
    }

    public void restart(){//in order to switch to dracula mode one need to restart activity
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
