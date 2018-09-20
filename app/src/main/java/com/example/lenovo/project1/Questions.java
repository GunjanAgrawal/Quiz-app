package com.example.lenovo.project1;

/**
 * Created by lenovo on 22-07-2018.
 */

public class Questions {
    public String questions[] ={
            "2+2=?",
            "Which is not a programming language?",
            "Each statement in c++ ends with ____",

           };

    public String choices[][]={
            {"2","4","8"},
            {"java","python","english"},
            {"semicolon","colon","comma"}
    };
    public String answers[]={
      "4","english","semicolon"
    };

    public String getquestion(int a)
    {
        String question=questions[a];
        return question;
    }
    public String getchoice1(int a)
    {
        String choice=choices[a][0];
        return choice;
    }
    public String getchoice2(int a)
    {
        String choice=choices[a][1];
        return choice;
    }
    public String getchoice3(int a)
    {
        String choice=choices[a][2];
        return choice;
    }
    public String correctans(int a)
    {
        String ans=answers[a];
        return ans;
    }
}
