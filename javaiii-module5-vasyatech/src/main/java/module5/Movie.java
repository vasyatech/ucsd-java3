package module5;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Movie {
	private IntegerProperty id;
    public void setId(int value) { idProperty().set(value); }
    public int getId() { return idProperty().get(); }
    public IntegerProperty idProperty() { 
        if (id == null) id = new SimpleIntegerProperty(this, "id");
        return id; 
    }
    
	private StringProperty name;
    public void setName(String value) { nameProperty().set(value); }
    public String getName() { return nameProperty().get(); }
    public StringProperty nameProperty() { 
        if (name == null) name = new SimpleStringProperty(this, "name");
        return name; 
    }

	private IntegerProperty rating;
    public void setRating(int value) { ratingProperty().set(value); }
    public int getRating() { return ratingProperty().get(); }
    public IntegerProperty ratingProperty() { 
        if (rating == null) rating = new SimpleIntegerProperty(this, "rating");
        return rating; 
    }
    
    private StringProperty description;
    public void setDescription(String value) { descriptionProperty().set(value); }
    public String getDescription() { return descriptionProperty().get(); }
    public StringProperty descriptionProperty() { 
        if (description == null) description = new SimpleStringProperty(this, "description");
        return description; 
    } 
}
