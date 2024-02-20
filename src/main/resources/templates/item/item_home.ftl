<!DOCTYPE html>
<html lang="ko">
<head>
    <#include "/common/head.ftl">
</head>
<body>
<ul>
    <#list items as item>
        <li style="margin-bottom: 10px;">
            <a href="/web/item/${item.id}">${item.name}</a>
        </li>
    </#list>
</ul>
</body>
</html>