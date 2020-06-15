<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>New post</title>
</head>
<body>
<form method="post">
    <label>
        <p>
            <input name="title" type="text" placeholder="Title">
        </p>
    </label>
    <label>
        <p>
            <textarea name="content" placeholder="Article"></textarea>
        </p>
    </label>
    <p>
        <input name="photoPath" type="file" placeholder="Photos">
    </p>
    <label>
        <p>
        <input name="youTubeLink" type="url" placeholder="YouTube video link">
        </p>
    </label>
    <p>
        Choose more suitable type:
        <label>
            <select name="postType">
                <option value="NEWS" selected>News</option>
                <option value="CUSTOM">Custom</option>
                <option value="OVERVIEW">Overview</option>
                <option value="GUIDE">Guide</option>
            </select>
        </label>
    </p>
    <input type="submit" value="Send">
</form>
</body>
</html>