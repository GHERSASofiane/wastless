package models;

public class Product {

    public String ProductName, ProductDate, ProductDescription, ProductPicture, UserName, ProductPrice;
    public int ProductId, ProductStatus, UserId;

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setProductDate(String ProductDate) {
        this.ProductDate = ProductDate;
    }

    public void setProductDescription(String ProductDescription) {
        this.ProductDescription = ProductDescription;
    }

    public void setProductPicture(String ProductPicture) {
        this.ProductPicture = ProductPicture;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setProductId(int ProductId) {
        this.ProductId = ProductId;
    }

    public void setProductPrice(String ProductPrice) {
        this.ProductPrice = ProductPrice;
    }

    public void setProductStatus(int ProductStatus) {
        this.ProductStatus = ProductStatus;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    } 
    
    public String getProductName() {
        return ProductName;
    }

    public String getProductDate() {
        return ProductDate;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public String getProductPicture() {
        return ProductPicture;
    }

    public String getUserName() {
        return UserName;
    }

    public int getProductId() {
        return ProductId;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public int getProductStatus() {
        return ProductStatus;
    }

    public int getUserId() {
        return UserId;
    }

    
}
