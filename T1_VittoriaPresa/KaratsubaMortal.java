//Vittoria Presa

public class KaratsubaMortal {

    public String pegaParametros(String parametros){
      String separador = " " ;
      String v1 = parametros.split(separador)[0];
      String v2 = parametros.split(separador)[1];
      String shiftV1 = "0";
      String shiftV2 = "0";

    return karatsubaMortal(v1, v2, shiftV1, shiftV2, 0);
     
   }

    public String karatsubaMortal(String v1, String v2, String shiftV1, String shiftV2, Integer auxiliar) {

        if(v1.length() == 1 && v2.length() == 1){
            Integer auxV1 = Integer.parseInt(v1);
            Integer auxV2 = Integer.parseInt(v2);
            String resultado = Integer.toString(auxV1 * auxV2);
            for( int i = 0; i < Integer.parseInt(shiftV1) + Integer.parseInt(shiftV2); i++){
                resultado += "0";
            }

            return resultado;

        } else {

            if(v1.length() < 3 ){
                if(v1.length() < 2 && v1.length() != 0)
                    v1 = "0" + v1;


                if(v1.length() == 2)
                    v1 = "0" + v1;
            }

            if(v2.length() < 3) {

                if(v2.length() < 2 && v2.length() != 0)
                    v2 = "00" + v2;

                if(v2.length() == 2)
                    v2 = "0" + v2;
            }

        Integer auxV1 = v1.length() / 3;
                
        String v11 = v1.substring(0, auxV1);
        String v12 = v1.substring(auxV1, 2 * auxV1);
        String v13 = v1.substring(2 * auxV1);

        Integer auxV2 = v2.length() / 3;

        String v21 = v2.substring(0,auxV2);
        String v22 = v2.substring(auxV2, 2 * auxV2);
        String v23 = v2.substring(2 * auxV2);

        Integer sv11 = Integer.parseInt(shiftV1) + v1.length() - v11.length();
        Integer sv12 = Integer.parseInt(shiftV1) + v1.length() - (2 * v11.length());
        Integer sv13 = Integer.parseInt(shiftV1) + v1.length() - (2 * v11.length() + v13.length());

        Integer sv21 = Integer.parseInt(shiftV2) + v2.length() - v21.length();
        Integer sv22 = Integer.parseInt(shiftV2) + v2.length() - (2 * v21.length());
        Integer sv23 = Integer.parseInt(shiftV2) + v2.length() - (2 * v21.length() + v23.length());


        String a = karatsubaMortal(v11, v21, Integer.toString(sv11), Integer.toString(sv21), 6)+ "";
        String b = karatsubaMortal(v11, v22, Integer.toString(sv11), Integer.toString(sv22), 5);
        String c = karatsubaMortal(v11, v23, Integer.toString(sv11), Integer.toString(sv23), 3);
        String d = karatsubaMortal(v12, v21, Integer.toString(sv12), Integer.toString(sv21), 5);
        String e = karatsubaMortal(v12, v22, Integer.toString(sv12), Integer.toString(sv22), 4);
        String f = karatsubaMortal(v12, v23, Integer.toString(sv12), Integer.toString(sv23), 2);
        String g = karatsubaMortal(v13, v21, Integer.toString(sv13), Integer.toString(sv21), 3);
        String h = karatsubaMortal(v13, v22, Integer.toString(sv13), Integer.toString(sv22), 2);
        String i = karatsubaMortal(v13, v23, Integer.toString(sv13), Integer.toString(sv23), 0);

         String resultado = fazSoma(i, h);
            resultado = fazSoma(resultado, g);
            resultado = fazSoma(resultado, f);
            resultado = fazSoma(resultado, e);
            resultado = fazSoma(resultado, d);
            resultado = fazSoma(resultado, c);
            resultado = fazSoma(resultado, b);
            resultado = fazSoma(resultado, a);

        return resultado;

    }

}

public String fazSoma(String valor1, String valor2){

     Integer carryout = 0;
    

    if (valor1.length() > valor2.length()) {
        String troca = valor1;
        valor1 = valor2;
        valor2 = troca;
    }

    Integer tamanhoV1 = valor1.length();
    Integer tamanhoV2 = valor2.length();

    String resposta = "";

    valor1 = new StringBuilder(valor1).reverse().toString();
    valor2 = new StringBuilder(valor2).reverse().toString();


    for(int i = 0; i != tamanhoV1; i++){
        Integer fazSoma = ((Integer) (valor1.charAt(i) - '0') + (Integer) (valor2.charAt(i) - '0') + carryout);
        resposta += (char) (fazSoma % 10 + '0');
        carryout = fazSoma / 10;
    }

    for (int i = tamanhoV1; i < tamanhoV2; i++) {
        Integer fazSoma = ((Integer) (valor2.charAt(i) - '0') + carryout);
        resposta += (char) (fazSoma % 10 + '0');
        carryout = fazSoma / 10;
      }

      if(carryout != 0 )
      resposta += (char) (carryout + '0');

      resposta = new StringBuilder(resposta).reverse().toString();

      return resposta;

    }

}

    

    
  



    

