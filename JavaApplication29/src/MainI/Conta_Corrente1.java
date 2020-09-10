/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainI;

import java.io.Serializable;



/**
 *
 * @author alef_
 */


public class Conta_Corrente1 extends Conta1 implements Serializable {
    
 
    double taxa = 0.05;
    
    public Conta_Corrente1(String nome, String conta, double saldo_inicial, String senha) {
        super(nome, conta, saldo_inicial, senha);
     
        
    }
    
  public void Atualizar_juros(){
      
        saldo-=taxa;
          
    }
}
