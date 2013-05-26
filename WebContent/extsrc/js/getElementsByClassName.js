/*
鎺ュ彛鍚嶏細getElementsByClassName( node , classname )
鍙�鏁帮細node:鎼滅储璧风偣鐨勭粨鐐瑰厓绱�
classname:"class"灞炴�鐨剉alue
鍔�鑳斤細杩斿洖"class"鍏锋湁鐩稿悓鐨剉alue鍏冪礌鏁扮粍.

 */

function getElementsByClassName(node, classname) {
	//首先判断浏览器是否支持此方法
	if (node.getElementsByClassName) {
		//鏈塯etElementsByClassName()鏂规硶灏辩洿鎺ヤ娇鐢�
		return node.getElementsByClassName(classname); //杩斿洖鍏冪礌鏁扮粍闆嗗悎
	} else {
		var results = new Array();
		var elems = node.getElementsByTagName("*");
		for (var i = 0; i < elems.length; i++) {
			//寮�閬嶅巻鎵�湁鍏冪礌锛宨ndexOf()鐢ㄤ簬鏌ヨ鏄惁鏈夋classname鍊�
			if (elems[i].className.indexOf(classname) != -1) {
				//鎴戣寰楄繖涓猺esults.length鐢ㄥ緢绮惧阀锛屽氨鏄繖涓〃绀哄綋鍓嶅凡鏈夌殑鍏冪礌涓暟锛�
				//鍙堟槸涓嬩竴涓厓绱犵殑涓嬫爣锛屾墍浠ユ坊鍔犳柊鐨勫厓绱犮�
				results[results.length] = elems[i];
			}
		}
		return results;
	}
}
