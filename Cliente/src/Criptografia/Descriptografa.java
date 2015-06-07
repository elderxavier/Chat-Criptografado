
package Criptografia;

public class Descriptografa {
    private String Senha;   // RECEBE SENHA CRIPTOGRAFADA
    private char letra[];   // TRANSFORMA SENHA ARRAY CHAR
    private char fase[];    // TRANSFORMA LETRA[] EM 256 CHAR   
    private int resultado;  // COEFICIENTE DE DESEMBARALHAMENTO FASE[]    
    private int resto;      // COEFICIENTE DE EMBARALHAMENTO LETRA[]
    private int tamanho;    // TAMANHO DA ARRAY; 
    private int coe1;       // COEFICIENTE 1;
    private int coe2;       // COEFICIENTE 2;
    
    //CONSTANTES
    Constantes con = new Constantes();
     
    //CONSTRUTOR
    public Descriptografa(String RecebeSenha){
        Senha = RecebeSenha;
        fase1();
        fase2();
        fase3();
        fase4();
        fase5();
    }
    //RECEBE SENHA CRIPTOGRAFADA
    private void fase1(){
        letra = new char[Senha.length()]; 
         for(int x =0 ;x < Senha.length(); x++){                                   
             letra[x]=Senha.charAt(x);
         }
    }
    //INDICA TAMANHO DESCRIPTOGRAFADO
    private void fase2(){
        //CharKey key = new CharKey();
        //key.setChar(letra[con.posTamanho()]); 
        int key = (int)letra[con.posTamanho()];
        //tamanho = key.hashCode() - con.addValor();        
        tamanho = key - con.addValor();        
    }
    //INDICA COEFICIENTE DE EMBARALHAMENTO
    private void fase3(){
        //CharKey key = new CharKey();
        //key.setChar(letra[con.posCoefi()]);
        int key = (int)letra[con.posCoefi()];
        //resultado = key.hashCode()- con.addValor();
        resultado = key - con.addValor();
    }
    //DEFINE VALORES DE COEFICIENTES (COE1, CEO2)
    private void fase4(){
        coe1 = (con.tamArray()-2) / tamanho;
        int y;
        y = coe1 * tamanho;
        coe2 = (con.tamArray()-2) - y;                
    }
    
    //DESENBARALHANDO SENHA CRIPTOGRAFADA 
    private void fase5(){
        //CharKey key = new CharKey();
        int c = coe1;        
        fase = new char[tamanho];                
        for(int x = 0; x < tamanho; x++){ // coe1                        
            //key.setChar(letra[c]);
            int key = (int)letra[c];
            //fase[x]=(char)(key.hashCode() - coe2);
            fase[x]=(char)(key - coe2);
            //fase[x] = letra[c];
            c = c+ coe1;
        }          
    }
    
    //RETORNA SENHA DESCRIPTOGRAFADA
    public String getSenhaDescr(){
        String retorna = "";
        for(int x =0; x < fase.length; x++){
            retorna = retorna.concat(String.valueOf(fase[x])); 
        }
        return retorna;
    
    }
}
