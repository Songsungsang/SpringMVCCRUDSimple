    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
	
<!DOCTYPE html>
<html>
<body>
	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Head</th><th>Context</th><th>Date</th><th>View</th><th>Like</th><th>Comment</th><th>Delete</th></tr>
    <c:forEach var="article" items="${list}"> 
    <tr>
    <td>${article.id}</td>
    <td>${article.head}</td>
    <td>${article.context}</td>
    <td>${article.date}</td>
    <td>${article.views}</td>
    <td>${article.likes}</td>
    <td>${article.comments}</td>
    <td><a href="editarticle/${article.id}">Edit</a></td>
    <td><a href="deletearticle/${article.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="articleform">Add New Article</a>
</body>
</html>