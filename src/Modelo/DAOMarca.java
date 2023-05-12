package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;      // rs
import java.sql.SQLException;   // try/catch
import java.util.ArrayList;     // ArrayList<>

public class DAOMarca extends ConexaoBD {
    public Boolean Inserir(Marca marca){
        String slq = "INSERT INTO marca (id_marca, nome) VALUES (?, ?);";
        int id_marca = marca.getId_marca();
        String nome = marca.getNome();
        //Conexão com o banco de dados
        Connection conexao = this.getConexao();
        Boolean resposta = false;        
        try {
            PreparedStatement declaracao = conexao.prepareStatement(slq);
            declaracao.setInt(1, id_marca);
            declaracao.setString(2, nome);
            declaracao.execute();
            resposta = true;
        } catch (SQLException ex) {
            System.out.println("Exececao: "+ex);
        }
        return resposta;
    }
    
    public String pesquisar (int id_marca){
        String sql = "select nome from marca where id_marca = " + String.valueOf(id_marca);
        String nome = "";
        //Conexão com banco de dados
        Connection conexao = this.getConexao();
        try {
            PreparedStatement declaracao = conexao.prepareStatement(sql);
            ResultSet rs;
            rs = declaracao.executeQuery();
            if (rs.next())
            nome = rs.getString("nome");
        }catch (SQLException ex) {
            System.out.println("Excecao: "+ex);
        } 
        return nome;
    }
    
    public Boolean alterar(int id_marca, String novoNome) {
        String sql = "update marca set nome=? where id_marca=?";
        Boolean resposta = false;
        Connection conexao = this.getConexao();
        try{
        PreparedStatement declaracao = conexao.prepareStatement(sql);
        declaracao.setString(1, novoNome);
        declaracao.setInt(2, id_marca);        
        declaracao.execute();
        resposta = true;
        }catch (SQLException ex){
            System.out.println("Excecao: "+ex);
        }
        return resposta;
    }
    
    public Boolean escluir(int id_marca){
        String slq = "delete from marca where id_marca=?";
        Boolean resposta = false;
        Connection conexao = this.getConexao();
        try{
        PreparedStatement declaracao = conexao.prepareStatement(slq);
        declaracao.setInt(1, id_marca);
        declaracao.execute();
        resposta = true;
        }catch (SQLException ex){
            System.out.println("Excecao: "+ex);
        }
        return resposta;
    }
    
    public ArrayList<Marca> listar(){
        String slq = "select id_marca,nome from marca order by id_marca";
        ArrayList<Marca> marcas = new ArrayList<Marca>();
        Connection conexao = this.getConexao();
        int id_marca;
        String nome;
        try {
            PreparedStatement declaracao = conexao.prepareStatement(slq);
            ResultSet rs = declaracao.executeQuery();
            while (rs.next()){
                id_marca = rs.getInt("id_marca");
                nome = rs.getString("nome");
                Marca marca = new Marca(id_marca,nome);
                marcas.add(marca);
            }
        } catch (SQLException ex){
            System.out.println("Excecao: "+ex);
        }
        return marcas;
    }
    
}
