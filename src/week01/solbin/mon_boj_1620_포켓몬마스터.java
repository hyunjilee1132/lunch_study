import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);

        // String to Integer HashMap
    	Map<String,Integer> map = new HashMap<>();

        // Integer to String Array
    	String[] arr = new String[n]; 

    	for (int i=0;i<n;i++) {
    		String str = br.readLine();
    		arr[i] = str;
    		map.put(str, i+1);
    	}

    	for (int i=0;i<m;i++) {
    		String str = br.readLine();
    		if (str.matches("[0-9]*")) {
                // 숫자일 경우에는 Array에서 찾기
    			sb.append(arr[Integer.parseInt(str)-1]+"\n");
    		} else {
                // 문자일 경우에는 HashMap에서 찾기
    			sb.append(map.get(str)+"\n");
    		}
    	}
    	System.out.println(sb.toString());
    }
}
