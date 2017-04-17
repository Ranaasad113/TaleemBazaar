package com.asad.taleembazar.serlization;

import java.util.ArrayList;

/**
 * Created by asad on 4/5/17.
 */

public class ArrayListData {
    ArrayList<String> stringArrayList=new ArrayList<>();
    private String[] listDataCars={"Cars","Spare Parts"};
    private String[] listDataMobiles={"Mobile Phones","Tablets","Accessories"};
    private String[] listDataElectronics={"Computer & Accessories","TV","Cameras & Accessories","Fridge - Washing Machine","Generators - UPS","Other Home Appliances"};
    private String[] listDataFurniture={"Sofa & Chairs","Beds","Tables & Dining","Other HouseHold Items"};
    private String[] listDataFashion={"Watches","Clothes","Jewelery"};
    public ArrayListData(String argu)
    {
        setArrayList(argu);

    }
    public void setArrayList(String argu)
    {
        switch(argu)
        {
            case "Cars":
                for (int i=0;i<listDataCars.length;i++)
                stringArrayList.add(listDataCars[i]);
                break;
            case "Mobiles":
                for(int i=0;i<listDataMobiles.length;i++)
                    stringArrayList.add(listDataMobiles[i]);
                break;
            case "Electronics":
                for(int i=0;i<listDataElectronics.length;i++)
                    stringArrayList.add(listDataElectronics[i]);
                break;
            case "Furniture":
                for(int i=0;i<listDataFurniture.length;i++)
                    stringArrayList.add(listDataFurniture[i]);
                break;
            case "Fashion":
                for (int i=0;i<listDataFashion.length;i++)
                    stringArrayList.add(listDataFashion[i]);
                break;

        }
    }
    public ArrayList<String> getStringArrayList()
    {
        return stringArrayList;
    }
}
