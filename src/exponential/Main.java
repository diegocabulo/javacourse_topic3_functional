package exponential;
import java.text.*;

public class Main {

    // Recursive Function with static
    // variables power and factorial
    static double power = 1;
    static double factorial = 1;
    static double exponentialFunction(double x, int numberOfSums)
    {
        double recursiveCall;
        // Termination condition
        if (numberOfSums == 0)
            return 1;
        // Recursive call
        recursiveCall = exponentialFunction(x, numberOfSums - 1);
        // Update the power of x
        power = power * x;
        // Factorial
        factorial = factorial * numberOfSums;
        return (recursiveCall + power / factorial);
    }

    // Driver code
    public static void main(String[] args)
    {
        double x = 5;
        int numberOfSums = 15;
        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(exponentialFunction(x, numberOfSums)));
    }
}

// Se utiliza una funcion recursiva para iterar para cada uno de los terminos siendo x= la potencia a la cual se desea
// conocer el valor y number of sums es igual a la precision que se desea tomar a mayor iteraciones el valor es mas exacto

