import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Jogo {
   private int rodadas,vitorias,respCerta,pontuacao,ind;
   ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
   ArrayList<Resposta> respostas = new ArrayList<Resposta>();
   ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
   
   
   public Jogo(ArrayList<Pergunta> p, ArrayList<Resposta> r, ArrayList<Jogador> j){
       this.rodadas = 0;
       this.vitorias = 0;
       this.perguntas = p; 
       this.respostas = r;
       this.jogadores = j;
   }
   
   public int getRodadas(){
       return rodadas;
   }

   public int getVitorias(){
       return vitorias;
   }
   
   public ArrayList<Pergunta> getPerguntas(){
       return perguntas;
   }
   
   public ArrayList<Resposta> getRespostas(){
       return respostas;
   }
   
   public ArrayList<Jogador> getJogadores(){
       return jogadores;
   }
   
   public int getIndice(){
       return ind;
   }
      
   public ArrayList<Jogador> addJogador(Jogador j){
       jogadores.add(j);
       
       return jogadores;
   }
   
  public String selecionarPerguntaAleatoria(){
     
       
    if (perguntas.isEmpty()) {
        return null; // Retorna null se a lista de perguntas estiver vazia.
    }
    
    if (respostas.isEmpty()) {
        return null; // Retorna null se a lista de respostas estiver vazia.
    }
    
    if (jogadores.isEmpty()) {
        return null; // Retorna null se a lista de jogadpres estiver vazia.
    }
    
    Random r = new Random();
    int i = r.nextInt(perguntas.size());
    
    respCerta = respostas.get(i).getRespCorreta();
    pontuacao = perguntas.get(i).getPontuacao();
    ind = i;
    return "====PERGUNTA====\r\n"+perguntas.get(i).mostraPergunta()+"\r\n"+respostas.get(i).mostraResposta();
   }
   
   public boolean verificaResp(int respEscolhida){
        if(respEscolhida == respCerta)
            return true;
        else
            return false;
    }
   
   public void attPontos(Jogador j){
        j.atuPontos(j.getPontos()+pontuacao);
    }
   
   
   public void iniciarJogo(){
      rodadas++;
   }
      
   public void finalizarJogo(){
       System.exit(0);
   }
   
   
   public void salvaRanking()
    {
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("ranking.txt", true));
          
            for(int i=0; i<jogadores.size();i++){
                saida.write(jogadores.get(i).getNome()+"#");
                saida.write(jogadores.get(i).getPontos()+"#");
                saida.newLine(); 
            }
      
            saida.close();
  
        }catch(IOException e){ 
            e.printStackTrace();
        }
    }
   
   public void verRanking(ArrayList<Jogador> j){
        Collections.sort(j);
        
        for (int i=0; i<j.size();i++) {
            System.out.println( "Jogador ["+(i+1)+"]: "+j.get(i).mostrarJogador());
        }
   }  
}
