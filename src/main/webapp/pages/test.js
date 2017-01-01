"use strict"

function changeImage()
{
	element=document.getElementById('bt')
	if (element.src.match("bird"))
 	{
  		element.src="turtle.jpg";
  	}
	else
   {
  		element.src="bird.jpg";
   }
}

function writeText()
{
	document.getElementById('pOut').innerHTML="<a href='http://www.baidu.com'>百度一下</a>";
}

function buiduSearch()
{
	document.getElementById('baiduLink').href="https://www.baidu.com/s?word=123";
}

function setLink()
{
	document.getElementById('baiduLink').href="https://www.baidu.com/s?word="+document.forms["inputSearchContent"]["content"].value;
	return "https://www.baidu.com/s?word=123";
}

function startTime(){
	document.getElementById('showDate').innerHTML=new Date();
	setTimeout(function(){startTime()},500);
}