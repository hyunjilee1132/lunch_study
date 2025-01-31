import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 속도를 위해 sb, br을 사용함
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	boolean[] set = new boolean[20];
    	String[] input;
    	int idx;
    	for (int i=0;i<n;i++) {
    		input = br.readLine().split(" ");
    		if (input[0].equals("all")) {
                // 배열 전체를 true로 채움
    			Arrays.fill(set, true);
    		} else if(input[0].equals("empty")) {
                // 배열 전체를 false로 채움
    			Arrays.fill(set, false);
    		} else {
    			idx = Integer.parseInt(input[1])-1;
    			switch (input[0]) {
        		case "add":
        			set[idx] = true;
        			break;
        		case "remove":
        			set[idx] = false;
        			break;
        		case "check":
        			String ret = set[idx]?"1\n":"0\n";
        			sb.append(ret);
        			break;
        		case "toggle":
        			set[idx] = !set[idx];
        			break;
        		default:
        			break;
        		}
    		}
    	}
    	System.out.println(sb.toString());
    }
}
