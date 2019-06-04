
//pc nav start
var lastActiveNav = 1;
//pc nav end
//phone nav start
var headerPanel_init = {
    "current_left": -180,
    "current_status": "0",
    "preceed_static": 10,
    "width": 180,
    "height": 280,
    "top": 56
};
function header_left_change() {
    if(headerPanel_init.current_status == "0") { //关闭状态
        var endLeft = 0;
        var currentLeft = headerPanel_init.current_left;
        var st = setInterval(function() {
            if(currentLeft < endLeft && currentLeft+headerPanel_init.preceed_static < endLeft) {
                currentLeft += headerPanel_init.preceed_static;
                $("#headerPanel_id").css("left", currentLeft + "px");
            } else if(currentLeft >= endLeft) {
                clearInterval(st);
                headerPanel_init.current_left = 0;
                headerPanel_init.current_status = "1";
                show_shade();
            } else {
                currentLeft = endLeft;
                $("#headerPanel_id").css("left", currentLeft + "px");
            }
        }, 10);
    } else if(headerPanel_init.current_status == "1") { //打开转态
        var endLeft = -180;
        var currentLeft = headerPanel_init.current_left;
        var st = setInterval(function() {
            if(currentLeft > endLeft && currentLeft-headerPanel_init.preceed_static > endLeft) {
                currentLeft -= headerPanel_init.preceed_static;
                $("#headerPanel_id").css("left", currentLeft + "px");
            } else if(currentLeft <= endLeft) {
                clearInterval(st);
                headerPanel_init.current_left = -180;
                headerPanel_init.current_status = "0";
                hide_shade();
            } else {
                currentLeft = endLeft;
                $("#headerPanel_id").css("left", currentLeft + "px");
            }
        }, 10);
    }
}
//phone nav end

function show_shade() {
	$(".phone_shade").addClass("modal-backdrop fade in phone_shade_show");
}

function hide_shade() {
	$(".phone_shade").removeClass("modal-backdrop fade in phone_shade_show");
	$(".phone_shade").addClass("phone_shade_hide");
}

$(function() {

    //phone nav start
    $("#headerMenu_id").bind("click", header_left_change);
    $("body").bind("click", function(event) {
        if(headerPanel_init.current_status == "1" && 
        		((event.clientX > headerPanel_init.width && event.clientY > headerPanel_init.top)
        	 || (event.clientX < headerPanel_init.width && event.clientY > headerPanel_init.top + headerPanel_init.height))) {
            header_left_change();
        }
    });
    //phone nav end

    //pc nav start
    $(".pc_nav .navbar-nav").find("li").each(function() {
        $(this).bind("click", function() {
            var lastActive = $("li[data-tp="+lastActiveNav+"]");
            lastActive.removeClass("active");
            $(this).addClass("active");
            lastActiveNav = $(this).attr("data-tp");
        });
    });
    //pc nav end
    
    asyncGetTopics();
    asyncGetTopicsOfOrder("order_info", 15);
    
});

function asyncGetTopicsOfOrder(applyTo, count) {
	if(!$("#" + applyTo)) return;
	$apply = $("#" + applyTo);
	var url = "/topicOrder";
	var param = {
		"start": 0,
		"count": count||15
	}
	$.ajax({
		"url": url,
		"data": JSON.stringify(param),
		"dataType": "JSON",
		"type": "POST",
		"contentType": "application/json",
		"success": function(data, status) {
			if(data.code) {
				var dt = data.root;
				var tdiv = jQuery("<div></div>");
				tdiv.addClass("header");
				tdiv.text("阅读排行");
				var uls = jQuery("<ul></ul>");
				uls.addClass("media-list");
				uls.addClass("message_content");
				dt.forEach(function(val, idx) {
					var lis = jQuery("<li></li>");
					lis.addClass("media");
					 var divLeft = jQuery("<div></div>");
					 divLeft.addClass("media-left");
					  var imga = jQuery("<a></a>");
					  imga.attr("href", val.topic_url);
					  imga.attr("target", "_blank");
					   var img = jQuery("<img></img>");
					   img.addClass("media-object");
					   img.attr("src", val.topic_imgpath);
					   img.attr("alt", "... ...");
					lis.append(divLeft);
					divLeft.append(imga);
					imga.append(img);
					 var divRight = jQuery("<div></div>");
					 divRight.addClass("media-body");
					  var ah4 = jQuery("<a></a>");
					  ah4.attr("href", val.topic_url);
					  ah4.attr("target", "_blank");
					   var righth4 = jQuery("<h5></h5>");
					   righth4.addClass("media-heading");
					   righth4.text(val.topic);
					  var pdiv = jQuery("<div></div>");
					  pdiv.addClass("p");
					  pdiv.text(val.topic_content);
					lis.append(divRight);
					divRight.append(ah4);
					ah4.append(righth4);
					divRight.append(pdiv);
					uls.append(lis);
				});
				
				$apply.html("");
				$apply.append(tdiv);
				$apply.append(uls);
			}
		},
		"error": function(data, status) {
		}
	});
}

