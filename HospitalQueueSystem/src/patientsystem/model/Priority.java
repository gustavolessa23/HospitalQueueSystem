package patientsystem.model;

public enum Priority {


/**
 * This ENUM represents the priority options along with methods to retrieve
 * lists of options and of values.
 * @author Gustavo Lessa
 */
    A("Risk of death / Emergency"), B("Elderly / Pregnant / Disabled"), C("Regular");

    private static final Priority[] priorities = values(); // array of all priorities

    private final String description; // description, inside the parenthesis
    private final static String[] descriptions = generateArrayDescriptions(); // array of Strings, the descriptions.

    /**
     * This constructor creates a new Priority.
     * @param city (String) - description of the priority.
     */
    Priority(String description){
        this.description = description;
    }

    /**
     * This method is the accessor for the String description.
     * @return A String of the description.
     */
    public String getDescription(){
        return this.description;
    }
    
    /**
     * This static method is the accessor of the array of Priority options. 
     * @return (Priority[]) - An array of Priority objects.
     */
    public static Priority[] getAllOptions(){
        return priorities;
    }
    
    /**
     * This method returns an array of descriptions.
     * @return (String[]) - An array of String objects.
     */
    public static String[] generateArrayDescriptions(){
        String[] names = new String[priorities.length];
        for(int x = 0; x < names.length; x++){
            names[x] = priorities[x].getDescription();
        }
        return names;
    }
    
    /**
     * This static method is the accessor of the array of descriptions.
     * @return (String[]) - An array of String representing the descriptions of all priority levels.
     */
    public static String[] getAllDescriptions() {
    	return descriptions;
    }
}
