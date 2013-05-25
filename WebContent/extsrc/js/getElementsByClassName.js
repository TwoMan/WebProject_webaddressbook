/*
接口名：getElementsByClassName( node , classname )
参 数：node:搜索起点的结点元素
classname:"class"属性的value
功 能：返回"class"具有相同的value元素数组.

 */

function getElementsByClassName(node, classname) {
	if (node.getElementsByClassName) {
		//有getElementsByClassName()方法就直接使用
		return node.getElementsByClassName(classname); //返回元素数组集合
	} else {
		var results = new Array();
		var elems = node.getElementsByTagName("*");
		for (var i = 0; i < elems.length; i++) {
			//开始遍历所有元素，indexOf()用于查询是否有此classname值
			if (elems[i].className.indexOf(classname) != -1) {
				//我觉得这个results.length用很精巧，就是这个表示当前已有的元素个数，
				//又是下一个元素的下标，所以添加新的元素。
				results[results.length] = elems[i];
			}
		}
		return results;
	}
}
