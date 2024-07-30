/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jsclub.codefest2024.sdk.socket.data.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jsclub.codefest2024.sdk.socket.data.enemies.*;
import jsclub.codefest2024.sdk.socket.data.equipments.*;
import jsclub.codefest2024.sdk.socket.data.obstacles.*;
import jsclub.codefest2024.sdk.socket.data.weapon.*;
import jsclub.codefest2024.sdk.util.element.*;

/**
 *
 * @author AD
 */
public class MapInit {
    private int gameId;
    private int mapHeight;
    private int mapWidth;
    private int darkAreaWidth;
    private int darkAreaHeight;
    private String[] indestructibles;

    public MapInit() {
        this.mapHeight=0;
        this.mapWidth=0;
        this.darkAreaWidth=0;
        this.darkAreaHeight=0;
        this.indestructibles = null;
    }
    public MapInit(int mapHeight, int mapWidth, int darkAreaWidth, int darkAreaHeight, String[] walls) {
        this.mapHeight=mapHeight;
        this.mapWidth=mapWidth;
        this.darkAreaWidth=darkAreaWidth;
        this.darkAreaHeight=darkAreaHeight;
        this.indestructibles = walls;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getDarkAreaWidth() {
        return darkAreaWidth;
    }

    public int getDarkAreaHeight() {
        return darkAreaHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public void setDarkAreaWidth(int darkAreaWidth) {
        this.darkAreaWidth = darkAreaWidth;
    }

    public void setDarkAreaHeight(int darkAreaHeight) {
        this.darkAreaHeight = darkAreaHeight;
    }



}
