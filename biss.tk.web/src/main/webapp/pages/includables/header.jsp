<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="navbar navbar-static-top row-fluid">
    <div class="navbar-inner">
        <div class="span6">
            <span class="brand goto-action" style="cursor: pointer" data-url="<s:url value='/' />">
                <%--<img src="../../images/favicon.png" class="span2 hidden-sm hidden-xs">--%>
                <%--<i class="span2 icon-fixed-width icon-usd icon-2x green"></i>--%>
                <span class="span8">
                    <h1>biss.tk</h1>
                </span>
            </span>
        </div>

        <%--<span class="badge" style="margin-top: 1.5%;"><s:property value="onlineUsers" /> players online</span>--%>

        <span class="pull-right btn btn-default leave-site-action"
              style="margin-top: 1.5%;" ><i class="icon icon-share-alt"></i> Leave</span>
    </div>

</div>
