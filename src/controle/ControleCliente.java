
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import modelo.modeloClliente;




public class ControleCliente {
    ConexaoBD concta = new ConexaoBD();
    modeloClliente mod = new modeloClliente();
    
    
    public void salvar (modeloClliente mod)    {
        concta.conexao();
        
        try {
            PreparedStatement pst = concta.con.prepareStatement("insert into cadastro(nome,cpf,nascimento,sexo,endereco,numero,bairro,cep,telefone,email)values (?,?,?,?,?,?,?,?,?,?)");
             pst.setString(1,mod.getNome());
             pst.setString(2,mod.getCpf());
             pst.setString(3,mod.getNascimeto());
             pst.setString(4,mod.getSexo());
             pst.setString(5,mod.getEndereco());
             pst.setString(6,mod.getNumero());
             pst.setString(7,mod.getBairro());
             pst.setString(8,mod.getCep());
             pst.setString(9,mod.getTelefone());
             pst.setString(10,mod.getEmail());
             pst.execute();
             JOptionPane.showMessageDialog(null,"dados inceridos com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"erro"+ex);
        }
        
        
        concta.desconecta();
    }
}
