
package Criptografia;

import java.util.Random;

public class Constantes {
     
    public int tamArray(){     // tamanho da senha
        return  256;
    }
    public int posTamanho(){  // posicao do tamanho da string original
        return  255;
    }
    public int posCoefi(){     //  posicao do coeficiente
        return 254;
    }
    public int addValor(){     // acrescimo de valor -> limite de 5 digitos        
         return 20000;
    }
    public int addRandom(){     // acrescimo de valor         
        Random random = new Random();
        return random.nextInt(77)+48;
         //return 33;
    }
}
