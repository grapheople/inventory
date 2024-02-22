<!DOCTYPE html>
<html lang="ko">
    <head>
        <#include "/common/head.ftl">
    </head>
    <body>
        <#include "/common/nav.ftl">
        <div>${item.id}</div>
        <div>${item.name}</div>
        <div>${item.description}</div>
        <div>${item.createdAt}</div>
    </body>
</html>