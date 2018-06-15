package com.learn.language.lambda;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

    public static void main(String[] args) {
        File dir = new File("./lambda/src/main/java/com/learn/language/lambda");

        // traditional way of implementing interface
//        FileFilter  fileFilter = new FileFilter() {
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java");
//            }
//        };

//        File[] files = dir.listFiles(fileFilter);

        // lambda expressions
//        FileFilter lambdaFileFilter = (File pathname) -> pathname.getName().endsWith(".java");
        FileFilter lambdaFileFilter = (pathname) -> pathname.getName().endsWith(".java");
        File[] files = dir.listFiles(lambdaFileFilter);

        if(files != null) {
            for (File f : files) {
                System.out.println(f.getName());
            }
        }
    }
}