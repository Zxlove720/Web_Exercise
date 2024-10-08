package com.wzb.File20241008;

public class FileExercise {
    public static void main(String[] args) {
        // 文件上传
        // 文件上传是指将本地文件（包括但不限于图片、视频、音频等）上传到服务器，提供其他用户浏览或下载的过程

//         文件上传前端需要完成的准备
//         需要提交一个form表单，表单必须包含以下三点（上传文件页面三要素）
//         1.必须具有file域，file域是用于选择需要上传的文件 <input type="file" name="image"/>
//         2.表单的提交方式必须为post --因为通常上传的文件相对较大，所以说需要使用post的方式提交
//         3.表单的编码类型enctype必须为：multipart/form-data
//         因为默认的编码格式是不适合传输大型的二进制文件的----假如说使用默认的编码，传输的并不是文件的内容，而是文件名
//         所以说在文件上传的时候enctype的编码必须设置为multipart/form-data，这样才可以正确的传输文件到服务端
//
//
//         文件上传后端需要完成的准备
//         1.先在服务端定义一个controller用于文件上传，然后在controller中定义一个方法处理/upload请求
//         2.在定义的方法中接收提交过来的数据（方法中的形参名和请求参数的名字保持一致）----Spring中提供了一个API：MultipartFile
//         这个API可以用来接收上传的文件。MultiPartFile需要定义在方法的参数列表中，并且其实体类名必须和前端file域的名字相同
//
//         若表单项的名字和方法中的形参名不一样怎么办？
//         可以使用@RequestParam注解进行参数绑定（虽然可以完成需求，但是建议将二者的名字写成一样的）


    }
}
