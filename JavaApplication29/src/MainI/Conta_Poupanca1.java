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
public class Conta_Poupanca1 extends Conta1 implements Serializable  {



    private double taxa;

    public Conta_Poupanca1(String nome, String conta, double saldo_inicial, String senha) {
        super(nome, conta, saldo_inicial, senha);
        this.taxa = 0.0006;
        
    }
    
    
    
    public void Atualizar_juros(){
        double juros;
        juros = saldo * taxa;
        saldo+=juros;
          
    }
}

