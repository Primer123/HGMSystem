(function(window, $, undefined){
    var memberManageService = {
        attachEvent: function attachEvent() {
            /** Begin of createRecordBtn **/
            $('.adminAdd').on("click", function(){
                var $createModel = $('#AddMemberModal');
                $createModel.modal({
                    backdrop: 'static'
                });
            });
            
            var $updateModel = $('#UpdateMemberModal');
            
        },
        init: function init() {
            this.attachEvent();
        }
    }

    memberManageService.init();

}(window || this, jQuery, undefined));


function saveadd() {
	var add_form = document.all.add_form;
//	checkin_form.action = "checkinFormSearch";
	add_form.submit();
}



function saveupdate() {
	var update_form = document.all.update_form;
	update_form.submit();
	
	
}