import java.util.Scanner;

public class calc {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Input A = ");
        float a = input.nextFloat();
        System.out.print("Input B = ");
        float b = input.nextFloat();
        System.out.print("Input Operator = ");
        String operator = input.next();
        input.close();

        switch (operator) {
            case "+":
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case "/":
                System.out.println(a + " / " + b + " = " + (a / b));
                break;
        }
   
    }
}
