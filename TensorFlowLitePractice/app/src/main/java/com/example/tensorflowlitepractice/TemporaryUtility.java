package com.example.tensorflowlitepractice;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TemporaryUtility {

    public static HashSet<String> recycables = new HashSet<String>(){{
        add("PAPER");
        add("CARDBOARD");
        add("WATER BOTTLE");
        add("BEER BOTTLE");
        add("CAN");
        add("CARTON");
        add("BOTTLE");
        add("CUP");
    }};

    public static HashSet<String> compostables = new HashSet<String>(){{
        add("PAPER");
        add("CARDBOARD");
        add("VEGETABLE");
        add("FRUIT");
        add("APPLE");
        add("BANANA");
        add("BROCCOLI");
    }};

    public static HashSet<String> currentRecyclables = new HashSet<String>();
    public static HashSet<String> currentCompostables = new HashSet<String>();

}
