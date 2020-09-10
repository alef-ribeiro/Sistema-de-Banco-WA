/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainI;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
/**
 *
 * @author alef_
 */
abstract class Conta1 implements Serializable {
    Map<String, Conta1> example = new HashMap<>();    
    DecimalFormat df = new DecimalFormat("0.00");
    private String nome;
    private int saques;
    private String conta;
    double saldo;
    private String senha;
    private double inicial;
    private int conta2;
    private double saldo_inicial;
    
    

    
    public Conta1(String nome, String conta, double saldo_inicial, String senha){
        this.nome = nome;
        this.conta = conta;
        this.saldo = saldo_inicial;
        this.saques = 0;
        this.senha = senha;
        this.conta2 = 20170000;
        
        
    }


    public void setExample(Map<String, Conta1> example) {
        this.example = example;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaques() {
        return saques;
    }

    public void setSaques(int saques) {
        this.saques = saques;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getInicial() {
        return inicial;
    }

    public void setInicial(double inicial) {
        this.inicial = inicial;
    }

    public int getConta2() {
        return conta2;
    }

    public void setConta2(int conta2) {
        this.conta2 = conta2;
    }

    public double getSaldo_inicial() {
        return saldo_inicial;
    }

    public void setSaldo_inicial(double saldo_inicial) {
        this.saldo_inicial = saldo_inicial;
    }
   
    
    
    
    public boolean acesso(String chave){
        
        return this.senha.equals(chave);
    }
 
    public void Atualizar_juros(){
      
          
    }
}
