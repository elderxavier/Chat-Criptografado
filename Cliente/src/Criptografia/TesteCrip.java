
package Criptografia;

import java.util.Random;

public class TesteCrip extends Constantes{
    private String Senha; // RECEBE SENHA
    private char letra[];  // TRANSFORMA SENHA ARRAY CHAR
    private char fase[];    // TRANSFORMA LETRA[] EM 256 CHAR    
    private int resto; // COEFICIENTE DE EMBARALHAMENTO LETRA[]
    private int resultado; // COEFICIENTE DE EMBARALHAMENTO FASE[]
    
    //CONSTANTES
    Constantes con = new Constantes();
    
    //CONSTRUTOR
    public TesteCrip(String RecebeSenha){    
        Senha = RecebeSenha;  
        fase1();
        fase2();
        fase3();
        fase4();
        fase5();        
    }  
   
    //função recebe senha e desmembra em Chart
    private void fase1(){
        letra = new char[Senha.length()]; 
         for(int x =0 ;x < Senha.length(); x++){                                   
             letra[x]=Senha.charAt(x);
         }
        //  Senha.getChars(0, letra.length, letra, 0);   
         
    }
    //POSICIONA TAMANHO ORIGINAL
    private void fase2(){
          fase = new char[con.tamArray()];
          fase[con.posTamanho()] = (char)(letra.length + con.addValor());          
    }
    //POSICIONA COEFICIENTES DE EMBARALHAMENTO
    private void fase3(){ 
        //CharKey key = new CharKey(fase[con.posTamanho()]); // tamanho variavel no utimo char
          int key = (int)fase[con.posTamanho()];  
          int x = key - con.addValor();
          int y; 
          int ctamArray = con.tamArray() -2;
          resultado = ctamArray / x;                // COEFICIENTE 1
          y = x* resultado;                         // COEFICIENTE 2
          resto = ctamArray - y;
          fase[con.posCoefi()]= (char)(resto + con.addValor()); // UTILIZAR PARA EMBARALHAR
    }
    //EMBARALHANDO
    private void fase4(){
        int emb;        
        //CharKey keyRet = new CharKey();       
        fase[0] = letra[0];
        for(int x =0; x < letra.length; x++){
            int keyRet= (int)letra[x];
            emb = keyRet + resto;
            letra[x] = (char)emb;        
        }
            
    }     
    //PREENCHENDO FASE
    private void fase5(){
        //CharKey keyRet = new CharKey();
        //CharKey keyCom = new CharKey();
        Random random = new Random();                
        int c = resultado;
        for(int x =0; x < letra.length; x++){            
            fase[c] = letra[x];
            c= c + resultado;
        }
        for(int x =0; x < (fase.length); x++){
            //compara = String.valueOf(fase[x]);
            int keyCom = (int)fase[x] ;
            if(keyCom == 0){                
                //c = random.nextInt(92)+33;
                fase[x] = (char)con.addRandom();
            }        
        }        
    }
    //RETORNA SENHA CRIPTOGRAFADA
    public String GetSenhaCript(){
        String retorna="";
        for(int x=0; x < fase.length; x++ ){
        retorna = retorna.concat(String.valueOf(fase[x]));
        }
        return retorna;    
    }
}

    



