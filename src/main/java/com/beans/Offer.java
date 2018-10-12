/**
 * Représent une offre
 */

package com.beans;

/**
 *
 * @author GHERSA Sofiane
 */

public class Offer {

    public String ProductName, ProductDate, ProductDescription, ProductPicture, UserName;
    public int ProductId, ProductPrice, ProductStatus, UserId;

    public Offer(String ProductName, String ProductDate, String ProductDescription, String ProductPicture, int ProductId, int ProductPrice, int ProductStatus, int UserId , String UserName) {
        this.ProductName = ProductName;
        this.ProductDate = ProductDate;
        this.ProductDescription = ProductDescription;
        this.ProductPicture = ProductPicture;

        this.ProductId = ProductId;
        this.ProductPrice = ProductPrice;
        this.ProductStatus = ProductStatus;
        this.UserId = UserId;
        this.UserName = UserName;
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
        result = result.concat("\""+this.UserId+"\",");
        result = result.concat("\"UserName\" : ");
        result = result.concat("\""+this.UserName+"\"");

        result = result.concat("}");
        return result;
    }

}
