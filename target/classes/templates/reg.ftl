<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Add new user
    ${messages!}
    <@l.login "/reg" />
</@c.page>