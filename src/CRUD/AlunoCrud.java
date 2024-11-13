package CRUD;
import Conexão.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AlunoCrud {
    // Método para inserir um aluno no banco de dados
    public void inserir(Aluno aluno) {
        Connection conexao = ConexaoBD.conectar();
        String sql = "INSERT INTO alunos (nome, idade) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.executeUpdate();
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
        Connection conexao = ConexaoBD.conectar();
        String sql = "SELECT * FROM alunos";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            System.out.println("\nLista de Alunos:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
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
        Connection conexao = ConexaoBD.conectar();
        String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setInt(3, aluno.getId());
            stmt.executeUpdate();
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
        Connection conexao = ConexaoBD.conectar();
        String sql = "DELETE FROM alunos WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
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
