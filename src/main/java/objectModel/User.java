package objectModel;

/**
 * Created by Anna on 26.11.2017.
 */
public class User {

    private String firstName;
    private String lastName;
    private String favoriteColor;
    private String favoriteMovie;
    private String favoriteNumber;
    private String favoriteFood;

    public User() {
    }

    public User(String firstName, String lastName, String favoriteColor, String favoriteMovie, String favoriteNumber, String favoriteFood) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteColor = favoriteColor;
        this.favoriteMovie = favoriteMovie;
        this.favoriteNumber = favoriteNumber;
        this.favoriteFood = favoriteFood;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public String getFavoriteMovie() {
        return favoriteMovie;
    }

    public void setFavoriteMovie(String favoriteMovie) {
        this.favoriteMovie = favoriteMovie;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
}
