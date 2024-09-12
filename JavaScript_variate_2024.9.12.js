/*
        JavaScript的很多语法和Java相似，但是变量的声明却和Java截然不同
        JavaScript主要通过3个关键字声明变量

        1.var：早期ECMAScript5中用于声明变量的关键字，var声明的变量类似于全局变量，作用域极广
        2.let：ECMScript6中新的声明变量的关键字，相较于var而言，let只在代码块内生效
        3.const：用于声明常量，常量一旦声明，不能更改，若更改则报错

        变量命名规则：和Java一致
*/

// var name = "张三";
// alert(name); /* 浏览器弹出警告，内容是张三 */


/* JavaScript是一种弱类型的语言，就算定义a变量，初始化是一个数字，但给a用字符串赋值，也会正确输出 */
// var a = 10;
// /* typeof函数可以查看变量的类型 */
// alert(typeof(a)); /* 此处a的类型还是number */
// a = "李四";
// alert(typeof(a)); /* 此处a的类型变成了string */
// alert(a);


/* 使用let来定义变量的用法类似于var，但是声明的变量只有在let所在的代码块中有效，并且let不允许重复赋值 */
// let a = 12;
// console.log(a);

/* 重复声明let，报错 */
// let a = "张三";
// let a = 10;
// alert(a);

// {
//     let a = 10
// }
// /* let的作用域在代码块中，所以说代码块外无法使用a */
// alert(a);
