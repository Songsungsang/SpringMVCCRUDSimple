<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
<body>
		<h1>Edit Article</h1>
       <form:form method="POST" action="/SpringMVCCRUDSimple/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
          <tr>  
          <td>Head :</td>  
          <td><form:textarea path="head" rows="2" cols="80"/></td>
         </tr>
         <tr>  
          <td>Context :</td>  
          <td><form:textarea path="context" rows="4" cols="80"/></td>
         </tr> 
         <tr>  
          <td>Date :</td>  
          <td><form:input path="date" /></td>
         </tr> 
         <tr>  
         <tr>  
          <td>View :</td>  
          <td><form:input path="views" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Like :</td>  
          <td><form:input path="likes" /></td>
         </tr> 
         <tr>  
          <td>Comment :</td>  
          <td><form:input path="comments" /></td>
         </tr>
         
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
</body>
</html> 