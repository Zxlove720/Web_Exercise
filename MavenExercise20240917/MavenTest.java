package MavenExercise20240917;

public class MavenTest {
    public static void main(String[] args) {
        /* 依赖：当前项目运行所需要的jar包称为依赖，一个项目中可以引入多个依赖 */

        /* 引入依赖：
                    1.在pom.xml中编写标签<dependencies>标签
                    2.在<dependencies>标签中使用<dependency>引入依赖包的坐标
                    3.定义坐标的groupId */
        /*

        * <dependencies>
    <!-- 第1个依赖 : logback -->
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
        <version>1.2.11</version>
    </dependency>
    <!-- 第2个依赖 : junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
    </dependency>
</dependencies>

        * */
    }
}
