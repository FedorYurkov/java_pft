package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public  static  void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languges = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languges){
      System.out.println("I want to learn " + l);
    }

    for (int i = 0; i < languges.size(); i++){
      System.out.println("I want to learn " + languges.get(i));
    }


  }

}
