package com.e.email;

public class FData {

    String NameID1;
    String Nametpp;
    String Type1;

    public FData(){

    }

    public FData(String nameID, String namety, String type) {
        NameID1 = nameID;
        Nametpp = namety;
        Type1 = type;
    }

    public String getNameID() {
        return NameID1;
    }

    public String getName() {
        return Nametpp;
    }

    public String getType() {
        return Type1;
    }
}
