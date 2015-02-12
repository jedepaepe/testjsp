<%-- 
    Document   : reponsejsp
    Created on : 12-févr.-2015, 20:53:00
    Author     : localwsp
--%>

<%@page import="model.ListeTravailleur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><% 
            ListeTravailleur lt = (ListeTravailleur) request.getAttribute("ListeTravailleur");
            out.println(lt.getAll()); 
        %></h1>
    </body>
</html>
