<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/17/2021
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">

    <title>Document</title>
</head>

<body class="w-4/5 mx-auto">

<form method="post" action="SignUp" class="shadow-xl p-10 bg-white max-w-xl rounded mx-auto mt-56">
    <h1 class="text-4xl font-black mb-4">Welcome to SBahia!</h1>
    <div class="mb-4 relative">

        <label>Username</label>
        <input
                class="input border border-gray-400 appearance-none rounded w-full px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600"
                id="username" type="text" name="username" autofocus>
    </div>

    <div class="mb-4 relative">

        <label>Email</label>
        <input
                class="input border border-gray-400 appearance-none rounded w-full px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600"
                id="email" type="text" name="email" autofocus>

    </div>


    <div class="mb-4 relative">

        <label>password</label>
        <input
                class="input border border-gray-400 appearance-none rounded w-full px-3 py-3 pt-5 pb-2 focus focus:border-indigo-600 focus:outline-none active:outline-none active:border-indigo-600"
                id="password" type="password" name="password" autofocus>

    </div>
    <button
            class="bg-yellow-900	 hover:bg-brown-dark text-white font-bold py-3 px-6 rounded-xl w-full">Submit
    </button>


</form>
<div class="text-center"><a href="">Already have an account? login!</a></div>


</body>

</html>