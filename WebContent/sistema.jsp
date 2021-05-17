<!doctype html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.0/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.16.0/jquery.validate.js"></script>

<script>
 $(document).ready(function(){
     $("#accordion").accordion(); 
 });
 </script>
 
 <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 
 </head>
<body>

 <div id="accordion">
 
 
 <h3>Gravar Rest Cliente Post</h3>
 <div>
   <form method="post" action="Controle?cmd=gravar">
      Nome<br/><br/>
      <input type="text" name="nome" id="nome" size="50" value=""
       required="required"   />
     <br/>Email<br/><br/>
         <input type="email" name="email" id="email" size="50" value=""
       required="required"    />
      <br/><br/>
         <input type="submit" value="Enviar os Dados" /> 
   </form>
 </div>
 
 <h3>Gravar Rest Cliente Get</h3>
 <div>
   <form method="get" action="Controle">
        <input type="hidden" name="cmd" value="gravarGet" />
      Nome<br/><br/>
      <input type="text" name="nome" id="nome" size="50" value=""
       required="required"   />
     <br/>Email<br/><br/>
         <input type="email" name="email" id="email" size="50" value=""
       required="required"    />
      <br/><br/>
         <input type="submit" value="Enviar os Dados" /> 
   </form>
 </div>
 <h3>Listar Cliente</h3>
 
 
 <div>
   <form method="get" action="Controle">
        <input type="hidden" name="cmd" value="listar" />
         <input type="submit" value="Enviar os Dados" /> 
   </form>
    <table>
       <thead>
       <tr>
        <th>IdCliente</th>
        <th>Nome</th>
        <th>Email</th>
        </tr>
     </thead>
   <tbody>
     <c:forEach items="${lista}" var="linha">
        <tr>
          <td>${linha.idCliente}</td>
           <td>${linha.nome}</td>
           <td>${linha.email}</td>
        </tr>
    </c:forEach>
   </tbody>
    </table>
</div>
 
 </div>
 ${msg} 
</body>

</html>