/*info_message start*/
function asyncGetTopics() {
	/*home type 0*/
	asyncGetTopic("home", "0", 5);
	/*profile type 1*/
	asyncGetTopic("profile", "1", 5);
	/*messages type 2*/
	asyncGetTopic("messages", "2", 5);
}

function asyncGetTopic(applyTo, type, count, start) {
	var $apply = $("#" + applyTo);
	var url = "/topics";
	var param = {
		"topic_type": type,
		"start": start||0,
		"count": count
	}
	$.ajax({
		"url": url,
		"data": JSON.stringify(param),
		"dataType": "JSON",
		"type": "POST",
		"contentType": "application/json",
		"success": function(data, status) {
			if(data.code) {
				var dt = data.root;
				var uls = jQuery("<ul></ul>");
				uls.addClass("media-list");
				uls.addClass("message_content");
				dt.forEach(function(val, idx) {
					var lis = jQuery("<li></li>");
					lis.addClass("media");
					 var divLeft = jQuery("<div></div>");
					 divLeft.addClass("media-left");
					  var imga = jQuery("<a></a>");
					  imga.attr("href", val.topic_url);
					  imga.attr("target", "_blank");
					   var img = jQuery("<img></img>");
					   img.addClass("media-object");
					   img.attr("src", val.topic_imgpath);
					   img.attr("alt", "... ...");
					lis.append(divLeft);
					divLeft.append(imga);
					imga.append(img);
					 var divRight = jQuery("<div></div>");
					 divRight.addClass("media-body");
					  var ah4 = jQuery("<a></a>");
					  ah4.attr("href", val.topic_url);
					  ah4.attr("target", "_blank");
					   var righth4 = jQuery("<h4></h4>");
					   righth4.addClass("media-heading");
					   righth4.text(val.topic);
					  var pdiv = jQuery("<div></div>");
					  pdiv.addClass("p");
					  pdiv.text(val.topic_content);
					  var fdiv = jQuery("<div></div>");
					  fdiv.addClass("f");
					  fdiv.text(val.topic_date + " " + "(" + val.topic_click + ")人看过");
					lis.append(divRight);
					divRight.append(ah4);
					ah4.append(righth4);
					divRight.append(pdiv);
					divRight.append(fdiv);
					
					uls.append(lis);
					
				});
				
				var puls = jQuery("<ul></ul>");
				puls.addClass("pager");
				
				var liprev = jQuery("<li></li>");
				var preva = jQuery('<a onclick=prev("'+applyTo+'",'+type+','+data.start+','+data.count+','+data.page+','+data.mount+')></a>');
				preva.attr("href", "javascript:;");
				preva.text("上一页");
				/*preva.bind("click", function(applyTo, type, start, count, page, mount) {
					if(start == 0) return;
					asyncGetTopic(applyTo, type, count, start-1);
				});*/
				liprev.append(preva);
				
				var linext = jQuery("<li></li>");
				var nexta = jQuery('<a onclick=next("'+applyTo+'",'+type+','+data.start+','+data.count+','+data.page+','+data.mount+')></a>');
				nexta.attr("href", "javascript:;");
				nexta.text("下一页");
				/*nexta.bind("click", function(applyTo, type, start, count, page, mount) {
					if(start == page) return;
					asyncGetTopic(applyTo, type, count, start+1);
				});*/
				linext.append(nexta);
				
				puls.append(liprev);
				puls.append(linext);
				
				$apply.html("");
				$apply.append(uls);
				$apply.append(puls);
				
			}
		},
		"error": function(data, status) {
		}
	});
	
}
var prev = function(applyTo, type, start, count, page, mount) {
	if(start == 0) return;
	asyncGetTopic(applyTo, type, count, start-1);
}
var next = function(applyTo, type, start, count, page, mount) {
	if(start == page) return;
	asyncGetTopic(applyTo, type, count, start+1);
}
/*info_message end*/
