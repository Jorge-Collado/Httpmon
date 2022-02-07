/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psp.combat;

import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.ImageIcon;
import psp.models.moves.Moves;
import psp.models.pokemon.Stat;

/**
 *
 * @author Georgeus
 */
public class CombatPokemon {

    private String nombre;
    private String tipo1;
    private String tipo2;
    private List<Moves> moves;
    private int maxHp;
    private int actualHp;
    private int atk;
    private int def;
    private int spAtk;
    private int spDef;
    private int spd;
    private BufferedImage frontsprite;
    private BufferedImage backsprite;
    private boolean fainted = false;

    public CombatPokemon(String nombre, String tipo1, String tipo2, List<Moves> moves, int maxHp, int atk, int def, int spAtk, int spDef, int spd) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.moves = moves;
        this.maxHp = maxHp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.spd = spd;
    }

    public CombatPokemon() {

    }

    public CombatPokemon(String nombre, String tipo1, List<Moves> moves, int maxHp, int atk, int def, int spAtk, int spDef, int spd) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.moves = moves;
        this.maxHp = maxHp;
        this.atk = atk;
        this.def = def;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.spd = spd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
    
    public int getActualHp() {
        return actualHp;
    }

    public void setActualHp(int actualHp) {
        this.actualHp = actualHp;
    }


    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public void setSpAtk(int spAtk) {
        this.spAtk = spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public void setSpDef(int spDef) {
        this.spDef = spDef;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public BufferedImage getFrontSprite() {
        return frontsprite;
    }

    public void setFrontSprite(BufferedImage frontsprite) {
        this.frontsprite = frontsprite;
    }

    public BufferedImage getBackSprite() {
        return backsprite;
    }

    public void setBackSprite(BufferedImage backsprite) {
        this.backsprite = backsprite;
    }

    public boolean isFainted() {
        return fainted;
    }

    public void setFainted(boolean fainted) {
        this.fainted = fainted;
    }
    
    

}
