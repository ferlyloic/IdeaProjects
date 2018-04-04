<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dailyReport.label', default: 'DailyReport')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-dailyReport" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-dailyReport" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
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
            <g:form name="myForm" resource="${this.dailyReport}" method="PUT">
                <g:hiddenField name="version" value="${this.dailyReport?.version}" />
                <fieldset class="form">
                    %{--<f:all bean="dailyReport"/>--}%

                    <f:field bean="dailyReport" property="titel"/>
                    <f:field bean="dailyReport" property="date"/>
                    %{--<f:field bean="dailyReport" property="description"/>--}%
                    <label>description</label><br>
                    <g:textArea name="description" value="${this.dailyReport?.description}"/>
                    <script>
                        CKEDITOR.replace( 'description' );
                    </script>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
            <g:form resource="${this.dailyReport}" method="DELETE">
                <fieldset class="buttons">
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
            <script type="text/javascript">
                window.onload=function(){
                    var auto = setTimeout(function(){ autoRefresh(); }, 100);

                    function submitform(){
                        // alert('test');
                        document.forms["myForm"].submit();
                    }

                    function autoRefresh(){
                        clearTimeout(auto);
                        auto = setTimeout(function(){ submitform(); autoRefresh(); }, 30000);
                    }
                }
            </script>
        </div>
    </body>
</html>
