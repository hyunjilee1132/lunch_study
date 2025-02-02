package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class tue_boj_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] rawInput = br.readLine().split(" ");
		
		int nHearCnt = Integer.parseInt(rawInput[0]);
		int nSeeCnt = Integer.parseInt(rawInput[1]);
		
		Set<String> nHearSet = new HashSet<String>();
		List<String> nHearSee = new ArrayList<String>();
		
		for (int i = 0; i < nHearCnt; i++) {
			nHearSet.add(br.readLine());
		}

		for (int i = 0; i < nSeeCnt; i++) {
			String target = br.readLine();
			if (nHearSet.contains(target)) {
				nHearSee.add(target);
			}
		}
		
		nHearSee.sort(Comparator.naturalOrder());
		bw.append(nHearSee.size()+"\n");
		for (int i = 0; i < nHearSee.size(); i++ ) {
			bw.append(nHearSee.get(i));
			if (i != nHearSee.size()-1) bw.append("\n");
		}
		
		bw.flush();
 	}
}
