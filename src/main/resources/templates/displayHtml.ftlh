<!DOCTYPE html>
<html lang="en">
<head>
    <title>Code</title>
    <meta charset="UTF-8">

    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<style>
    #load_date{
        color: MediumSeaGreen;
    }

    pre {
        background-color: LightGray;
        border-style: solid
    }

    body {
        background-color: white;
        margin: 0px auto;
        border: 20px solid purple;
        border-image: linear-gradient(135deg, purple, yellow);
        border-image-slice: 1;
    }
</style>

<body>

<span id="load_date">  ${displayCode.dateFormatted}</span>
<br>
<#if displayCode.restrictionsOnViews && displayCode.views ==0>
    <span id="views_restriction">No more views allowed </span>
<#elseif displayCode.views gt 0>
    <span id="views_restriction">${displayCode.views} more views allowed </span>
</#if>
<br>
<#if displayCode.time gt 0>
    <span id="time_restriction"> This code will be available for ${displayCode.time} seconds </span>
</#if>
<pre id="code_snippet"><code> ${displayCode.userCode} </code></pre>
</body>
</html>