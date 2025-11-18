<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/includes/header.html" />

<h1>Please fill out our survey</h1>

<form action="survey" method="post">

    <!-- Email -->
    <label>Email:</label>
    <input type="email" name="email" required><br><br>

    <!-- First Name -->
    <label>First Name:</label>
    <input type="text" name="firstName" required><br><br>

    <!-- Last Name -->
    <label>Last Name:</label>
    <input type="text" name="lastName" required><br><br>

    <!-- Heard From -->
    <label>How did you hear about us?</label>
    <select name="heardFrom">
        <option value="Search Engine">Search Engine</option>
        <option value="Friend">Friend</option>
        <option value="Social Media">Social Media</option>
        <option value="Other">Other</option>
    </select><br><br>

    <!-- Updates -->
    <label>Would you like to receive updates?</label>
    <input type="radio" name="updates" value="Yes"> Yes
    <input type="radio" name="updates" value="No"> No<br><br>

    <!-- Contact Via -->
    <label>Preferred Contact Method:</label>
    <input type="radio" name="contactVia" value="Email"> Email
    <input type="radio" name="contactVia" value="Phone"> Phone<br><br>

    <input type="submit" value="Submit">
</form>

<c:import url="/includes/footer.jsp" />
