package patientsystem.model;

public enum Priority {


/**
 * This enum represents the priority options along with methods to retrieve
 * lists of options and values.
 * @author Gustavo Lessa
 */
    A("Risk of death / Emergency"), B("Elderly / Pregnant / Disabled"), C("Regular");

    private static final Priority[] priorities = values();

    private final String description;

    /**
     * This constructor creates a new Location.
     * @param city (String) - name of the city.
     */
    Priority(String description){
        this.description = description;
    }

    /**
     * This method is the accessor for the String city variable.
     * @return A String of the city's name.
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * This static method is the accessor of the array of Location options. 
     * @return (Location[]) - An array of Location objects.
     */
    public static Priority[] getAllOptions(){
        return priorities;
    }
    
    /**
     * This method returns an array of city names.
     * @return (String[]) - An array of String objects.
     */
    public static String[] getAllDescriptions(){
        String[] names = new String[priorities.length];
        for(int x = 0; x < names.length; x++){
            names[x] = priorities[x].getDescription();
        }
        return names;
    }
}
