package com.example.tubes01;

public class ModelCalculator {
    static char operator;
    static int number;
    static int result;

    public ModelCalculator() {
        this.operator = '@';
        this.number = 0;
        this.result = 0;
    }

    public void calculate() {
        if(this.operator == '+') {
            this.result += this.number;
        }
        else if(this.operator == '-') {
            this.result -= this.number;
        }
        else if(this.operator == '*') {
            this.result *= this.number;
        }
        else if(this.operator == '/') {
            this.result /= this.number;
        }
    }
}
