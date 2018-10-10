package com.beans;


import java.util.List;

public class EnsembleOffer {

    List<Offer> MyListOffre;

    public EnsembleOffer(List<Offer> l) {
        this.MyListOffre = l;
    }

    @Override
    public String toString() {
        String result = "{";

        result = result.concat("\"size\" : \" "+this.MyListOffre.size()+" \" , ");

        result = result.concat("\"results\" : [");
        if(this.MyListOffre.size()!=0) {
            if(this.MyListOffre.size()>1) {

                for (int i = 0; i < this.MyListOffre.size()-1; i++) {

                    result = result.concat(this.MyListOffre.get(i).toString());
                    result = result.concat(",");
                }
                result = result.concat(this.MyListOffre.get(this.MyListOffre.size()-1).toString());

            }else {
                result = result.concat(this.MyListOffre.get(0).toString());
            }
        }

        result = result.concat("]}");
        return result;
    }

}
