/*
        JavaScript是弱类型的语言，但是其中也存在数据类型，JavaScript的数据类型分为：原始类型和引用类型
        这点和Java很像，主要有如下类型：

        1.number            数字（整数、小数、NaN（Not a Number））
        2.string            字符串，建议使用双引号
        3.boolean           布尔类型：true、false
        4.null              对象为空
        5.undefined         当声明的变量没有初始化时，该变量的默认值是undefined
*/
    /* 原始数据类型 */
    // alert(typeof 3); //number
    // alert(typeof 3.14); //number

    // alert(typeof "A"); //string
    // alert(typeof 'Hello');//string

    // alert(typeof true); //boolean
    // alert(typeof false);//boolean

    // alert(typeof null); //object 

    // var a ;
    // alert(typeof a); //undefined

    /*
        JavaScript运算符
        JavaScript中的运算符几乎和Java中一模一样，除了==和==
    */

        /* 使用==比较时，虽然a、b的数据类型都不一样，但是==会进行类型转换，然后再进行比较
        所以说下列代码最终会输出true */
        // let a = 10;
        // let b = "10";
        // if (a == b) {
        //     alert("true");
        // } else{
        //     alert("false")
        // }

        // /* 使用===比较时，是严格的完全相等，若二者类型不一样，那么将直接返回false */
        // let x = 65;
        // let y = "A";
        // // 在 JavaScript 中，== 运算符会进行类型转换，但它并不会将字符串 “A” 转换为其 ASCII 值 65。
        // // 相反，它会尝试将数字 65 转换为字符串 “65”，然后比较两个字符串 “65” 和 “A”。由于这两个字符串不相等，比较结果为 false。
        // alert(x==y); // false;
        // alert(x===y); // false;

        /*
            在JavaScript中，虽然是弱类型语言，但有时若涉及到数值计算，则需要类型转换
            parseInt()方法可以将其它类型的数据转换为number类型
        */
        alert(parseInt("12")) // 转化后得到数字12
        alert(parseInt("12A13")) // 转化后得到12，因为parseInt方法会从第一个非数字的地方截断
        alert(parseInt("A123")) // 转化后得到非数字NaN，因为从第一个非数字直接阶段，无法转化任何数据


        /*
            在JavaScript中————0、null、undefined、NaN都等价于false；反之则等价于true
         */

        if(0) {
            alert("0 is true")
        } else {
            alert("0 is false");
        }

        if (null) {
            alert("null is true");
        } else {
            alert("null is false");
        }

        if(undefined) {
            alert("undefined is true");
        } else {
            alert("undefined is false");
        }

        if(NaN) {
            alert("NaN is true");
        } else {
            alert("NaN is false");
        }


        
