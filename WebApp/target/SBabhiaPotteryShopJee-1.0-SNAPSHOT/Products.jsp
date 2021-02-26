<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2/18/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="script.js"></script>

    <title>Admin Dashboard</title>
</head>

<body class="w-4/5 mx-auto">
<div class="flex">
    <!-- left section -->
    <div class="w-4/6 bg-white">
        <!-- header -->
        <header>
            <a>SBahia</a>
        </header>
        <!-- Blank -->
        <div class="w-full h-20"></div>
        <div class="bg-red-50">
            <!-- search form -->
            <input class="border-2  w-3/4 h-14 border-light-blue-500 border-opacity-25 rounded-2xl" type="text">
            <!-- button add new items -->
            <button class="rounded-2xl w-52 h-14 bg-yellow-100">Add</button>
        </div>
        <!-- Cards -->
        <dir class="h-2 w-full"></dir>

        <div class="width w-full mx-auto grid grid-cols-3 gap-10">


            <c:forEach items="${articleCarte}" var="a">
                <!-- Card -->
                <div class="border-2 border-light-blue-500 border-opacity-25 rounded-2xl w-100 h-72 relative">
                    <!-- image -->
                    <div class="w-4/5 h-44 bg-gray-600 mx-auto mt-6 relative">
                        <!-- delete -->
                        <a href="Update.Products?id=${a.getIdArticle()}">
                            <button class="absolute rounded-2xl  top-2 right-2 h-14 w-14 bg-gray-100">
                                <div class="mx-auto py-3 w-2/4">
                                    <svg width="30" height="26" viewBox="0 0 30 26" fill="none"
                                         xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" clip-rule="evenodd"
                                              d="M2.16559 2.25806C3.55264 0.871434 5.43363 0.0924687 7.39492 0.0924687C9.3562 0.0924687 11.2372 0.871434 12.6242 2.25806L14.7914 4.42339L16.9586 2.25806C17.6409 1.55162 18.4571 0.988141 19.3595 0.600498C20.2619 0.212854 21.2324 0.00881347 22.2145 0.000279267C23.1966 -0.00825493 24.1706 0.178889 25.0796 0.550792C25.9886 0.922694 26.8144 1.47191 27.5089 2.16638C28.2034 2.86086 28.7526 3.68669 29.1245 4.5957C29.4964 5.5047 29.6836 6.47867 29.675 7.46077C29.6665 8.44287 29.4624 9.41344 29.0748 10.3158C28.6872 11.2182 28.1237 12.0344 27.4172 12.7167L14.7914 25.3444L2.16559 12.7167C0.778965 11.3297 0 9.44867 0 7.48739C0 5.5261 0.778965 3.64511 2.16559 2.25806V2.25806Z"
                                              fill="#FF6868"/>
                                    </svg>
                                </div>

                            </button>
                        </a>
                    </div>
                    <button
                            onclick="showdetails()" id="updateBTN"
                            class="absolute inset-x-0 bottom-0 h-16 w-full bg-gray-100 rounded-2xl text-center">
                        <p>
                        <p id="articlePrice">${a.getPrice()}</p><span class="">DH</span></p>
                        <p id="articleName">${a.getNameArticle()}</p>
                        <input type="hidden" id="articleID" value="${a.getIdArticle()}">
                        <input type="hidden" id="articleQTE" value="${a.getQteStock()}">
                        <input type="hidden" id="articleDesc" value="${a.getDescription()}">
                    </button>
                </div>
            </c:forEach>


        </div>

    </div>
    <!-- right section -->
    <div class="w-3/6 bg-gray-50">
        <header>
            <a>logout</a>
        </header>
        <!--  -->
        <!-- Blank -->
        <div class="w-full h-20 ">

        </div>


        <div class="w-5/6 mx-auto">

            <!--  -->
            <div class="w-full h-96 bg-gray-200 rounded-2xl relative">
                <button class="absolute rounded-2xl  top-2 left-2 h-14 w-14 bg-gray-100">
                    <div class="mx-auto py-3 w-2/4">
                        <svg width="30" height="26" viewBox="0 0 30 26" fill="none"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd"
                                  d="M2.16559 2.25806C3.55264 0.871434 5.43363 0.0924687 7.39492 0.0924687C9.3562 0.0924687 11.2372 0.871434 12.6242 2.25806L14.7914 4.42339L16.9586 2.25806C17.6409 1.55162 18.4571 0.988141 19.3595 0.600498C20.2619 0.212854 21.2324 0.00881347 22.2145 0.000279267C23.1966 -0.00825493 24.1706 0.178889 25.0796 0.550792C25.9886 0.922694 26.8144 1.47191 27.5089 2.16638C28.2034 2.86086 28.7526 3.68669 29.1245 4.5957C29.4964 5.5047 29.6836 6.47867 29.675 7.46077C29.6665 8.44287 29.4624 9.41344 29.0748 10.3158C28.6872 11.2182 28.1237 12.0344 27.4172 12.7167L14.7914 25.3444L2.16559 12.7167C0.778965 11.3297 0 9.44867 0 7.48739C0 5.5261 0.778965 3.64511 2.16559 2.25806V2.25806Z"
                                  fill="#FF6868"/>
                        </svg>

                    </div>

                </button>
            </div>
            <form action="" class="relative">

                <div class="flex">
                    <h1 class="text-3xl pt-8" id="updateName">selected Product name</h1>
                    <h1 class="text-base pt-8 absolute right-0">Qte <span class="text-4xl"> 44</span></h1>
                </div>
                <div type="text" value="Desc" class="w-full rounded-lg  bg-white mt-6">
                    Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nihil laudantium sed labore nemo
                    veritatis corporis tempore quidem nostrum possimus molestias. Delectus dolorem provident
                    explicabo atque deserunt quod autem doloremque illo.
                </div>

                <div class=" mt-12 flex">
                    <svg width="26" height="22" viewBox="0 0 30 26" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                              d="M2.16559 2.25806C3.55264 0.871434 5.43363 0.0924687 7.39492 0.0924687C9.3562 0.0924687 11.2372 0.871434 12.6242 2.25806L14.7914 4.42339L16.9586 2.25806C17.6409 1.55162 18.4571 0.988141 19.3595 0.600498C20.2619 0.212854 21.2324 0.00881347 22.2145 0.000279267C23.1966 -0.00825493 24.1706 0.178889 25.0796 0.550792C25.9886 0.922694 26.8144 1.47191 27.5089 2.16638C28.2034 2.86086 28.7526 3.68669 29.1245 4.5957C29.4964 5.5047 29.6836 6.47867 29.675 7.46077C29.6665 8.44287 29.4624 9.41344 29.0748 10.3158C28.6872 11.2182 28.1237 12.0344 27.4172 12.7167L14.7914 25.3444L2.16559 12.7167C0.778965 11.3297 0 9.44867 0 7.48739C0 5.5261 0.778965 3.64511 2.16559 2.25806V2.25806Z"
                              fill="#FF6868"/>
                    </svg>
                    <p class="text-xl" id="updateQTE">+99</p>
                </div>

                <!-- Blanck -->
                <dir class="h-2"></dir>
                <div class="flex">
                    <div class="bg-yellow-100 w-2/6 mr-6 rounded-2xl text-center">
                        <p class="text-5xl mt-3">66 <span class="text-base">DH</span></p>
                    </div>
                    <input type="submit" class=" bg-black text-white text-lg text-bold w-4/6 rounded-2xl h-20">
                </div>
            </form>
        </div>
    </div>
</div>


</body>

</html>