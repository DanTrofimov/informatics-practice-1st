var root = document.querySelector(':root');
var rootStyles = getComputedStyle(root);
var mainColor = rootStyles.getPropertyValue('--main-color');
console.log("first --main-color is: ", mainColor);

var button = document.querySelectorAll("button");
button[0].addEventListener("click", function(event) {
	root.style.setProperty("--main-color", "#a1b9f7")
	console.log(rootStyles.getPropertyValue('--main-color'));
})
button[1].addEventListener("click", function(event) {
	root.style.setProperty("--main-color",  "#ff6f69");
	console.log(rootStyles.getPropertyValue('--main-color'));
})

// getting divs from html
var divs = document.getElementsByTagName('div');
console.log(divs.length);