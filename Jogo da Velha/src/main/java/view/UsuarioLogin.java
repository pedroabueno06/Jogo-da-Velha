package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class UsuarioLogin {
    private static final String DB_URL = "jdbc:sqlite:usuarios.db";
    //armazena o nome do usuário que estiver logado:
    public static String nomeUsuarioLogado = "";


    public static void main(String[] args) {
        criarTabelaUsuarios();
            exibirMenuLogin();
    }

    private static void exibirMenuLogin() {
        String[] opcoes = {"Login", "Cadastro", "Redefinir Senha"};
            int escolha = JOptionPane.showOptionDialog(null, "        ===Bem vindo ao Deitel VOOX===",
                "Tela Inicial",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

                switch (escolha) {
                    case 0 -> fazerLogin();
                    case 1 -> cadastrarUsuario();
                    case 2 -> redeinirSenha();
                    default -> System.exit(0);
                }
    }

    private static void criarTabelaUsuarios() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement()) {
            
                String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "usuario TEXT NOT NULL UNIQUE," +
                "email TEXT NOT NULL UNIQUE," +
                "senha TEXT NOT NULL" +
                ")";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //informações que o usuário deve fornecer ao sistema para se cadastrar:
    private static void cadastrarUsuario() {
        String nome = JOptionPane.showInputDialog("Nome completo: ");
            String usuario = JOptionPane.showInputDialog("Nome de usuário: ");
                String email = JOptionPane.showInputDialog("Email: ");
                    String senha = JOptionPane.showInputDialog("Senha: ");

                    String sql = "INSERT INTO usuarios (nome, usuario, email, senha) VALUES (?, ?, ?, ?)";
                    
                    try (Connection conn = DriverManager.getConnection(DB_URL);
                        PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        
                        pstmt.setString(1, nome);
                            pstmt.setString(2, usuario);
                                pstmt.setString(3, email);
                                    pstmt.setString(4, senha);
                                    //sistema salva as informações no banco de dados:
                                        pstmt.executeUpdate();
                                            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                                                exibirMenuLogin();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao se cadastrar: " + e.getMessage());
                            exibirMenuLogin();
                    }
    }

    //usuário realiza o login para assim o jogo começar:
    private static void fazerLogin() {
        String usuario = JOptionPane.showInputDialog("Nome de usuário: ");
            String senha = JOptionPane.showInputDialog("Senha: ");

                String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
                
                try (Connection conn = DriverManager.getConnection(DB_URL);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    
                    pstmt.setString(1, usuario);
                        pstmt.setString(2, senha);
                            ResultSet rs = pstmt.executeQuery();
                    
                    if (rs.next()) {
                        nomeUsuarioLogado = rs.getString("nome"); //salva o nome do usuário que estiver logado
                        JOptionPane.showMessageDialog(null, "Login realizado com sucesso. Bem vindo, " + nomeUsuarioLogado + "!");
                            iniciarJogo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                            exibirMenuLogin();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }

    //Usuário cadastra uma nova senha para seu login:
    private static void redeinirSenha() {
        String email = JOptionPane.showInputDialog("Digite seu email:");
            String senha = JOptionPane.showInputDialog("Nova senha:");

                String sql = "UPDATE usuarios SET senha = ? WHERE email = ?";

                try (Connection conn = DriverManager.getConnection(DB_URL);
                    PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        
                    pstmt.setString(1, senha);
                        pstmt.setString(2, email);
                            int update = pstmt.executeUpdate();
                    
                    if (update > 0) {
                        JOptionPane.showMessageDialog(null, "Senha atalizada com sucesso.");
                            exibirMenuLogin();
                    } else {
                        JOptionPane.showMessageDialog(null, "Email não encontrado.");
                            exibirMenuLogin();
                    }
                    exibirMenuLogin();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
    }

    private static void iniciarJogo() {
    }

    
}