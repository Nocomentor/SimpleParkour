package com.pansebastian.simpleparkour.objects;

import java.util.ArrayList;
import java.util.List;

public class Parkour {

    public List<ParkourPoint> pointsArr;
    public String name;
    public int length;

    public Parkour(List<ParkourPoint> parkourPointsArray, String name)
    {
        pointsArr = parkourPointsArray;
        length = pointsArr.size();
        this.name = name;
    }



}
