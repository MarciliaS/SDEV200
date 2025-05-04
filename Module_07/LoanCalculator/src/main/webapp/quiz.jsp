<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
<%
    Random rand = new Random();
    int totalQuestions = 5;
%>
<html>
<head>
    <title>Addition Quiz</title>
</head>
<body>
    <h2>Simple Addition Quiz</h2>
    <form action="result.jsp" method="post">
        <%
            for (int i = 1; i <= totalQuestions; i++) {
                int a = rand.nextInt(10);
                int b = rand.nextInt(10);
        %>
            <p><%= a %> + <%= b %> = 
                <input type="text" name="answer<%= i %>" />
                <input type="hidden" name="a<%= i %>" value="<%= a %>"/>
                <input type="hidden" name="b<%= i %>" value="<%= b %>"/>
            </p>
        <%
            }
        %>
        <input type="submit" value="Submit Answers" />
    </form>
</body>
</html>
