package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import entity.Cliente;

 
@WebServlet("/Controle")
public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   Client c;
   Gson gson;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd= request.getParameter("cmd");
	  if (cmd.equalsIgnoreCase("gravarGet")){
		  gravarGet(request,response);
	  }else if(cmd.equalsIgnoreCase("listar")){
		  listar(request,response);
	  }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String cmd =request.getParameter("cmd");
          if (cmd.equalsIgnoreCase("gravar")){
      	    gravar(request,response);
        }
   }
	
	
	protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 c = Client.create();
		 gson= new Gson();
		try{
			//estudar ...
			 Cliente cli = new Cliente();
			            cli.setNome(request.getParameter("nome"));
			            cli.setEmail(request.getParameter("email"));
			            //resource = caminho
			            //type e accept = consome
			            // post conversao de String Json ...
			 WebResource wr = 
					   c.resource("http://localhost:8080/RestServ/json/cliente/gravar"); 
			               wr.type("application/json").
			                  accept("application/json").
			                     post(gson.toJson(cli));
			        
			    request.setAttribute("msg", "Dados Gravados ...");
		}catch(Exception ex){
			 request.setAttribute("msg", "Error :" + ex.getMessage());
		}
	   finally{
		   request.getRequestDispatcher("sistema.jsp").forward(request, response);
	   }
	}
	
	protected void gravarGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 c = Client.create();
		 gson= new Gson();
		try{
			 Cliente cli = new Cliente();
			            cli.setNome(request.getParameter("nome"));
			            cli.setEmail(request.getParameter("email"));
			            
			 WebResource wr = 
                         c.resource("http://localhost:8080/RestServ/json/cliente/gravar/"+
			                     cli.getNome() + "/" + cli.getEmail()  ); 
			    String resposta =   wr.get(String.class);         //resposta
			     request.setAttribute("msg", resposta);
			     
		}catch(Exception ex){
			 request.setAttribute("msg", "Error :" + ex.getMessage());
		}
	   finally{
		   request.getRequestDispatcher("sistema.jsp").forward(request, response);
	   }
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 c = Client.create();
		 gson= new Gson();
		try{
			            
			 WebResource wr = 
                        c.resource("http://localhost:8080/RestServ/json/cliente/listar"   ); 
			    String resposta =   wr.get(String.class);         
                 List<Cliente> lst= gson.fromJson(resposta, 
    		             new TypeToken<List<Cliente>>(){}.getType()
    		      ); 		
                 
            request.setAttribute("lista" , lst);     
		}catch(Exception ex){
			 request.setAttribute("msg", "Error :" + ex.getMessage());
		}
	   finally{
		   request.getRequestDispatcher("sistema.jsp").forward(request, response);
	   }
	}

}
