import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Jogador extends Usuarios implements Comparable<Jogador>{
        private int pontos;
        
        public Jogador(String n){
            super(n);
            this.pontos = 0;
    
        }
        
        public Jogador(String n, int p){
            super(n);
            this.pontos = p;
        }
        
        
        public int getPontos(){
            return pontos;
        }
        
        public void atuPontos(int p){
            pontos = p;
        }
        
        public String mostrarJogador(){
            return "NOME: "+getNome()+" PONTUACAO: "+pontos;
        }
    
        public void salvaJogador()
        {
            try{
                BufferedWriter saida = new BufferedWriter(new FileWriter("jogadores.txt", true));
                
                saida.write(getNome()+"#");
                saida.write(pontos+"#");
                
                
                saida.newLine();  
                saida.close();
      
            }catch(IOException e){ 
                e.printStackTrace();
            }
        }
        
        
        @Override
         public int compareTo(Jogador outroJogador) {
            // Compare com base nos pontos em ordem decrescente
            return Integer.compare(outroJogador.pontos, this.pontos);
        }
        
        
    }
    

