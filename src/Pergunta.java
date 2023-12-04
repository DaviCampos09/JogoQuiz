import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Pergunta {
    private String assunto, dificuldade,enunciado;
    private int pontuacao;
    
    
    public Pergunta(){
        
    }
    
    
    public Pergunta(String a,String e){
        this.assunto = a;
        this.enunciado = e;
    }
    
    public Pergunta(String a, String d, String e){
        this.assunto = a;
        this.dificuldade = d;
        this.enunciado = e;
        
        if(this.dificuldade.equalsIgnoreCase("Dificil")){
           this.pontuacao = 30;
        }else if(this.dificuldade.equalsIgnoreCase("Media")){
           this.pontuacao = 20; 
        }else{
           this.pontuacao = 10;
        }

    }
    
    public String getAssunto(){
        return assunto;
    }
    
    public String getDificuldade(){
        return dificuldade;
    }
    
    public String getEnunciado(){
        return enunciado;
    }
    
    public int getPontuacao(){
        return pontuacao;
    }
    
    
    public String mostraPergunta(){
        return assunto+"\r\n"+enunciado+"\r\n";
    }
    
    
    public void salvaPerguntas()
    {
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("pergunta.txt", true));
            
            saida.write(assunto+"#");
            saida.write(enunciado+"#");
            saida.write(dificuldade+"#");
            
            saida.newLine();  
            saida.close();
  
        }catch(IOException e){ 
            e.printStackTrace();
        }
    }
    
    
}
