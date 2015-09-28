(function(window, $, undefined){
    var floorManageService = {
        attachEvent: function attachEvent() {
            /** Begin of createRecordBtn **/
            $('.adminAdd').on("click", function(){
                var $createModel = $('#AddGoodTypeModal');
                $createModel.modal({
                    backdrop: 'static'
                });
            });
        },
        init: function init() {
            this.attachEvent();
        }
    }

    floorManageService.init();

}(window || this, jQuery, undefined));
