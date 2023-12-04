import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;






public class Main{

    public static HashMap<String,Administrador> carregaAdministrador(){
        HashMap<String,Administrador> adms = new HashMap<String,Administrador>();
        try(BufferedReader br = new BufferedReader(new FileReader("administradores.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String nome = parts[0].trim();
                    String id = parts[1].trim();
                    String senha = parts[2].trim();
                    Administrador admin = new Administrador(nome, id, senha);
                    adms.put(id, admin);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
       }
        
        
        return adms;
   } 
    
    
    
    public static ArrayList<Pergunta> carregaPergunta(){
        ArrayList<Pergunta> prgs = new ArrayList<Pergunta>();
        
        try(BufferedReader br = new BufferedReader(new FileReader("pergunta.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 3) {
                    String a = parts[0].trim();
                    String e = parts[1].trim();
                    String d = parts[2].trim();
                    
                    Pergunta p = new Pergunta(a,d,e);
                    prgs.add(p);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
       }
        
        
        return prgs;
   } 
    
    public static ArrayList<Resposta> carregaResposta(){
        ArrayList<Resposta> resps = new ArrayList<Resposta>();
        try(BufferedReader br = new BufferedReader(new FileReader("resposta.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 5) {
                    int rC = Integer.parseInt(parts[0].trim());
                    
                    String alt1 = parts[1].trim();
                    
                    String alt2 = parts[2].trim();
                    
                    String alt3 = parts[3].trim();
                    
                    String alt4 = parts[4].trim();
                    
                    Resposta r = new Resposta(rC,alt1,alt2,alt3,alt4);
                    resps.add(r);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
       }
        
        
        return resps;
   } 
    
    
    public static ArrayList<Jogador> carregaRanking(){
        ArrayList<Jogador> jo = new ArrayList<Jogador>();
        try(BufferedReader br = new BufferedReader(new FileReader("ranking.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 2) {
                    String n = parts[0].trim();
                    int p = Integer.parseInt(parts[1].trim());
                    
                   Jogador j = new Jogador(n,p);
                    jo.add(j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
       }
        
        
        return jo;
   } 
    
    
    public static HashMap<String,Jogador> carregaJogadores(){
        HashMap<String,Jogador> jo = new HashMap<String,Jogador>();
        try(BufferedReader br = new BufferedReader(new FileReader("jogadores.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 2) {
                    String n = parts[0].trim();
                    int p = Integer.parseInt(parts[1].trim());
                    
                   Jogador j = new Jogador(n,p);
                    jo.put(n,j);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
       }
        
        
        return jo;
   } 

    
    
    public static void main(String a[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        HashMap<String,Administrador> adm = new HashMap<String,Administrador>();
        ArrayList<Pergunta> perg = new ArrayList<Pergunta>();
        ArrayList<Resposta> resp = new ArrayList<Resposta>();
        ArrayList<Jogador> jogad = new ArrayList<Jogador>();
        HashMap<String,Jogador> jo = new HashMap<String,Jogador>();
        Pergunta p = new Pergunta();
        Resposta r = new Resposta();
        int opc;
        /*adm = carregaAdministrador();
        perg = carregaPergunta();
        resp = carregaResposta();
        jo = carregaJogadores();*/
                           
        
        do{
           adm = carregaAdministrador();
           perg = carregaPergunta();
           resp = carregaResposta();
           jo = carregaJogadores(); 
           System.out.println("MENU:\r\n[1]Cadastrar Administrador\r\n[2]Cadastrar pergunta\r\n[3]Jogar\r\n[0]Sair");
           opc = sc.nextInt();
            
           switch(opc){
               case 1:
                 try{  
                   System.out.println("===DADOS:===");
                   System.out.println("NOME: ");
                   String n = sc.next();
                   System.out.println("ID: ");
                   String id = sc.next();
                   System.out.println("SENHA: ");
                   String s = sc.next();
                 
                     
                 
                   Administrador ad = new Administrador(n,id,s);
                   
                   ad.salvaAdministrador();
                   System.out.println("Administrador cadastrado com sucesso!");
                 }catch(InputMismatchException e){
                     System.out.println("Digitacao invalida.");
                 }catch(Exception e){
                     System.out.println("Erro desconhecido.");
                 }
                   break;
               case 2:
                   System.out.println("====CADASTRAR PERGUNTA====");
                   System.out.println("Digite seu id: ");
                   String idComp = sc.next();
                       
                       if(adm.containsKey(idComp)){
                           System.out.println("Administrador encontrado");
                           System.out.println("Ola "+adm.get(idComp).getNome()+".Digite os seguintes dados sobre a pergunta: ");
                           System.out.println("Assunto: ");
                           String as = sc.next();
                           System.out.println("Dificuldade: ");
                           String d = sc.next();
                           sc.nextLine();
                           System.out.println("Enunciado: ");
                           String e = sc.nextLine();   
                           System.out.println("Alternativa 1: ");
                           String alt1 = sc.nextLine();
                           System.out.println("Alternativa 2: ");
                           String alt2 = sc.nextLine();
                           System.out.println("Alternativa 3: ");
                           String alt3 = sc.nextLine();
                           System.out.println("Alternativa 4: ");
                           String alt4 = sc.nextLine();
                               
                           System.out.println("Digite o indice da resposta correta: ");
                           int rC = sc.nextInt();
                               
                           
                           p = adm.get(idComp).criarPergunta(as, d, e);
                           p.salvaPerguntas();
                           r = adm.get(idComp).criarResposta(rC, alt1, alt2, alt3, alt4);
                           r.salvaResposta();
                              
                           System.out.println("Pergunta cadastrada com sucesso!");
                           
                           resp = carregaResposta();
                           perg = carregaPergunta();
                       }else{
                           System.out.println("ID nao encontrado");
                       }
 
                       break;
               case 3: 
                  
                      System.out.println("Quantos jogadores irao jogar? ");
                      int numJogadores = sc.nextInt();
                      
                      if(numJogadores>0 && numJogadores <= 4){
                          jogad.clear();
                          for(int i=0; i<numJogadores; i++){
                              System.out.println("Digite o nome do jogador "+(i+1)+": ");
                              String no = sc.next();
                              
                              if(jo.containsKey(no)){
                                  System.out.println("Bem vindo de volta "+jo.get(no).getNome()+"!");
                                  
                                  jogad.add(jo.get(no));
                              }else{
                                  Jogador j = new Jogador(no);
                                  
                                  jogad.add(j);
                              } 
                              
                          }
                      }else{
                          System.out.println("Numero de jogadores invalido");
                          break;
                      }

                          Jogo jogo = new Jogo(perg,resp,jogad);  
                          
                        do{  
                            jogo.iniciarJogo();  
                            System.out.println("======RODADA "+jogo.getRodadas()+"======");
                          
                          for(int i=0; i<jogad.size();i++){
                            System.out.println("Vez do jogador["+(i+1)+"]: ");

                            System.out.println(jogo.selecionarPerguntaAleatoria());
                            
                            System.out.println("Digite o indice da resposta correta");
                            int respEscolhida = sc.nextInt();
                              
                            if(jogo.verificaResp(respEscolhida)){
                              jogo.attPontos(jogad.get(i));
                              System.out.println("Acertou!");
                            }else
                                
                              System.out.println("Errou!");
                        
                          }
                          
                          }while(jogo.getRodadas()<5);
                          
                            for(int i=0; i<jogad.size(); i++){
                                jo.put(jogad.get(i).getNome(), jogad.get(i));
                                jo.get(jogad.get(i).getNome()).salvaJogador();
                            }
                        
                        

                             System.out.println("Rodadas acabaram.");
                             System.out.println("Deseja ver o ranking?[s/n]");
                             String opc3 = sc.next();  
                             if(opc3.equalsIgnoreCase("s")){
                                 System.out.println("====RANKING====");
                                 jogo.salvaRanking();
                                 jogad = carregaRanking();
                                 jogo.verRanking(jogad);
                             }else{
                                 System.out.println("Deseja fechar o jogo?[s/n]");
                                 String opc4 = sc.next();
                                 
                                 if(opc4.equalsIgnoreCase("s"))
                                     jogo.finalizarJogo();
                             }
                           
                           
                   
                          break;
                        
               case 0:
                   System.out.println("Saindoooo....");
                   break;
           }
        }while(opc != 0);
        sc. close();
    }
}

