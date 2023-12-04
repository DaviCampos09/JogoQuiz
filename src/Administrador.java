import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Administrador extends Usuarios{
    private String id, senha;

    public Administrador(String n, String id, String s){
        super(n);
        this.id = id;
        this.senha = s;
    }
    
    public String getID(){
        return id;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public String mostraAdm(){
        return getNome()+" "+id+" "+senha;
    }
    
    
    
    public void salvaAdministrador(){
        try{
            BufferedWriter saida = new BufferedWriter(new FileWriter("administradores.txt", true));
            
            saida.write(mostraAdm());
            saida.newLine();
                
            saida.close();
                
            
        }catch(IOException e){ 
            
        }
    }
    
    public Resposta criarResposta(int rC,String alt1,String alt2,String alt3,String alt4){
        
        Resposta r = new Resposta(rC,alt1,alt2,alt3,alt4);
        
        return r;
    }    
          
    
    public Pergunta criarPergunta(String a, String d, String e){
        
        Pergunta per = new Pergunta(a,d,e);
        
        return per;
    }
    
    
}
