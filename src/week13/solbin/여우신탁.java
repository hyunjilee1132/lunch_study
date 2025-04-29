import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] fox = new int[n];
		Map<Integer,Integer> fstDist = new HashMap<>();
		Map<Integer,Integer> sndDist = new HashMap<>();
		boolean isFliped = false;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			fox[i] = Integer.parseInt(st.nextToken());
		}
		fstDist.put(fox[0]-1, 1);
		int size = fox[0];
		Map<Integer,Integer> lastDist;
		Map<Integer,Integer> newDist;
		for (int i=1;i<n;i++) {
			int newFox = fox[i];
			if (newFox<size) {
				if (isFliped) {
					lastDist = sndDist;
					newDist = fstDist;
				} else {
					lastDist = fstDist;
					newDist = sndDist;					
				}
				newDist.clear();
				for (int k:lastDist.keySet()) {
					int val = lastDist.get(k);
					if (k<newFox) {
						newDist.put(k, val + newDist.getOrDefault(k, 0));
					} else {						
						newDist.put(newFox-1, val*(k/newFox) + newDist.getOrDefault(newFox-1, 0));
						if (k > newFox && k%newFox!=0) {						
							newDist.put(k%newFox, val + newDist.getOrDefault(k%newFox, 0));
						}
					}
				}
				isFliped = !isFliped;
				size = newFox;
			}
		}
		if (isFliped) {
			lastDist = sndDist;
		} else {
			lastDist = fstDist;				
		}
		long sum = 0;
		for (int k:lastDist.keySet()) {
			long cnt = (long)k*(k+1)/2;
			sum+=cnt*lastDist.get(k);
		}
		double result = (double)sum/fox[0];
		System.out.println(result);
	}
}

