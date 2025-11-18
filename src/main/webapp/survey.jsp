<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />

<h1>Thanks for taking our survey!</h1>

<p>Here is the information that you entered:</p>

<div>
    <!-- Email -->
    <label>Email:</label>
    <span>${user.email}</span><br>

    <!-- First Name -->
    <label>First Name:</label>
    <span>${user.firstName}</span><br>

    <!-- Last Name -->
    <label>Last Name:</label>
    <span>${user.lastName}</span><br>

    <!-- Heard From -->
    <label>How did you hear about us?</label>
    <span>${user.heardFrom}</span><br>

    <!-- Updates -->
    <label>Would you like to receive updates?</label>
    <span>${user.updates}</span><br>

    <c:if test="${user.updates == 'Yes'}">
        <label>Preferred Contact Method:</label>
        <span>${user.contactVia}</span><br>
    </c:if>
</div>

<p><a href="index.jsp">Back to the form</a></p>

<c:import url="/includes/footer.jsp" />
