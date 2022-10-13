//Vittoria Presa

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);

        System.out.println("Insira os dois parâmetros respeitando o espaço entre eles.");
        
        String parametros = in.nextLine();

        KaratsubaMortal karatsubamortal = new KaratsubaMortal();

        System.out.println(karatsubamortal.pegaParametros(parametros));
        
        

    }
}