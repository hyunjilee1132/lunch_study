import java.io.*;
public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int x = 0; x < n; x++) {
			String s = br.readLine();
			long l = Long.parseLong(s.substring(1));
			if (l != 0) {
				if (s.charAt(0) == '+') {
					sum += l;
				} else {
					sum -= l;
				}
			}
			long answer = 0;
			if (sum != 0) {
				int k = (int) (Math.log(sum)/Math.log(2));
				if (k > 62) {
					answer = (long) (Math.pow(2, 62));
				} else {
					answer = (long) (Math.pow(2, k));
				}
			}
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
	}
}
