(function(window, $, undefined){
    var checkoutRoomService = {
        attachEvent: function attachEvent() {
            /** Begin of createRecordBtn **/
            $('.checkoutSheet').on("click", function(){
                var $createModel = $('#CheckoutSheetModal');
                $createModel.modal({
                    backdrop: 'static'
                });
            });
        },
        init: function init() {
            this.attachEvent();
        }
    }

    checkoutRoomService.init();

}(window || this, jQuery, undefined));
