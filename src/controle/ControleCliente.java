/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import controle.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.modeloClliente;
/**
 *
 * @author diego
 */
public class ControleCliente {
    
    ConexaoBD conecta = new ConexaoBD();
    modelo.modeloClliente mod = new modeloClliente();
    
    
    public void salvar (modeloClliente mod){
        conecta.conexao();
        
        try {
            PreparedStatement pst = conecta.con.prepareStatement("insert into cadastro (nome,cpf,nascimeto,endereco,telefone,email) values(?,?,?,?,?,?)");
            
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getCpf());
            pst.setString(3,mod.getNascimeto());
            pst.setString(4,mod.getEndereco());
            pst.setString(5,mod.getTelefone());
            pst.setString(6,mod.getEmail());
            
            JOptionPane.showMessageDialog(null, "dados inceridos com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "dados nao inceridos" + ex);
        }
       
        
        
        
        conecta.desconecta();
        
        
    }
    
}
