package com.vytrack.utilities;

public class Library {

    public static void sleep(double seconds){

        try {

            Thread.sleep((long)(1000*seconds));

        }catch (Exception e){

        }

    }
}
