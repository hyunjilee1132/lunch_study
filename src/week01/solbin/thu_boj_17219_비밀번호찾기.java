import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);
    	Map<String,String> site = new HashMap<>();
    	for (int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		site.put(st.nextToken(), st.nextToken());
    	}
    	for (int i=0;i<m;i++) {
            // HashMap에서 검색해서 찾아오기
    		sb.append(site.get(br.readLine())).append("\n");
    	}
    	System.out.println(sb);
    }
}
