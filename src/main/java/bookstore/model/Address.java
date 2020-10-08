package bookstore.model;

/**
 * Represents an address.
 */
public class Address extends AbstractEntity {

    String street;
    int addressNumber;
    String city;
    String region;
    String country;
    String zipCode;

    public Address(String street, int addressNumber, String city, String region, String country, String zipCode) {
        this.street = street;
        this.addressNumber = addressNumber;
        this.city = city;
        this.region = region;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id= " + id + '\'' +
                ", street='" + street + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode +
                '}';
    }
}
