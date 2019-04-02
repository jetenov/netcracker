package ru.skillbench.tasks.basics.control;



public class ControlFlowStatements1Impl implements ControlFlowStatements1 {


    @Override
    public float getFunctionValue(float x) {
        float f;
        if (x > 0) f = (float) (2 * Math.sin(x));
        else f = 6 - x;
        return f;
    }

    @Override
    public String decodeWeekday(int weekday) {
        String s = null;
        switch (weekday) {
            case 1: s = "Monday";
                break;
            case 2: s = "Tuesday";
                break;
            case 3: s = "Wednesday";
                break;
            case 4: s = "Thursday";
                break;
            case 5: s = "Friday";
                break;
            case 6: s = "Saturday";
                break;
            case 7: s = "Sunday";
                break;

        }
        return s;
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                array[i][j] = i * j;
            }

        }
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) min = array[i][j];
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        double amount = 1000;
        int year = 0;
        while (amount < 5000) {
            amount = amount + (P / 100) * amount;
            year++;
        }
        BankDeposit bankDeposit = new BankDeposit();
        bankDeposit.amount = amount;
        bankDeposit.years = year;

        return bankDeposit;
    }
}
