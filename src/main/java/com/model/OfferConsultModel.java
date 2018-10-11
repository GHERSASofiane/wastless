 
package com.model;

import com.beans.OfferDetail;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.connection;
/**
 *
 * @author ghersa
 */
public class OfferConsultModel {

    String ProductId;
    OfferDetail OffDet;
    
    public OfferConsultModel(String param) {
        this.ProductId = param;
        getOffreDet();
    }
    
    public void getOffreDet(){
            String ProductName, ProductDate, ProductDescription, ProductPicture;
            int ProductIdi, UserPhone, ProductPrice, ProductStatus, UserId;
            String UserName, UserMail, UserAdress;
           
            
                try {

        Connection db = connection.getConnection();
        Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product, Users WHERE Product.userid = Users.userid AND ProductId = "+this.ProductId+";");
          while (rs.next()) {
            ProductName = rs.getString("ProductName");
            ProductDate = rs.getString("ProductDate");
            ProductDescription = rs.getString("ProductDescription");
            ProductPicture = rs.getString("ProductPicture");
            ProductIdi = rs.getInt("ProductId");
            ProductPrice = rs.getInt("ProductPrice");
            ProductStatus = rs.getInt("ProductStatus");
            UserId = rs.getInt("UserId");
            UserName = rs.getString("UserName"); 
            UserMail = rs.getString("UserMail");
            UserAdress = rs.getString("UserAdress");
            UserPhone = rs.getInt("UserPhone");
            
            this.OffDet = new OfferDetail(ProductName, ProductDate, ProductDescription, 
                    ProductPicture, ProductIdi, ProductPrice, ProductStatus, UserId, UserName, 
                    UserMail, UserAdress, UserPhone);
 }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public String toString() {
        String result;
        if(this.OffDet == null){
            result ="{\"answer\":\"no\""
                    + "}";
        }else{
            result = this.OffDet.toString();
        }
        return result;  
    }
    
    
    
}
