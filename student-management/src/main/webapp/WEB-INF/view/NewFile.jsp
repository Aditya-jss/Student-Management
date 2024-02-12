<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management</title>
    
    <style>
        body {
            font-family: 'Arial', sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0; /* Set your desired background color */
        }

        h1 {
            color: #007bff; /* Set your desired text color for the heading */
            padding-bottom: 10px; /* Add some space below the heading */
            font-family: 'Times New Roman', Times, serif; /* Set your desired font family */
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }

        th, td {
            border: 1px solid #333; /* Set border color for table cells */
            padding: 10px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Set background color for even rows */
        }

        form {
            margin-bottom: 20px;
        }

        form input {
            padding: 5px;
            margin: 5px;
        }

        button {
            padding: 8px 15px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <h1>Student Management</h1>
    <form action="/student-management/save-student" method="POST">
        <label for="id">ID:</label>
        <input type="text" name="id" id="id" required>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" required>
        <label for="mobile">Mobile:</label>
        <input type="text" name="mobile" id="mobile" required>
        <label for="country">Country:</label>
        <input type="text" name="country" id="country" required>
        <button type="submit">Add Student</button>
    </form>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Mobile</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <a href="/student-management/updateStudent?userId=${student.id}">Update</a>
                        <a href="/student-management/deleteStudent?userId=${student.id}" 
                           onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
                        
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
