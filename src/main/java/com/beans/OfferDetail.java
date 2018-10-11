 
package com.beans;

/**
 *
 * @author ghersa
 */
public class OfferDetail extends Offer{

    String UserName, UserMail, UserAdress;
    int UserPhone;
    
    public OfferDetail(String ProductName, String ProductDate, String ProductDescription, String ProductPicture, 
            int ProductId, int ProductPrice, int ProductStatus, int UserId, 
            String UserName, String UserMail, String UserAdress, int UserPhone) {
        super(ProductName, ProductDate, ProductDescription, ProductPicture, 
                ProductId, ProductPrice, ProductStatus, UserId);
        
        this.UserName = UserName;
        this.UserMail = UserMail;
        this.UserAdress = UserAdress;
        this.UserPhone = UserPhone;
    }
    
    
        @Override
    public String toString() {
        String result ="{";
        result = result.concat("\"ProductId\" : ");
        result = result.concat("\""+this.ProductId+"\",");
        result = result.concat("\"ProductName\" : ");
        result = result.concat("\""+this.ProductName+"\",");
        result = result.concat("\"ProductDate\" : ");
        result = result.concat("\""+this.ProductDate+"\",");
        result = result.concat("\"ProductDescription\" : ");
        result = result.concat("\""+this.ProductDescription+"\",");
        result = result.concat("\"ProductPicture\" : ");
        result = result.concat("\""+this.ProductPicture+"\",");
        result = result.concat("\"ProductPrice\" : ");
        result = result.concat("\""+this.ProductPrice+"\",");
        result = result.concat("\"ProductStatus\" : ");
        result = result.concat("\""+this.ProductStatus+"\",");
        result = result.concat("\"UserId\" : ");
        result = result.concat("\""+this.UserId+"\"");
        result = result.concat("\"UserName\" : ");
        result = result.concat("\""+this.UserName+"\"");
        result = result.concat("\"UserMail\" : ");
        result = result.concat("\""+this.UserMail+"\"");
        result = result.concat("\"UserAdress\" : ");
        result = result.concat("\""+this.UserAdress+"\"");
        result = result.concat("\"UserPhone\" : ");
        result = result.concat("\""+this.UserPhone+"\"");

        result = result.concat("}");
        return result;
    }
    
    
    
}
