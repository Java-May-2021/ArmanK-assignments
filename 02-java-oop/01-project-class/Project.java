public class Project{
    private String name;
    private String description;

    public Project(){
        System.out.println("See your project");
    }
    public Project(String name){
        this.name = name;
    }
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getProjectName(){
        return this.name;
    }

    public void setProjectName(String name){
        this.name = name;
    }

    public String getProjectDesc(){
        return this.description;
    }

    public void setProjectDesc(String description){
        this.description = description;
    }


}