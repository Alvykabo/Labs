package Text;

public class Actions {
    public  String zeroCase(String string, char a){
        String b = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< string.length(); i++){
            if(string.charAt(i)==a){}
            else builder.append(string.charAt(i));
        }
        return builder.toString();
    }
    public String firstCase(String string, char a, int k){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< string.length(); i++){
            if(k==i){builder.append(a)
                    .append(string.charAt(k));}
            else builder.append(string.charAt(i));
        }
        return builder.toString();
    }
}

