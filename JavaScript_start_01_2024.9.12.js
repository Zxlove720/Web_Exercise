/* 
    Web由三个部分组成：
        
        1.HTML（超文本标记语言）：HTML给网页完成了骨架的功能，使得网页能够初具雏形；
        2.CSS（层叠样式表）：CSS在HTML提供的骨架上，完成了对网页的美化，样式的调整
        
        但网页是死的，不能和用户进行交互，于是需要Web的第三个组成部分————JavaScript
        
        3.JavaScript：JavaScript使得网页能够动起来，根据用户的操作，和用户进行交互
        
        这三者结合，才是一个真正的、美观的、完整的网页

*/

/*
        JavaScript代码也是要依靠HTML的，因为HTML才是网页的骨架，在HTML中引入JavaScript代码，主要有两种方式
        
        一、内部脚本
        1.在HTML中有<script>标签，可以将JavaScript代码书写在script标签之中
        2.HTML文件中，可以在任意地方，放置任意数量的<script>标签
        3.但是为了效率，一般将<script>脚本置于<body>元素的底部，可以改善显示速度

        <script>
            alert("hello world")
        </script>

        二、外部脚本（建议使用）
        1.外部脚本将JavaScript代码定义在外部的.js文件之中，然后再引入到HTML文件中
        2.和外部的.CSS文件一样，.js文件只包含JavaScript代码，不含<script>标签
        3.引入外部的.js的<script>标签，必须闭合

        <script src="js/demo.js"></script>  必须闭合！！！！！
*/

/* alert("hello JavaScript"); */

/* 
        JavaScript语法
            JavaScript基本的语法和Java极其相似
            1.区分大小写，和Java一样，JavaScript大小写敏感，JavaScript代码中所有都区分大小写
            2.JavaScript每一行语句结束都需要加上分号
            3.大括号是JavaScript中的代码块
            4.注释：和Java一样
        
        JavaScript中三种输出语句
            window.alert()          在浏览器的window弹出警告框
            document.write()        在HTML（网页）中输出内容
            console.log()           在浏览器的控制台中写入内容

*/

/* 浏览器弹出警告窗口 */ 
window.alert("hello JavaScript");
/* alert前面的window可以省略 */
alert("hello world");

/* 浏览器中输出内容 */
document.write("hello JavaScript");

/* 浏览器的控制台中输出内容 */ 
console.log("write in console");

