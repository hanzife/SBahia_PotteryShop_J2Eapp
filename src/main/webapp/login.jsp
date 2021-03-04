<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

    <title>Document</title>
</head>

<body class="w-4/5 mx-auto">

<form action="login" method="post" class="shadow-xl p-10 bg-white max-w-xl rounded mx-auto mt-56">
    <h1 class="text-4xl font-black mb-4">Welcome back!</h1>
    <div class="mb-4 relative">

        <label>Email</label>
        <input
                class="input border border-gray-400 appearance-none rounded w-full px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600"
                id="email" name="email" type="text" autofocus>

    </div>
    <div class="mb-4 relative">

        <label >password</label>
        <input
                class="input border border-gray-400 appearance-none rounded w-full px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600"
                id="password" name="password" type="password" autofocus>

    </div>
    <span>${error}</span><br>
    <button
            class="bg-yellow-900	 hover:bg-brown-dark text-white font-bold py-3 px-6 rounded-xl w-full">Submit
    </button>


</form>
<div class="text-center"><a href="">Sign up!</a></div>


</body>

</html>