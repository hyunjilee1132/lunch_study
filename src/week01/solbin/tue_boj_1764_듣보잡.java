import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] input = br.readLine().split(" ");
    	int n = Integer.parseInt(input[0]);
    	int m = Integer.parseInt(input[1]);
    	// 듣도못한 사람은 HashSet에 저장함
    	// HashSet의 장점 : 검색속도가 매우 빠르다
    	// HashSet의 단점? : 정렬되어있지 않다
    	Set<String> neverHeard = new HashSet<>();
    	// 듣도보도못한 사람은 ArrayList에 저장함
    	List<String> neverHeardNeverSeen = new ArrayList<>();
    	for (int i=0;i<n;i++) {
    		neverHeard.add(br.readLine());
    	}
    	for (int i=0;i<m;i++) {
    		String str = br.readLine();
    		if (neverHeard.contains(str)) {
    			neverHeardNeverSeen.add(str);
    		}
    	}
    	Collections.sort(neverHeardNeverSeen);
    	sb.append(neverHeardNeverSeen.size()+"\n");
    	for (String item:neverHeardNeverSeen) {
    		sb.append(item).append("\n");
    	}
    	System.out.println(sb);
    }
}
