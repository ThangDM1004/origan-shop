<%-- 
    Document   : error
    Created on : Sep 29, 2022, 7:49:06 AM
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        Error: <h1><%= request.getAttribute("ERROR")%></h1>
    </body>
</html>
