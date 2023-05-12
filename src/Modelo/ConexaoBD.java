package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;      // Driver
import java.sql.SQLException;       // try/catch

public class ConexaoBD {
    //1. atributos
    private Connection conexao = null;
    private String url = "jdbc:mysql://localhost:3306/oficina_mecanica";
    private String usuario = "root";
    private String senha = "";
    //2. metodos
    public Connection getConexao(){
        try{
            conexao = DriverManager.getConnection(url,usuario,senha);
        }catch (SQLException ex) {
            System.out.println("Excecao: "+ex);
        }
        return conexao;
    }
}
