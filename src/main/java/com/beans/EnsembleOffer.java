package com.beans;

import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.connection;

public class EnsembleOffer {

    public String nameArticle ;
    public List<Offer> MyListOffre = new ArrayList<Offer>();

    public EnsembleOffer(String name) {
        this.nameArticle = name;
        this.ConstructListe();
    }

    public void ConstructListe(){
         String ProductName, ProductDate, ProductDescription, ProductPicture;
         int ProductId, ProductPrice, ProductStatus, UserId;

        try {

        Connection db = connection.getConnection();
        Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product WHERE ProductName LIKE '%Iphone%'");
        while (rs.next()) {
            ProductName = rs.getString("ProductName");
            ProductDate = rs.getString("ProductDate");
            ProductDescription = rs.getString("ProductDescription");
            ProductPicture = rs.getString("ProductPicture");
            ProductId = rs.getInt("ProductId");
            ProductPrice = rs.getInt("ProductPrice");
            ProductStatus = rs.getInt("ProductStatus");
            UserId = rs.getInt("UserId");

            this.MyListOffre.add(new Offer(ProductName, ProductDate, ProductDescription, ProductPicture, ProductId, ProductPrice, ProductStatus, UserId ));
        }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }


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
