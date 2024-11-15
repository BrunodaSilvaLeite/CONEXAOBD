package CRUD;

public class Aluno {
    int id;
    String nome;
    int idade;

    //metodo construtor
    public Aluno( int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método toString (opcional, mas útil para exibir os dados do aluno)
    @Override
    public String toString() {
        return "Aluno [ID=" + id + ", Nome=" + nome + ", Idade=" + idade + "]";
    }
}
