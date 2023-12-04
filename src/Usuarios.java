public abstract class Usuarios {
    private String nome;
    
    public Usuarios(String n){
        this.nome = n;
    }
    
    public String getNome(){
        return nome;
    }
}
