<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="3D Objects/Jee WebApps/Sbahia/src/main/webapp/script.js"></script>
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
            <button class="rounded-2xl w-52 h-14 bg-yellow-100" onclick="insertForm()">Add</button>
        </div>
        <!-- Cards -->
        <dir class="h-2 w-full"></dir>

        <div class="width w-full mx-auto grid grid-cols-3 gap-10">
            <!-- Card -->
            <c:forEach items="${articleCarte}" var="a">
                <div class="border-2 border-light-blue-500 border-opacity-25 rounded-2xl w-100 h-72 relative">
                    <!-- image -->
                    <div class="w-4/5 h-44 bg-gray-600 mx-auto mt-6 relative">
                        <!-- Delete -->
                        <a href="Delete.test?id=${a.getIdArticle()}"
                           class="absolute rounded-2xl  top-2 right-2 h-14 w-14 bg-gray-100">
                            <div class="mx-auto py-3 w-2/4">
                                <svg width="26" height="28" viewBox="0 0 18 20" fill="none"
                                     xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd"
                                          d="M17.2871 3.24297C17.6761 3.24297 18 3.56596 18 3.97696V4.35696C18 4.75795 17.6761 5.09095 17.2871 5.09095H0.713853C0.32386 5.09095 0 4.75795 0 4.35696V3.97696C0 3.56596 0.32386 3.24297 0.713853 3.24297H3.62957C4.22185 3.24297 4.7373 2.82197 4.87054 2.22798L5.02323 1.54598C5.26054 0.616994 6.0415 0 6.93527 0H11.0647C11.9488 0 12.7385 0.616994 12.967 1.49699L13.1304 2.22698C13.2627 2.82197 13.7781 3.24297 14.3714 3.24297H17.2871ZM15.8058 17.134C16.1102 14.2971 16.6432 7.55712 16.6432 7.48913C16.6626 7.28313 16.5955 7.08813 16.4623 6.93113C16.3193 6.78413 16.1384 6.69713 15.9391 6.69713H2.06852C1.86818 6.69713 1.67756 6.78413 1.54529 6.93113C1.41108 7.08813 1.34494 7.28313 1.35467 7.48913C1.35646 7.50162 1.37558 7.73903 1.40755 8.13594C1.54958 9.89917 1.94517 14.8102 2.20079 17.134C2.38168 18.846 3.50498 19.922 5.13206 19.961C6.38763 19.99 7.68112 20 9.00379 20C10.2496 20 11.5149 19.99 12.8094 19.961C14.4929 19.932 15.6152 18.875 15.8058 17.134Z"
                                          fill="#FF6868"/>
                                </svg>
                            </div>
                        </a>
                    </div>
                    <button
                            onclick="updateForm()" id="updateBTN"
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
        <div class="w-full h-20"></div>


        <div class="w-5/6 mx-auto">
            <!--  -->
            <div class="flex">
                <h1>Add new item</h1>
                <div class="w-10 h-10 bg-green-100 ">+</div>
            </div>
            <!--  -->
            <form method="post" action="Ajouter.test" enctype="multipart/form-data" class="relative" id="formArticle">
                <input type="text" name="Name" id="updateName" class="w-full rounded-lg h-16 bg-gray-100 mt-24">
                <div class="flex">
                    <input type="number" name="Price" id="updatePRICE" class="w-1/2 rounded-lg h-16 bg-gray-100 mt-6">
                    <input type="number" name="Qte" id="updateQTE" class="w-1/2 rounded-lg h-16 bg-gray-100 mt-6 ml-6">
                    <input type="hidden" name="IdArticle" id="updateID" value="">
                </div>
                <textarea type="text" name="Desc" id="updateDESC"
                          class="w-full rounded-lg h-48 bg-gray-100 mt-6"></textarea>

                <dir class="mt-6"></dir>
                <div
                        class="w-full h-36 border-dashed border-2 border-light-blue-500 bg-white rounded-2xl text-center ">
                    <p class="mt-4">Select image to upload:</p>
                    <input type="file" name="fileToUpload" id="fileToUpload" class="w-28 mt-4">
                </div>
                <!-- Blanck -->
                <dir class="h-8"></dir>
                <input type="submit" class=" bg-black text-white text-lg text-bold w-full rounded-2xl h-20">
            </form>
        </div>
    </div>
</div>


</body>

</html>