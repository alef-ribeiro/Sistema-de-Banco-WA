
package MainI;


import java.io.*;

import java.util.ArrayList;


/** * Uma classe para manter uma lista arbitrariamente longa de notas. 
*As notas são numeradas para referência externa por um usuário humano. 
* Nesta versão, os números das notas começam em 0. * * @author 
David J. Barnes e Michael Kolling. * @version 2008.03.30 */
public class Conta implements Serializable
{
   // Armazenamento para um número arbitrário de notas.
    private ArrayList<String> notes;
 
    

    /** * Execute qualquer inicialização que é necessária para o * 
    notebook
     */
    public Conta()
    {
        notes = new ArrayList<String>();
        
    }

   
    public void get(String note)
    {
        notes.add(note);
    }



   public void escreve()
           
   {
           
     File arquivo = new File("conta.txt");
try( FileWriter arq = new FileWriter(arquivo) ){
    int index = 0;
		while(index < notes.size()) {
			arq.write(notes.get(index));
			index++;
		}
  
                  arq.close();
}

catch(IOException ex){
  ex.printStackTrace();

}
    }
   
 
   

public String ler()
{
    try {
    BufferedReader reader = new BufferedReader(
                          new FileReader("conta.txt"));
    String line = reader.readLine();
        
    while(line != null) {
        return line;
        
        
    }
    
    reader.close();
}
catch(FileNotFoundException e) {
    e.printStackTrace();
}
catch(IOException e) {
    e.printStackTrace();
}
return null;
}



}