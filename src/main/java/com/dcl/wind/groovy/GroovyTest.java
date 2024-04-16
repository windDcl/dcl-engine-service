package com.dcl.wind.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

public class GroovyTest {
    public static void main(String[] args) throws Exception {
        String groovyCode = "package com.dcl.wind.groovy\n" +
                "\n" +
                "import groovy.util.logging.Slf4j\n" +
                "\n" +
                "@Slf4j\n" +
                "class Person {\n" +
                "    def String sayName1(String name) {\n" +
                "        log.error(\"hahahaha\")\n" +
                "        return \"hello \" + name\n" +
                "    }\n" +
                "\n" +
                "    def String sayName2(String name, String suffix) {\n" +
                "        return name + \" \" + suffix\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    def int add(int a, int b) {\n" +
                "        return a + b\n" +
                "    }\n" +
                "}\n";
        GroovyClassLoader classLoader = new GroovyClassLoader();
        Class groovyClass = classLoader.parseClass(groovyCode);
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();

        String param1 = "dcl";
        String[] param2 = {"dcl", "wind"};
        Integer[] param3 = {8, 7};

        Object result1 = groovyObject.invokeMethod("sayName1", param1);
        // 需要方法如果需要两个参数就传一个数组
        Object result2 = groovyObject.invokeMethod("sayName2", param2);
        Object result3 = groovyObject.invokeMethod("add", param3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
