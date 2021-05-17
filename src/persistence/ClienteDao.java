package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao{
	
	 public void create (Cliente c)throws Exception{
	 open(); 
	   stmt  = con.prepareStatement("insert into cliente values (null,?,?) ");
	     stmt.setString(1,   c.getNome());
	     stmt.setString(2,  c.getEmail());
	     stmt.execute();
	     stmt.close();
	 close();	 
	 }
	 
	 
	public List<Cliente> findAll() throws Exception{
		 open();  
		   stmt = con.prepareStatement("select * from cliente");
		    rs = stmt.executeQuery();
		    List<Cliente> lst = new ArrayList<Cliente>();
		   while(rs.next()){
			   Cliente c =new Cliente(); 
			             c.setIdCliente(rs.getInt(1));
	                   	 c.setNome(rs.getString(2));
	                   	 c.setEmail(rs.getString(3));
			     lst.add(c);
		   }
	 close();
	 return lst;
	}
	
	
	public Cliente findByCode(Integer cod) throws Exception{
		 open();  
		   stmt = con.prepareStatement("select * from cliente where idCliente=?");
		   stmt.setInt(1, cod); 
		    rs = stmt.executeQuery();
		    Cliente c = null;
		   if(rs.next()){
			  c =new Cliente(); 
			             c.setIdCliente(rs.getInt(1));
	                   	 c.setNome(rs.getString(2));
	                   	 c.setEmail(rs.getString(3));
		   }
	 close();
	 return c;
	}

	
	
	
}
