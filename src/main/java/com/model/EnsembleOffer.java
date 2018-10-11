package com.model;

import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.connection;
import com.beans.*;

/**
 *
 * @author ghersa
 */
public class EnsembleOffer {

    public String nameArticle;
    int page;
    public List<Offer> MyListOffre = new ArrayList<Offer>();

    // constructeur
    public EnsembleOffer(String name, String page) {
        this.nameArticle = name; 
        this.page = Integer.parseInt(page) ;
        this.ConstructListe();
    }

    // methode pour recuperer les données dans la BDD et créé les objs offer
    public void ConstructListe(){
         String ProductName, ProductDate, ProductDescription, ProductPicture, UserName;
         int ProductId, ProductPrice, ProductStatus, UserId;

        try {

        Connection db = connection.getConnection();
        Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product, Users WHERE Product.UserId = Users.UserId AND ProductName LIKE '%"+this.nameArticle+"%' OFFSET "+(this.page*10)+" LIMIT 10 ");
        while (rs.next()) {
            ProductName = rs.getString("ProductName");
            ProductDate = rs.getString("ProductDate");
            ProductDescription = rs.getString("ProductDescription");
            ProductPicture = rs.getString("ProductPicture");
            ProductId = rs.getInt("ProductId");
            ProductPrice = rs.getInt("ProductPrice");
            ProductStatus = rs.getInt("ProductStatus");
            UserId = rs.getInt("UserId");
            UserName = rs.getString("UserName");

            this.MyListOffre.add(new Offer(ProductName, ProductDate, ProductDescription, ProductPicture, ProductId, ProductPrice, ProductStatus, UserId, UserName));
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
