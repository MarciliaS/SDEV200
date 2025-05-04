<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int totalQuestions = 5;
    int correctCount = 0;

    for (int i = 1; i <= totalQuestions; i++) {
        int a = Integer.parseInt(request.getParameter("a" + i));
        int b = Integer.parseInt(request.getParameter("b" + i));
        int correctAnswer = a + b;

        String userAnswerStr = request.getParameter("answer" + i);
        int userAnswer = 0;
        boolean isCorrect = false;

        try {
            userAnswer = Integer.parseInt(userAnswerStr);
            if (userAnswer == correctAnswer) {
                correctCount++;
                isCorrect = true;
            }
        } catch (Exception e) {
            // Invalid input; treat as incorrect
        }
%>
        <p>
            Question <%= i %>: <%= a %> + <%= b %> = <%= correctAnswer %> <br/>
            Your Answer: <%= userAnswerStr %> 
            <% if (isCorrect) { %> ✅ Correct 
            <% } else { %> ❌ Incorrect 
            <% } %>
        </p>
<%
    }
%>

<h2>You got <%= correctCount %> out of <%= totalQuestions %> correct.</h2>
