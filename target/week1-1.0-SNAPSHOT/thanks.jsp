<%-- 
    Document   : thank
    Created on : Nov 6, 2025, 2:18:59 PM
    Author     : baothinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>

<body>
    <h1>Thanks for joining our email list</h1>

    <p>Here is the information that you entered:</p>

    <div style="margin-left: 20px;">
        <label>Email:</label>
        <span>${user.email}</span><br>

        <label>First Name:</label>
        <span>${user.firstName}</span><br>

        <label>Last Name:</label>
        <span>${user.lastName}</span><br>

        <label>Date of Birth:</label>
        <span>${dob}</span><br>

        <label>How did you hear about us?</label>
        <span>${source}</span><br>

        <label>Announcements:</label>
        <span>${likeAnnouncements}</span><br>

        <label>Email Announcements:</label>
        <span>${emailAnnouncements}</span><br>

        <label>Preferred Contact:</label>
        <span>${contact}</span><br>
    </div>

    <p><a href="index.html">Return to the form</a></p>
</body>
</html>
