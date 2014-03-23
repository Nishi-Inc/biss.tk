<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <jsp:include page="../includables/common-css.jsp" />
</head>
<body class="fixed-top">
<jsp:include page="../includables/header.jsp" />
<div class="container">
    <div class="status-alert alert alert-info" data-target-url="<s:property value="%{urlObject.url}" />">
        You are being redirected to <a href="<s:property value="%{urlObject.url}" />"><s:property value="%{urlObject.url}" /></a>.
    </div>

    <h2>Statistics</h2>
    <table class="table table-bordered table-striped table-hover centered row-fluid">
        <thead>
            <th>Attribute</th>
            <th>Value</th>
        </thead>
        <tbody>
            <tr>
                <td class="span4">Total visits</td>
                <td class="span8"><span class="span12 show-hits-list-action"><i class="icon caret-right"></i> <span class="btn btn-small btn-link"><s:property value="%{urlObject.statistics.totalHits}" /></span></span>
                    <ol class="hide span6">
                        <s:iterator value="urlObject.statistics.hits" var="visit">
                            <li><span class="btn btn-small btn-link"><s:property value="%{#visit.timeStamp.toString()}" /></span></li>
                        </s:iterator>
                    </ol>
                </td>
            </tr>
        </tbody>
    </table>
    <jsp:include page="../includables/footer.jsp" />
</div>
</body>

<script type="text/javascript">
    var redirection = setTimeout('window.location.href = "<s:property value='%{urlObject.url}' />";', 15000);

    $(document).ready(function() {
        $(body).on('click', 'table', function(e) {
            e.preventDefault();
            e.stopPropagation();

            window.clearTimeout(redirection);
            var statusAlert = $(body).find('.status-alert');
            $(statusAlert).html("Redirection is cancelled.<br/>Please <a href='" + $(statusAlert).attr('data-target-url') +
                    "'>click here</a> to go to <a href='" + $(statusAlert).attr('data-target-url') + "'>" +
                    $(statusAlert).attr('data-target-url') + "</a>.");
            $(statusAlert).removeClass('alert-info').addClass('alert-default');
        });

        $(body).on('click', '.show-hits-list-action', function(e) {
            $(this).find('i').removeClass('caret-right').addClass('caret-down');
            $(this).next('ol').removeClass('hide');
            $(this).removeClass('show-hits-list-action').addClass('hide-hits-list-action');
        });

        $(body).on('click', '.hide-hits-list-action', function(e) {
            $(this).find('i').removeClass('caret-down').addClass('caret-right');
            $(this).next('ol').addClass('hide');
            $(this).removeClass('hide-hits-list-action').addClass('show-hits-list-action');
        });

    });

</script>

</html>
