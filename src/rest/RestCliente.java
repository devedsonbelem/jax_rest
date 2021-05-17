package rest;

 
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import entity.Cliente;
import persistence.ClienteDao;

@Path("/cliente")
public class RestCliente {

	
	 @POST
	 @Path("/gravar")
	 @Produces("application/json")
	 @Consumes("application/json")
	 public String gravar(String cliente){
		 //resgata String
		  try{
		    Cliente cli = new Gson().fromJson(cliente, Cliente.class);
             new ClienteDao().create(cli);
             
			  return "Dados gravados Post...";
		  }catch(Exception ex){
			  return "Error..." + ex.getMessage();
		  }
	 }
	 
	 
	 
	 @GET
	 @Path("/gravar/{nome}/{email}")
	 @Produces("text/Plain")
	 public String gravar(@PathParam("nome") String nome,
			                    @PathParam("email") String email
			                               ){
		  try{
			  Cliente c = new Cliente(null,nome, email);
			   new ClienteDao().create(c);  
			  return "Dados gravados Get...";
		  }catch(Exception ex){
			  return "Error..." + ex.getMessage();
		  }
	 }
	
	 
	 @GET
	 @Path("/listar")
	 @Produces("application/json")
	 public String listar(){
		  try{
			  return new Gson().toJson(new ClienteDao().findAll());   
		  }catch(Exception ex){
			  return "Error..." + ex.getMessage();
		  }
	 } 
	 
	 
	 @GET
	 @Path("/listarCodigo/{codigo}")
	 @Produces("application/json")
	 public String listarCodigo(@PathParam("codigo") String codigo){
		  try{
			  return new Gson().
					  toJson(new ClienteDao().findByCode(new Integer(codigo)));   
		  }catch(Exception ex){
			  return "Error..." + ex.getMessage();
		  }
	 } 
	
	

}
