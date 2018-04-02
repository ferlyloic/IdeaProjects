package grailstest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public enum Gender {


    Man("Hr."),
    Woman("Fr.");
    private final String letter;
    private Gender(String letter){
        this.letter = letter;
    }
    public String getAbreviation(){
        return this.letter;
    }


}
