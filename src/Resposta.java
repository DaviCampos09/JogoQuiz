import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Resposta {
    private int respCorreta;
    private ArrayList<String> alternativas;
    
    
    public Resposta(){
        
    }
    
    public Resposta(int rC,String alt1,String alt2,String alt3,String alt4){
        ArrayList<String> alt = new ArrayList<String>();
        alt.add(alt1);
        alt.add(alt2);
        alt.add(alt3);
        alt.add(alt4);
        
        this.respCorreta = rC;
        this.alternativas = alt;
    }
    
    
    public ArrayList<String> getAlternativas(){
       
        return alternativas;
    }
    
    public void salvaResposta(){
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("resposta.txt", true));
            
            saida.write(respCorreta+"#");
            for(int i=0; i<alternativas.size();i++){
                saida.write((i+1)+")"+alternativas.get(i)+"#");
            }
            saida.newLine();  
            saida.close();
            
        }catch(IOException e){ 
            e.printStackTrace();
        }
    }
    
    
    public int getRespCorreta(){
        return respCorreta;
    }
    
    public String mostraResposta(){
        return ""+alternativas;
    }
    
    
    
    
}

