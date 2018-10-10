package com.beans;

import java.util.ArrayList;
import java.util.List;

public class EnsembleOffer {

    public String nameArticle ;
    public List<Offer> MyListOffre = new ArrayList<Offer>();

    public EnsembleOffer(String name) {
        this.nameArticle = name;
        this.ConstructListe();
    }

    public void ConstructListe(){

        this.MyListOffre.add(new Offer(0));
        this.MyListOffre.add(new Offer(1));
       // this.MyListOffre.add(new Offer(0));
        this.MyListOffre.add(new Offer(1));
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
