/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainI;
import java.io.EOFException;
import java.io.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alef_
 */
public class Procedimentos1 implements Serializable {
    
    Map<String, Conta1> banco = new HashMap<>();
    int num = 20170000;
    String nome;
   
    String CONTA;
    
    
    public Procedimentos1(){
        
        nome = "";
    }



    
    public boolean procuraC(String conta){
        
        return banco.containsKey( conta );
    }
    
    public boolean senha(String conta, String chave){
        if(banco.get(conta).acesso(chave)){System.out.println();
        return true;}
        else{return false;}
        
    }
    public boolean psenha(String conta, String chave){
        return banco.get(conta).acesso(chave);
        
    }
    public int numeroCont(){
        
        return banco.size();
    }
    
    public String gConta(){
        num+=numeroCont();
        return Integer.toString(num);
    }
    

    
    public void gCliente(String nome, String conta, double inicial, String senha, String tipo ){
        
        
      
            switch (tipo) {
                case ("Poupança" ):
                 
                    banco.put(conta, new Conta_Poupanca1(nome, conta, inicial, senha));
               
                    break;
                case "Conta Corrente":
                   
                    banco.put(conta, new Conta_Corrente1(nome, conta, inicial, senha));
                  
                    break;
            }
            Taxas_juros(conta);
        }
       
        
    
    
    public void procura(String conta, String chave){
        if(procuraC(conta)){
            senha(conta, chave);
        }else{
            
            System.out.println("Conta não Encontrada");
        }
    }
    
    public void Taxas_juros(String conta){
        
        if (banco.get(conta) instanceof Conta_Poupanca1)
        {banco.get(conta).Atualizar_juros();} 
        else if(banco.get(conta) instanceof Conta_Corrente1)
        {banco.get(conta).Atualizar_juros();}      
    }
    
    public void  gravar  (Procedimentos1 cliente ){
                 try

        {

          //Classe responsavel por inserir os objetos
          try ( //Gera o arquivo para armazenar o objeto
                  FileOutputStream arquivoGrav = new FileOutputStream("teste.txt")) {
              //Classe responsavel por inserir os objetos
              
              ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
              
             
              
              objGravar.writeObject(cliente);
              
             objGravar.flush();
              
             objGravar.close();
              
             arquivoGrav.flush();
              System.out.println("sucesso");
          }

           

        }

        catch( Exception e ){

                e.printStackTrace( );

        }
       
    }                                         

  
   public Procedimentos1 ler(){
        try{
           
            //Carrega o arquivo
            FileInputStream arquivoLeitura = new FileInputStream("teste.txt");
            //Classe responsavel por recuperar os objetos do arquivo
            ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
            Procedimentos1 dado = (Procedimentos1) objLeitura.readObject();
            
            objLeitura.close();
            arquivoLeitura.close();
            
            
            return dado;
           
            
         
        }
        catch( EOFException e ){
                e.printStackTrace( );
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
   }

   public String saldo(String k){
       String s;
       s= ""+banco.get(k).getSaldo();
      return s;
   }

    public void sacar(double valor, String conta){
        if(valor <= 0){
            System.out.println("Valor invalido");
        }else{
       
        if(banco.get(conta).saldo > valor){
            double x = banco.get(conta).saldo;
            x -= valor;
            banco.get(conta).setSaldo(x);
            banco.get(conta).setSaques((banco.get(conta).getSaques()+1));
            
            
        }else{
            System.out.println("Saldo insuficiente. Faça um Deposito\n");
            
        }
        }
    }   
    public void depositar(double valor , String conta){
        if(valor <= 0 ){
            System.out.println("Valor invalido");
        }else{
        double x = banco.get(conta).saldo;
        x += valor;
        banco.get(conta).setSaldo(x);
       
        }
      
    }
    public String nome(String conta){
       return banco.get(conta).getNome();
    }
    
}

         
    

    


 
    
    
