/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author dvdung
 */
public class Suppliers {
    private int SupplierID;
    private String CompanyName;
    private String  ContactName;
    private String ContactTitle;
    private String Address;
    private String City;
    private String Region;
    private String PostalCode;
    private String Country;
    private String Phone;
    private String Fax;
    private String HomePage;

    public Suppliers(int SupplierID, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String Region, String PostalCode, String Country, String Phone, String Fax, String HomePage) {
        this.SupplierID = SupplierID;
        this.CompanyName = CompanyName;
        this.ContactName = ContactName;
        this.ContactTitle = ContactTitle;
        this.Address = Address;
        this.City = City;
        this.Region = Region;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.Phone = Phone;
        this.Fax = Fax;
        this.HomePage = HomePage;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String ContactTitle) {
        this.ContactTitle = ContactTitle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getHomePage() {
        return HomePage;
    }

    public void setHomePage(String HomePage) {
        this.HomePage = HomePage;
    }

    @Override
    public String toString() {
        return "Suppliers{" + "SupplierID=" + SupplierID + ", CompanyName=" + CompanyName + ", ContactName=" + ContactName + ", ContactTitle=" + ContactTitle + ", Address=" + Address + ", City=" + City + ", Region=" + Region + ", PostalCode=" + PostalCode + ", Country=" + Country + ", Phone=" + Phone + ", Fax=" + Fax + ", HomePage=" + HomePage + '}';
    }
    
    
}
