(function(window, $, undefined){
    var checkinRoomService = {
        attachEvent: function attachEvent() {
        	 /** Begin of createRecordBtn **/
            $('.waiterCheckin').on("click", function(){
                var $createModel = $('#CheckinRoomModal');
                $createModel.modal({
                    backdrop: 'static'
                });
            });
        },
        init: function init() {
            this.attachEvent();
        }
    }

    checkinRoomService.init();

}(window || this, jQuery, undefined));
