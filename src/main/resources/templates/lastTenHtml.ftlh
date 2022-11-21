<!DOCTYPE html>
<html lang="en">
<head>
    <title>Latest</title>
    <meta charset="UTF-8">
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<style>
    body {
        background-color: white;
        margin: 0px auto;
        border: 20px solid purple;
        border-image: linear-gradient(135deg,purple,yellow);
        border-image-slice: 1;
    }
</style>
<style>
    span {
        color: MediumSeaGreen;
    }

    pre {
        background-color: LightGray;
        border-style: solid
    }
</style>
<body>
<div>
    <#list codesToDisplay as x>
<span id="load_date">  ${x.dateFormatted}</span>
<pre id="code_snippet"><code>${x.userCode} </code> </pre>
    </#list>
</div>
</body>
</html>