<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Profile</title>
</head>
<body>
<div class="navbar-fixed">
    <nav>
        <div class="blue-grey nav-wrapper">
            <a href="/" class="brand-logo"><img src="https://img.icons8.com/cotton/48/000000/trainers.png"
                                                class="material-icons" alt="logo"/>Shifter</a>
            <ul class="right hide-on-med-and-down">
                <li><a href="/logout">Logout</a></li>
            </ul>
        </div>
    </nav>
</div>
<div class="container center-align" style="padding-top: 3%">
    <img src="${user.avatarPath}" alt="Avatar" style="height: 5%; width: 5%">
    <p>${user.nickName}</p>
    <p>${user.role}</p>
    <p>
        <a href="/favourite/${user.id}">Favourite posts</a>
    </p>
    <#if user.role.authority == "AUTHOR">
        <p>
            <a href="/myPosts">My posts</a>
        </p>
        <p>
            <a href="/newPost">Write new post</a>
        </p>
    </#if>
    <#if user.role.authority == "ORD_USER">
        <p>
        <a href="/becomeAuthor">Become an author</a>
        </p>
    </#if>
</div>
</body>
</html>