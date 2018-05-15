var Header = function(d) {
	this.c = {};
	this.z = {
	  a : '#',
	  b : '/sys/auth/menutree',
	  c : 'post',
	  d : 'json',
	  e : ' .nav .models .menu-resource',
	  f : 'li',
	  g : 'active',
	  h : 'href',
	  i : ' .nav .models .models-item',
	  j : 'hover',
	  k : ' .nav .models',
	  l : ' .nav .models .line',
	  m : ' .nav .models .models-item.active',
	  n : 'px'
	};
	$.extend(this.c,d);
	this.id = this.z.a + this.c.id;
	this.init();
};
Header.prototype = {
	init: function() {
		this.getMenuData();
		this.eventBind();
		this.moveTocurrent();
	},
	getMenuData : function() { // 获取菜单数据  
	    var that = this;
		var URL = basePath + this.z.b;
	    $.ajax({
	        url : URL,
	        type : this.z.c,
	        async : false,
	        dataType : this.z.d,
	        cache : false,
	        success : function(d) {
	        	that.createMenu(d);
	        }
	    });
	},
	eventBind : function() { // 初始化一些事件
		var that = this;
		
	    // 设置被选中的菜单项
	    $(this.id + this.z.e).each(function(i) {
	    	var menu_name = $(this)[0].rev;
	    	if(currentPage) {
	    		if(currentPage == menu_name) {
	    			$(this).parents(that.z.f).toggleClass(that.z.g);
	    		}
	    	}
	    	else {
	    		var url = window.location.pathname;
	    		var href = $(this).attr(that.z.h);
	    		if(url == href) {
	    			$(this).parents(that.z.f).toggleClass(that.z.g);
	    		}
	    	}
	    });
	    
		// 下划线移动
		$(this.id + this.z.i).on(this.z.j,function(){
		    var w = $(this).outerWidth();
		    var l = $(this).offset().left;
		    that.moveLine(w,l);
		});
		
		// 下划线复原
		$(this.id + this.z.k).mouseleave(function(){
			that.moveTocurrent();
		});
	},
	moveLine : function(w,l) { // 移动下划线
		$(this.id + this.z.l)[0].style.width = w + this.z.n;
		$(this.id + this.z.l)[0].style.left = l + this.z.n;
	},
	moveTocurrent : function() { // 移动下划线到当前选中
		var active = $(this.id + this.z.m);
		if(active.length > 0) {
			var width = $(active).outerWidth();
			var left = $(active).offset().left;
			this.moveLine(width,left);
		}
		else {
			this.moveLine(0,0);
		}
	},
	createMenu : function(d){
		
		if(d && d.length > 0) {
			var html = "";
			var a = "url"; 
			var b = "menuName"; 
			var c = "children";
			var e = "</a>";
			var f = "</a></li>";
			var g = "'>";
			var h = "</ul>";
			var l = "</li>";
			var m = "' rev='";
			var n = "name";
			var o = "";
			var p = "<li class='models-item'><a class='menu-resource' href='";
			var q = "<div class='models-item-sub'><ul>";
			var r = "<li class='models-item-sub-menu'><a class='menu-resource models-item-sub-menu-text";
			var s = "<ul class='models-item-sub-menu-sub'>";
			var t = "<li class='models-item-sub-menu-sub-item'><a class='menu-resource' href='";
			var u = "<li class='models-item-sub-item'><a class='menu-resource' href='";
			var v = "javascript:void(0);";
			var w = "</div>";
			var z = " .nav .models";
			for(var i = 0; i < d.length; i++) { // 第一层
				var url1 = v;
	            d[i][a] ? url1 = basePath + d[i][a] : o;
				html += p + url1 + m + d[i][n] + g + d[i][b] + e;
				var dd = d[i][c];
		        if(dd && dd.length > 0) {
		        	html += q;
		        	for(var j = 0; j < dd.length; j++) { // 第二层
		        		var ddd = dd[j][c];
		        		if(ddd && ddd.length > 0) {
		        			html += r + m + dd[j][n] + g + dd[j][b] + e;
		        			html += s;
		        			for(var k = 0; k < ddd.length; k++) { // 第三层
		        				var url3 = v;
		        				ddd[k][a] ? url3 = basePath + ddd[k][a] : o;
		        				html += t + url3 + m + ddd[k][n] + g + ddd[k][b] + f;
		        			}
		        			html += h + l;
		        		}
		        		else {
		        			var url2 = v;
		    	        	dd[j][a] ? url2 = basePath + dd[j][a] : o;
		        			html += u + url2 + m + dd[j][n] + g + dd[j][b] + f;
		        		}
		        	}
		        	html += h + w;
		        }
				html += l;
			}
			$(this.id + z).append(html);
		}
	}
};