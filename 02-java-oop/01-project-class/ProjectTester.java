public class ProjectTester{
    public static void main(String[] args){
        Project elevatorPitch = new Project("john","John is awesome");
        System.out.println(elevatorPitch.getProjectName());
        System.out.println(elevatorPitch.getProjectDesc());
        elevatorPitch.setProjectDesc("John just got fired");
        System.out.println(elevatorPitch.getProjectDesc());
    }
}