package com.beans;


public class Offer {

    private String ProductName, ProductDate, ProductDescription, ProductPicture;
    private int ProductId, ProductPrice, ProductStatus, UserId;

    public Offer(int i) {
        this.ProductName = "ProductName"+i;
        this.ProductDate = "ProductDate"+i;
        this.ProductDescription = "ProductDescription"+i;
        this.ProductPicture = "ProductPicture"+i;

        this.ProductId = i;
        this.ProductPrice = i;
        this.ProductStatus = i;
        this.UserId = i;
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

        result = result.concat("}");
        return result;
    }

}
