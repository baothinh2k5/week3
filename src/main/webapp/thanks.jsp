<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/includes/header.html" %>

<h1>Thanks for joining our email list</h1>

<p>Here is the information that you entered:</p>

<div style="margin-left: 20px;">
    <p>
        <label>Email:</label>
        <span>${user.email}</span>
    </p>

    <p>
        <label>First Name:</label>
        <span>${user.firstName}</span>
    </p>

    <p>
        <label>Last Name:</label>
        <span>${user.lastName}</span>
    </p>

    <p>
        <label>Date of Birth:</label>
        <span>${dob}</span>
    </p>

    <p>
        <label>How did you hear about us?</label>
        <span>${source}</span>
    </p>

    <p>
        <label>Announcements:</label>
        <span>${likeAnnouncements}</span>
    </p>

    <p>
        <label>Email Announcements:</label>
        <span>${emailAnnouncements}</span>
    </p>

    <p>
        <label>Preferred Contact:</label>
        <span>${contact}</span>
    </p>
</div>

<p><a href="index.jsp">Return to the form</a></p>

<%@ include file="/includes/footer.jsp" %>
