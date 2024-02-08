package com.example.calculator;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public boolean check = true;
    TextView editText;
    Button bC, bDel, b9, b8, b7, bAdd, b6, b5, b4, bSub, b3, b2, b1, bDiv,
            b0, bDot, bEqu, bMul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (TextView) findViewById(R.id.editText);
        bC = (Button) findViewById(R.id.b_c);
        bDel = (Button) findViewById(R.id.b_del);
        b9 = (Button) findViewById(R.id.b_9);
        b8 = (Button) findViewById(R.id.b_8);
        b7 = (Button) findViewById(R.id.b_7);
        bAdd = (Button) findViewById(R.id.b_add);
        b6 = (Button) findViewById(R.id.b_6);
        b5 = (Button) findViewById(R.id.b_5);
        b4 = (Button) findViewById(R.id.b_4);
        bSub = (Button) findViewById(R.id.b_sub);
        b3 = (Button) findViewById(R.id.b_3);
        b2 = (Button) findViewById(R.id.b_2);
        b1 = (Button) findViewById(R.id.b_1);
        bDiv = (Button) findViewById(R.id.b_div);
        b0 = (Button) findViewById(R.id.b_0);
        bDot = (Button) findViewById(R.id.b_dot);
        bEqu = (Button) findViewById(R.id.b_equ);
        bMul = (Button) findViewById(R.id.b_mul);


        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text.length() > 0) {
                    text = text.substring(0, text.length() - 1);
                    editText.setText(text);
                }

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "9");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "8");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "7");
            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validInputs();
                if (check) {
                    editText.setText(editText.getText().toString() + "+");
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "6");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "5");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "4");
            }
        });
        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validInputs();
                if (check) {
                    editText.setText(editText.getText().toString() + "-");
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "3");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "2");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "1");
            }
        });
        bDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validInputs();
                if (check) {
                    editText.setText(editText.getText().toString() + "/");
                }

            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + "0");
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validInputs();
                validDotInputs();
                if (check) {
                    editText.setText(editText.getText().toString() + ".");
                }

            }
        });
        bEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solution();
            }
        });
        bMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validInputs();
                if (check) {
                    editText.setText(editText.getText().toString() + "*");
                }

            }
        });


    }

    private void validDotInputs() {
        String allInputs = editText.getText().toString();
        String[] inputArray = allInputs.split("");
        for (int i = inputArray.length - 1; i > 0; i--) {
            if (Objects.equals(inputArray[i], "+")) {
                check = true;
                break;
            } else if (Objects.equals(inputArray[i], "-")) {
                check = true;
                break;
            } else if (Objects.equals(inputArray[i], "*")) {
                check = true;
                break;
            } else if (Objects.equals(inputArray[i], "/")) {
                check = true;
                break;
            } else if (Objects.equals(inputArray[i], ".")) {
                Toast.makeText(MainActivity.this,
                        "Invalid input", Toast.LENGTH_SHORT).show();
                check = false;
                break;
            }
        }

    }

    private void validInputs() {
        check = true;

        String allInputs = editText.getText().toString();
        if (allInputs.length() < 1) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        }

        String[] inputArray = allInputs.split("");
        String lastValue = inputArray[inputArray.length - 1];
        if (Objects.equals(lastValue, "+")) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        } else if (Objects.equals(lastValue, "-")) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        } else if (Objects.equals(lastValue, "/")) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        } else if (Objects.equals(lastValue, "*")) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        } else if (Objects.equals(lastValue, ".")) {
            Toast.makeText(MainActivity.this,
                    "Invalid input", Toast.LENGTH_LONG).show();
            check = false;
        }


    }

    private void solution() {
        String input = editText.getText().toString();

        List<String> tokens = new ArrayList<>();

        // Match numbers or operators
        Pattern pattern = Pattern.compile("\\d*\\.\\d+|\\d+|[-+*/]");



        java.util.regex.Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        //return tokens;
        //List<String> last = tokens;
       // System.out.println(tokens);
        String[] tokensArray = tokens.toArray(new String[0]);
       // System.out.println(tokensArray[1]);


        double result = solveExpression(tokensArray);
       // System.out.println("Result: " + result);
        editText.setText(Double.toString(result));

    }


    public static double solveExpression(String[] tokens) {
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                numbers.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                char currentOperator = token.charAt(0);

                while (!operators.isEmpty() && hasPrecedence(currentOperator, operators.peek().charAt(0))) {
                    double operand2 = numbers.pop();
                    double operand1 = numbers.pop();
                    String previousOperator = operators.pop();
                    double result = performOperation(operand1, operand2, previousOperator.charAt(0));
                    numbers.push(result);
                }

                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            double operand2 = numbers.pop();
            double operand1 = numbers.pop();
            String currentOperator = operators.pop();
            double result = performOperation(operand1, operand2, currentOperator.charAt(0));
            numbers.push(result);
        }

        return numbers.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        return (op2 == '*' || op2 == '/') && (op1 == '+' || op1 == '-');
    }

    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperator(String str) {
        return str.length() == 1 && "+-*/".contains(str);
    }

}