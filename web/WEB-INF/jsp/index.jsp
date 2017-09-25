<%-- 
    Document   : index
    Created on : Sep 25, 2017, 7:32:01 PM
    Author     : cyclingbd007
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%= request.getContextPath() %>/fileUpload" method="post" enctype="multipart/form-data">
            <input type="file" name="post_image"/>
            <input type="submit" value="Submit"/>
        </form>
        
        <a href="${pageContext.request.contextPath}">Refresh page</a>
    </body>
</html>
