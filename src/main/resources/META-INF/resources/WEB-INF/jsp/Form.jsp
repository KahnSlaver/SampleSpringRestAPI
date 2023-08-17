<head>
    <title>Insertion Form</title>
</head>
<body>

<h1>Insertion Form</h1>

<form action="/books/api" method="post" modelAttribute="book">
    <!-- action method would be where we will be sending our stuff -->
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" ><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" ><br><br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author"><br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>

	<!-- Copied from chatGPT form now -->