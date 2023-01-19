package ObjectUtilities;

public class pathAnalysis {
    private final String path ;
    private String userName ;
    private String databaseName;
    private String collection ;
    public pathAnalysis(String path){
        this.path = path ;
        analysis();
    }
    public void analysis (){
        String[] array=new String[3];
        for (int i = path.length()-1 , end = i,count=0; count <3 ; i--) {
            if(path.charAt(i) == '/'){
                array[count] = path.substring(i+1,(count == 0?end+1:end));
                end = i;
                count++;
            }
        }
    userName =  array[2];
    databaseName = array[1];
    collection  =array[0];

    }
    public String getUserName() {
        return userName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public String getCollection() {
        return collection;
    }

}
