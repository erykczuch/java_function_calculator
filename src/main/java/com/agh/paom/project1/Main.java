package com.agh.paom.project1;

import com.agh.paom.project1.function.ExponentialFunction;
import com.agh.paom.project1.function.LinearFunction;
import com.agh.paom.project1.function.QuadraticFunction;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        boolean runProgram = true;

        while(runProgram) {
            try {
                System.out.println("1 - Linear    2 - Quadratic   3 - Exponential    0 - Exit ");
                int choice = scanner.nextInt();

                while (choice != 1 && choice != 2 && choice != 3 && choice != 0) {
                    System.out.println("Invalid choice. Please enter a valid option");
                    System.out.println("1 - Linear    2 - Quadratic   3 - Exponential    0 - Exit ");
                    choice = scanner.nextInt();
                }

                switch (choice) {
                    case 1: {
                        System.out.print("a: ");
                        double a = scanner.nextDouble();

                        System.out.print("b: ");
                        double b = scanner.nextDouble();
                        LinearFunction linearFunction = new LinearFunction(a, b);

                        System.out.print("Interval start: ");
                        double intervalStart = scanner.nextDouble();

                        System.out.print("Interval end: ");
                        double intervalEnd= scanner.nextDouble();

                        System.out.print("Step: ");
                        double step = scanner.nextDouble();

                        FunctionOnInterval linearFunctionOnInterval = new FunctionOnInterval(linearFunction, intervalStart, intervalEnd, step);

                        System.out.print("\n");
                        linearFunctionOnInterval.print();

                        System.out.print("\n");
                        break;
                    }

                    case 2: {
                        System.out.print("a: ");
                        double a = scanner.nextDouble();

                        System.out.print("b: ");
                        double b = scanner.nextDouble();

                        System.out.print("c: ");
                        double c = scanner.nextDouble();
                        QuadraticFunction quadraticFunction = new QuadraticFunction(a, b, c);

                        System.out.print("Interval start: ");
                        double intervalStart = scanner.nextDouble();

                        System.out.print("Interval end: ");
                        double intervalEnd= scanner.nextDouble();

                        System.out.print("Step: ");
                        double step = scanner.nextDouble();

                        FunctionOnInterval quadraticFunctionOnInterval = new FunctionOnInterval(quadraticFunction, intervalStart, intervalEnd, step);

                        System.out.print("\n");
                        quadraticFunctionOnInterval.print();

                        System.out.print("\n");
                        break;
                    }

                    case 3: {
                        System.out.print("a: ");
                        double a = scanner.nextDouble();

                        System.out.print("b: ");
                        double b = scanner.nextDouble();

                        ExponentialFunction exponentialFunction = new ExponentialFunction(a, b);

                        System.out.print("Interval start: ");
                        double intervalStart = scanner.nextDouble();

                        System.out.print("Interval end: ");
                        double intervalEnd= scanner.nextDouble();

                        System.out.print("Step: ");
                        double step = scanner.nextDouble();

                        FunctionOnInterval exponentialFunctionOnInterval = new FunctionOnInterval(exponentialFunction, intervalStart, intervalEnd, step);

                        System.out.print("\n");
                        exponentialFunctionOnInterval.print();

                        System.out.print("\n");
                        break;
                    }

                    case 0: {
                        System.out.println("Exiting program.");
                        runProgram = false;
                        break;
                    }
                }
            } catch (IllegalArgumentException exception) {
                System.out.println("Invalid input: " + exception.getMessage() + "\n");
            } catch (InputMismatchException _) {
                System.out.println("Invalid input: please enter a number\n");
                scanner.nextLine();
            }
        }
    }
}
