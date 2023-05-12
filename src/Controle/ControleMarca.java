package Controle;

import Modelo.DAOMarca;
import Modelo.Marca;
import java.util.ArrayList; //ArrayList<>

public class ControleMarca {
    public Boolean inserirMarca (Marca marca) {
        DAOMarca daoMarca = new DAOMarca();
        Boolean resposta = daoMarca.Inserir(marca);
        return resposta;
    }
    
    public String pesquisarMarca (int id_marca){
        DAOMarca daoMarca = new DAOMarca();
        String nome = daoMarca.pesquisar(id_marca);
        return nome;
    }
    
    public Boolean alterarMarca(int id_marca, String novoNome) {
        DAOMarca daoMarca = new DAOMarca();
        Boolean resposta = daoMarca.alterar(id_marca, novoNome);
        return resposta;
    }
    
    public Boolean excluirMarca(int id_marca) {
        DAOMarca daoMarca = new DAOMarca();
        Boolean resposta = daoMarca.escluir(id_marca);
        return resposta;
    }
    
    public ArrayList<Marca> listarMarca() {
        DAOMarca daoMarca = new DAOMarca();
        ArrayList<Marca> marcas = daoMarca.listar();
        return marcas;
    }
}
