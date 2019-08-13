
/***
 * 加密
 * @param element
 */
function encryption(element){
	element.value = hex_md5(element.value)
}