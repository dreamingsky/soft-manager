package com.young;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private String name;
    private String code;


    private AppTest(ComputerBuilder builder){
        this.name = builder.name;
        this.code =  builder.code;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Rigorous Test :-)
     */
    public void shouldAnswerWithTrue()
    {

        assertTrue( true );
    }





    public static void main(String[] args){


        String s1 = "abc";

        String s2 = new String("abc");
        AppTest appTest = new AppTest(new ComputerBuilder());


        System.out.println(s1);
        System.out.println(s2);
        System.out.println(appTest.convert(s2));

        System.out.println(s2);

    }



    public String convert(String s2){
        System.out.println(s2);
        s2 = "122a";
        return s2;
    }


    //快速排序
    public void sortQuick(int[] nums){

        int[] a = new int[]{1,2,3};




    }


    //冒泡排序
    public void maopaoSort(int[] nums){

    }

    //建造者模式

    static class ComputerBuilder{

        private String name;
        private String code;

        public ComputerBuilder setName(String name){
            this.name = name;
            return this;
        }

        public ComputerBuilder setCode(String code){
            this.code = code;
            return this;
        }


        public AppTest build(){
            return new AppTest(this);
        }



    }



}
