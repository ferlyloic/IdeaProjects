<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dailyReport.label', default: 'DailyReport')}" />
        <script src="https://cdn.ckeditor.com/4.9.1/standard/ckeditor.js"></script>
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-dailyReport" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-dailyReport" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.dailyReport}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.dailyReport}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.dailyReport}" method="POST">
                <fieldset class="form">
                    %{--<f:all bean="dailyReport"/>--}%

                        <f:field bean="dailyReport" property="titel"/>
                        <f:field bean="dailyReport" property="date"/>
                        %{--<f:field bean="dailyReport" property="description"/>--}%
                    <label>description</label><br>
                    <textArea name="description"></textArea>
                    <script>
                        CKEDITOR.replace( 'editor1' );
                    </script>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
