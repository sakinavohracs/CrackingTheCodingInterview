package Moderate;

public class NumberSwapper {

    public static void main(String[] args) {
        int[] values = new int[2];
        values = swapNumber(3,4);
        System.out.println(values[0] + " " + values[1]);
        values = swapNumber(values[0],values[1]);
        System.out.println(values[0] + " " + values[1]);

    }

    public static int[] swapNumber(int num1, int num2){



        num2 = num1 + num2;
        num1 = num2 - num1;
        num2 = num2 - num1;

        return new int[]{num1, num2};

    }
}
