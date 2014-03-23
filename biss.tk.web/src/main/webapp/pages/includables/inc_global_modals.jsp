<%@ taglib prefix="s" uri="/struts-tags" %>

<%-- Create new game popup --%>
<div id="create-new-game-modal-container" class="modal fade hide " tabindex="-1" role="dialog"
        aria-labelledby="createNewGameModalLabel" aria-hidden="true" >
    <div class="modal-header">
        <h2 id="createNewGameModalLabel" class="modal-title">New Game</h2>
        <span class="">We have filled out appropriate values. You can modify it to your liking.</span>
    </div>
    <div class="modal-body">
        <form id="create-new-game-form" class="ajax form-horizontal" method="post" action="#" role="form" >
            <div class="control-group">
                <label for="game-name" class="control-label">Name:</label>
                <div class="controls ">
                    <input type="text" id="game-name" name="game.name" class="form-control" placeholder="i.e. Aristocrats" title="Give your game a name" maxlength="20">
                </div>
            </div>

            <div class="control-group">
                <label for="max-player" class="control-label">Maximum players:</label>
                <div class="controls ">
                    <input type="text" id="max-player" name="game.maxNumberOfPlayers" class="form-control" placeholder="Not more than 5" title="Number of players to play at a time. Not more than 5."
                           value="4" pattern="[2-5]" maxlength="1" >
                </div>
            </div>

            <%--<div class="control-group">--%>
                <%--<label for="number-of-properties" class="control-label">Total properties:</label>--%>
                <%--<div class="">--%>
                    <%--<input type="text" id="number-of-properties" name="game.numberOfPrperties" class="form-control" placeholder="Not more than 5" title="Number of players to play at a time. Not more than 5."--%>
                           <%--value="4" pattern="[2-5]" maxlength="1" required>--%>
                <%--</div>--%>
            <%--</div>--%>

            <div class="control-group">
                <label for="initial-amount" class="control-label">Initial Amount:</label>
                <div class="controls ">
                    <input type="number" id="initial-amount" name="game.initialAmount" placeholder="Not more than 30,000 bucks" title="Amount each player would be having in her hands at the beginning of the game."
                           value="10000" maxlength="5" min="1000" max="30000" >
                </div>
            </div>

        </form>
    </div>

    <div class="modal-footer">
        <span class="btn btn-default" data-dismiss="modal" >Close</span>
        <span class="btn btn-primary save-new-game-action">Create</span>
    </div>
</div>


<%-- Ask question modal popup --%>
<div id="ask-question-modal-container" class="modal fade hide " tabindex="-1" role="dialog"
     aria-labelledby="questionModalLabel" aria-hidden="true" >
    <div class="modal-header">
        <h2 id="askQuestionModalLabel" class="modal-title">Question</h2>
    </div>
    <div class="modal-body">
        <form id="ask-question-form" class="ajax form-horizontal" method="post" action="#" role="form" >
            <div class="control-group">
                <label for="player-name" class="control-label">Your name:</label>
                <div class="controls ">
                    <input type="text" id="player-name" name="question.name" class="form-control" placeholder="Jack Sparrow" title="Write your name" maxlength="20">
                </div>
            </div>

            <div class="control-group">
                <label for="player-email" class="control-label">Your Email ID:</label>
                <div class="controls ">
                    <input type="email" id="player-email" name="question.email" class="form-control" placeholder="jack@blackpearl.ship" title="Your E-mail ID" required>
                </div>
            </div>

            <%--<div class="control-group">--%>
            <%--<label for="number-of-properties" class="control-label">Total properties:</label>--%>
            <%--<div class="">--%>
            <%--<input type="text" id="number-of-properties" name="game.numberOfPrperties" class="form-control" placeholder="Not more than 5" title="Number of players to play at a time. Not more than 5."--%>
            <%--value="4" pattern="[2-5]" maxlength="1" required>--%>
            <%--</div>--%>
            <%--</div>--%>

            <div class="control-group">
                <label for="question" class="control-label">Your Question:</label>
                <div class="controls ">
                    <textarea type="text" id="question" name="question.questionText" placeholder="Why is Government so mean?" title="Your question" rows="2" required ></textarea>
                </div>
            </div>

        </form>
    </div>

    <div class="modal-footer">
        <span class="btn btn-default" data-dismiss="modal" >Close</span>
        <span class="btn btn-primary ask-question-action">Ask</span>
    </div>
</div>
