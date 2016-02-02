import java.util.*;

public class MarkovFour extends AbstractMarkovModel{
    //HashMap<String, ArrayList<Character>> map;

    public MarkovFour() {
        myRandom = new Random();
    }

    public void setTraining(String s){
        myText = s.trim();
        //map = new HashMap<String, ArrayList<Character>>();
        //trainDic();
    }
    /*
    private void trainDic(){
        for(int i = 0; i < myText.length()-4; ++i){
            String tmp = myText.substring(i,i+4);
            if(map.containsKey(tmp)) continue;
            map.put(tmp, getFollows(tmp));
        }
    }
    */

    public String toString(){
        return "MorkovModel of order "+4;
    }

    public String getRandomText(int numChars){
        if (myText == null) return "";
        StringBuilder sb = new StringBuilder();
        int pos = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(pos,pos+4);
        sb.append(key);
        //System.out.println("The first key is: +"+key);
        for(int i=0; i < numChars-4; i++){
            ArrayList<Character> list = getFollows(key);
            if(list.size() == 0) break;
            int index = myRandom.nextInt(list.size());
            key = key.substring(1)+String.valueOf(list.get(index));
            sb.append(list.get(index));
        }
        return sb.toString();
    }
}