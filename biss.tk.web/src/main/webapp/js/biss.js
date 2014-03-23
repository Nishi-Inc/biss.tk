// Depends on JQuery, bootbox and bootstrap. Make sure to include these js prior including this one

var body = $('body');
$(document).ready(function(event) {

    $(body).on('click', '.goto-action', function(e) {
        window.location.href = $(this).attr('data-url');
    });

    $(body).on('click', '.leave-site-action', function(e) {
//        It is because JS can close the window which is opened by JS
        open(window.location, '_self').close();
    });

    $(body).on('keyup', 'input#game-name', function(e) {
        if($(this).val().length > 0) {
            $(body).find('#create-new-game-modal-container').find('#createNewGameModalLabel').html($(this).val());
        } else {
            $(body).find('#create-new-game-modal-container').find('#createNewGameModalLabel').html("New Game");
        }
    });

    $(body).on('mouseover', '.leave-site-action.btn', function(e) {
        $(this).removeClass('btn-default');
        $(this).addClass('btn-danger');
    });

    $(body).on('mouseout', '.leave-site-action.btn', function(e) {
        $(this).removeClass('btn-danger');
        $(this).addClass('btn-default');
    });

    $(body).on('click', 'input[type="text"].calendar', function(e) {
        var calendarInput = $(this);
        $(calendarInput).datepicker().on('changeDate', $(this).data('datepicker').hide());
    });


}); // End document ready
