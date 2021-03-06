package fr.cloudsky.lobby.manager;

import org.bukkit.ChatColor;

/**
 * @author Ariouz
 * @version 1.0
 * This class help you to create a bar, like an xp bar
 * Exemple: 10% of 20 = 2 are green and 18 are red
 *
 * Copyright Ariouz 2020
 */

public class BarBuilder {

    private ChatColor full = ChatColor.GREEN;
    private ChatColor empty = ChatColor.RED;
    private double percent;
    private int sizeOfBar = 100;
    private char caracter = '|';

    /**
     * Default method, it will set the percent of green bars
     * @param percent
     */

    public BarBuilder(double percent){
        this.percent = percent;
    }

    /**
     * It will set the percent of green bars and the size of bar
     * @param percent
     * @param sizeOfBar
     */

    public BarBuilder(double percent, int sizeOfBar){
        this.percent = percent;
        this.sizeOfBar = sizeOfBar;
    }

    /**
     * It will set the percent of green bars, the size of bar and the caratcter (default is '|' )
     * @param percent
     * @param sizeOfBar
     * @param caracter
     */

    public BarBuilder(double percent, int sizeOfBar, char caracter){
        this.percent = percent;
        this.sizeOfBar = sizeOfBar;
        this.caracter = caracter;
    }

    /**
     * It will set the percent of green bars and the caracter (default is '|' )
     * @param percent
     * @param caracter
     */

    public BarBuilder(double percent, char caracter){
        this.percent = percent;
        this.caracter = caracter;
    }

    /**
     * It will set the percent of green bars, the size of the total bar, the caracter, the full color (default is green) and the empty color (default id red)
     * @param percent
     * @param sizeOfBar
     * @param caracter
     * @param full
     * @param empty
     */

    public BarBuilder(double percent, int sizeOfBar, char caracter, ChatColor full, ChatColor empty){
        this.percent = percent;
        this.caracter = caracter;
    }

    /**
     * set the full color (default is green)
     * @param color
     */

    public BarBuilder setFullColor(ChatColor color){
        this.full = color;
        return this;
    }

    /**
     * set the empty color (default is red)
     * @param color
     */

    public BarBuilder setEmptyColor(ChatColor color){
        this.empty = color;
        return this;
    }

    /**
     * set the size of the bar (default is 100)
     * @param size
     */

    public BarBuilder setSize(int size){
        this.sizeOfBar = size;
        return this;
    }

    /**
     * set the caracter of bar (default is '|')
     * @param caracter
     */

    public BarBuilder setCaracter(char caracter){
        this.caracter = caracter;
        return this;
    }

    /**
     * Build the bar. Use this method after all ones !
     * @return build.toStirng();
     */

    public String build(){
        this.percent /= 100;

        long completed = Math.round(this.sizeOfBar*this.percent);

        StringBuilder build = new StringBuilder();
        build.append(this.full);

        for(int i = 0; i < sizeOfBar; i++){
            build.append(i == completed ? this.empty : "").append(this.caracter);
        }

        return build.toString();
    }

}
