<!DOCTYPE html>
<html lang="en">


<head>

    <meta charset="utf-8"/>
    <title>Create</title>


</head>
<style>
    body {
        background-color: white;
        margin: 0px auto;
        border: 20px solid purple;
        border-image: linear-gradient(135deg, purple, yellow);
        border-image-slice: 1;
    }
</style>

<body>

<textarea id="code_snippet">// write your code here</textarea>
<br>

Time restriction :<input id="time_restriction" type="text"/>
<br>
View restriction :<input id="views_restriction" type="text"/>
<br>
<br>
<button id="send_snippet" type="submit" onclick="send()">Submit</button>

<script type="text/javascript">
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value,
            "time": document.getElementById("time_restriction").value,
            "views": document.getElementById("views_restriction").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status === 200) {
            alert("Success!");
        }
    }
</script>
</body>
</html>

