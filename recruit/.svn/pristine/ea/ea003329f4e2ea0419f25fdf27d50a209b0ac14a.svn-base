ToCandidate = {
	resumeIds: "",
	init: function() {
		$("#resumeChannel").hide();
		$('input[name="isChannel"]').change(function() {
			if($('input[name="isChannel"]:checked').val() == 1){
				$("#resumeChannel").show();
			}else{
				$("#resumeChannel").hide();
			}
		});
		$("#confirmCandidate").click(ToCandidate.addToCandidate);
	},
	addToCandidate: function() { // 发送请求
		$.ajax({
	        url: basePath + "/resume/addToCandidate",
	        type: "POST",
	        dataType: "json",
	        data: {"resumeIds": ToCandidate.resumeIds,"channel" : ToCandidate.getChannel()},
	        success: function(msg) {
	        	msg.success ? ToCandidate.ajaxSuccess() : opResult(msg);
	        },
	        error: function(msg) {
	        	opResult(msg);
	        }
	    });
	},
	getChannel: function() { // 获取渠道 
		var _channel = null;
		var _isChannel = $('input[name="isChannel"]:checked').val();
		if(_isChannel == "1"){
			_channel = $("#resumeChannel").val();
		}
		return _channel;
	},
	ajaxSuccess: function() {}
};
