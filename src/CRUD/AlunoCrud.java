package CRUD;
import Conexão.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AlunoCrud {
    // Método para inserir um aluno no banco de dados
    public void insere(Aluno aluno) {
        //Estabelecendo conexão com o banco de dados
        Connection conexao = ConexaoBD.conectar();
        //Criando o comando de insert pro banco de dados
        String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";
        //Criando try para tratativa de erro
        try {
            // Prepara a consulta SQL para inserir os dados do aluno na tabela do banco de dados
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Define o valor do primeiro parâmetro na consulta SQL
            stmt.setString(1, aluno.getNome());

            // Define o valor do segunfo parâmetro na consulta SQL
            stmt.setInt(2, aluno.getIdade());

            //Executa a inserção
            stmt.executeUpdate();

            //Mostra na tela que deu tudo certo
            System.out.println("Aluno inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir aluno: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para listar todos os alunos
    public void listarTodos() {
        //Estabelecendo conexão com o banco de dados
        Connection conexao = ConexaoBD.conectar();
        //Criando o comando de Select pro banco de dados
        String sql = "SELECT * FROM alunos";
        //Criando try para tratativa de erro
        try {
            // Prepara a consulta SQL para select os dados do aluno

            PreparedStatement stmt = conexao.prepareStatement(sql);
            // O ResultSet contém os dados retornados do banco de dados
            ResultSet rs = stmt.executeQuery();


            System.out.println("\nLista de Alunos:");
            //percorre todos os valores do resultado da query e armazena nas devidas variaveis
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                //mostra na tela as informações dos alunos
                System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para atualizar um aluno
    public void atualizar(Aluno aluno) {
        //Estabelecendo conexão com o banco de dados
        Connection conexao = ConexaoBD.conectar();
        //Criando o comando de update do banco de dados
        String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";

        try {
            // Prepara a consulta SQL para atualizar os dados de um aluno no banco de dados.
            PreparedStatement stmt = conexao.prepareStatement(sql);

            // Define o valor do primeiro parâmetro (o nome do aluno) na consulta SQL.
            stmt.setString(1, aluno.getNome());
            // Define o valor do segundo parâmetro (a idade do aluno) na consulta SQL.
            stmt.setInt(2, aluno.getIdade());
            // Define o valor do terceiro parâmetro (o ID do aluno) na consulta SQL.
            stmt.setInt(3, aluno.getId());
            // Executa a atualização no banco de dados.
            stmt.executeUpdate();
            //Mostra na tela que deu tudo certo
            System.out.println("Aluno atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }

    // Método para deletar um aluno
    public void deletar(int id) {
        //Estabelecendo conexão com o banco de dados
        Connection conexao = ConexaoBD.conectar();
        //Criando o comando de delete do banco de dados
        String sql = "DELETE FROM alunos WHERE id = ?";

        try {
            // Prepara a consulta SQL para deletar os dados de um aluno no banco de dados.
            PreparedStatement stmt = conexao.prepareStatement(sql);
            // Define o valor do primeiro parâmetro na consulta SQL .
            stmt.setInt(1, id);
            // Executa a atualização no banco de dados.
            stmt.executeUpdate();
            //Mostra na tela que deu tudo certo
            System.out.println("Aluno deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        } finally {
            try {
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
