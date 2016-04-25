<html>
<head>
    <title> Patrons </title>
</head>
<body>
<div id="header">
    <h2>Please set your Name and Email </h2>
</div>
<div id="content">
    <fieldset>
        <legend>Add yourself:</legend>
        <form name="patron" action="/patrons/add " method="post">
            Name : <input type="text" name="patron_name"/><br/>
            Email: <input type="text" name="patron_email"/><br/>
            <input type="submit" value="Save"/>
        </form>
    </fieldset>
    <br/>
    <table class="datatable" border="0" style="border-style: dotted">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>

    <#--<#if patronsList??>-->

        <#list model["patronsList"] as patron>
            <tr>
                <td>${patron.name}</td>
                <td>${patron.email}</td>
            </tr>
        </#list>

    <#--<#else>-->
        <#--Nothing to show-->
    <#--</#if>-->

    </table>
    <a href="/patrons/csv" > as CSV </a>
</div>
</body>
</html>