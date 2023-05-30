import java.util.ArrayList;

public class Second extends Thrid {
    private String x;
    private String y;
    private ArrayList<String> userlist = new ArrayList<>();


    public Second(String x){
        this.x = x;
    }

    public void setValue(String x, String y){
        this.x = x;
        this.y = y;

        userlist.add(x);
    }

    public String getValue(){
        return x;
    }

    public void showUpValue(){
        for ( String i: userlist) {
            System.out.println(i);
        }
    }

    @Override
    public byte checkid() {
        return (byte) ((username.equals(x) && userBasicInfo.equals(y)) ? 1 : 0);
    }
}
