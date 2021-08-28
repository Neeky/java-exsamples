package org.example;

import java.lang.Override;

public class Coder implements Worker {

    @Override
    public String doWork() {
        return "System.out.println(\"hello java\")";
    }
}
