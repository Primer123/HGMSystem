(function(window, $, undefined){
    var roomRecordService = {
        attachEvent: function attachEvent() {
        	 /** Begin of createRecordBtn **/
            $('.waiterAdd').on("click", function(){
                var $createModel = $('#ReservationModal');
                $createModel.modal({
                    backdrop: 'static'
                });
            });
        },
        init: function init() {
            this.attachEvent();
        }
    }

   roomRecordService.init();

}(window || this, jQuery, undefined));