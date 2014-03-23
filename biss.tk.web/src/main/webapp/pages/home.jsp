<%@taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <jsp:include page="includables/common-css.jsp" />
  </head>
  <body class="fixed-top">
    <jsp:include page="includables/header.jsp" />
    <div class="container">
        <form class="ajax" id="url-form" method="post" action="#">
            <div class="control-group">
                <label for="url-input" class="control-label">Enter Url</label>
                <input type="text" id="url-input" class="controls url-input" name="url" placeholder="Your URL to shorten" required>
            </div>

            <div class="control-group">
                <label for="url-output" class="control-label">Enter Url</label>
                <input type="text" id="url-output" class="controls url-output" name="url" placeholder="Short URL" disabled>
            </div>
        </form>
        <div class="btn-group">
            <button class="btn btn-default cancel-url-input">Cancel</button>
            <button class="btn btn-primary shorten-url-action" data-action-url="<s:url value='/shorten' />">Shorten</button>
        </div>
        <jsp:include page="includables/footer.jsp" />
    </div>
  </body>

<script type="text/javascript">

    $(document).ready(function() {

        $(body).on('click', '.cancel-url-input', function(e) {
            e.preventDefault();
            e.stopPropagation();

            $(body).find('#url-form').clear();
        });

        $(body).on('click', '.shorten-url-action', function(e) {
            e.preventDefault();
            e.stopPropagation();

            var submitBtn = $(this);
            $.ajax({
                url: $(submitBtn).attr('data-action-url'),
                type: 'post',
                dataType: 'html',
                async: true,
                data: {longUrl : $(body).find('#url-form').find('.url-input').val()},
                success: function(data) {
                    data = JSON.parse(data);
                    $(body).find('#url-form').find('.url-output').val(data.shortUrl);
                },
                error: function(e) {

                }
            });
        });

    }); // END DOCUMENT READY
</script>

</html>
