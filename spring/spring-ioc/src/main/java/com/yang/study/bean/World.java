package com.yang.study.bean;

/**
 * Created by fuyang on 2018/6/30.
 */
public class World {

    private String word;
    private Hello  hello;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Hello getHello() {
        return hello;
    }

    public void setHello(Hello hello) {
        this.hello = hello;
    }

    public World(Hello hello, String word) {
        this.word = word;
        this.hello = hello;
    }

    public World(){

    }
}
