
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ConexaoBD {
    
    // Preparar e realizar pesquisar "Statement" 
   public Statement stm ;
   // Resultset guarda o que foi pesquisado 
   public ResultSet rs ;
   
   private  String driver ="org.postgresql.Driver";
   private String caminho ="jdbc:mysql://localhost/cadastraCliente" ;
   private String usuario = "root";
   private String senha = "root";
   public Connection con ;
    
   
   public void conexao (){
       System.setProperty("jdbc.Drivers", driver);  
       try {
           con =DriverManager.getConnection(caminho, usuario, senha);
           JOptionPane.showMessageDialog(null, "conectado com sucesso");
       } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null,"erro "+ex);
       }
   }
   public void desconecta(){
       try {
           con.close();
           JOptionPane.showConfirmDialog(null, "desconectado com sucesso");
       
       } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "erro ao fechar"+ex);
       }
       
   }
}





