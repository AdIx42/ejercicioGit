import java.util.Scanner;
 
public class Calculadora{
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double res = 0;
        String operacion;
        boolean comprobar = false;
 
        do{
            //Verification of the data entered by user number one.
            /* With matches, there are one condition that the digits can be put by the user, 
			in the conditional we have the first than only accept the characters '+' and '-', but with the condition that can be only one time or never. After we only admit the number 0 to 9 and put 0 one time or many times, in fact, put something or put nothing. Another condition that only accept the character '.' once or never. next the pont, if put, it's admit whatever number 0 or 9 once or many times.*/
            String numero1;
            do {
                System.out.println("\n Por favor, dame el primer número de la operación. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);
            // End of the verification of data entered by the user number 1.
 
            do {
                System.out.println("\n ¿Que operación desea hacer? (Solo coloque un signo)");
                System.out.println("Teniendo en cuenta que: \n + = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer número al segundo numero."
                        + "\n % = residuo");
            operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x") ||
                    operacion.equals("X") || operacion.equals("/") || operacion.equals("%") ||
                    operacion.equals("*")) {
                    comprobar = true;
                }else { comprobar = false; }
            } while (comprobar != true);
 
            // Verification of data entered by the user number 2.
            String numero2;
            do {
                System.out.println("\n Por favor, dame el segundo número.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);
            // End of the verification of data entered by the user number 2.
 
            do{
                comprobar = true;
                switch(operacion){
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "x":
                    case "X":
                        res = n1 * n2;
                        break;
                    case "/":
                        /* For avoid errors or complex numbers, if the user put 0 as second number, it's asume denominator is 0, and because of that I put one conditional to verify it, to make the code more dynamic and not only add a 1, I ask again to the use that enter another number, the user can put again 0, thats the razon of the loop in the code, while n2 be 0, the code will be continue asking for another number. */
                        while(n2 == 0){
                                 do {
                                    System.err.println(" En el denominador se encuentra \n"
                                            + "un cero, para evitar errores coloca otro número.");
                                    numero2 = sc.nextLine();
                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                                    nume2 = Double.parseDouble(numero2);
                                    n2 = new Double(numero2);
                        }
                        res = n1 / n2;
                        break;
                    case "*":
                        res = Math.pow(n1, n2);
                        break;
                    case "%":
                        while(n2 == 0){
                                 do {
                                    System.err.println(" En el denominador se encuentra \n"
                                            + "un cero, para evitar errores coloca otro número.");
                                    numero2 = sc.nextLine();
                                }while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                                    nume2 = Double.parseDouble(numero2);
                                    n2 = new Double(numero2);
                        }
                        res = n1 % n2;
                        break;
                }
            }while(comprobar != true);
 
            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\n ¿Desea hacer alguna otra operación? \n");
            System.out.println(" [s/n]");
            do{
                comprobar = true;
                operacion = sc.nextLine();
 
                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\n Error, ponga un literal valido. \n");
                        comprobar = false;
                }
            }while(comprobar != true);
        }while(operacion.equals("s") || operacion.equals("S"));
  }
}
