import java.util.*;
import java.io.*;
public class boj1686 {
	static int v,m,r,n;
	static double xt,yt;
	static List<double[]> xylist = new ArrayList<>();
	static boolean[] visited;
	static Queue<double[]> queue = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st1 = new StringTokenizer(sc.nextLine());
		v = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken())*60;
		r = m*v;
		StringTokenizer st2 = new StringTokenizer(sc.nextLine());
		double xs = Double.parseDouble(st2.nextToken());
		double ys = Double.parseDouble(st2.nextToken());
		StringTokenizer st3 = new StringTokenizer(sc.nextLine());
		xt = Double.parseDouble(st3.nextToken());
		yt = Double.parseDouble(st3.nextToken());
		while(sc.hasNextLine()) {
		    String line = sc.nextLine();
		    if (line.isEmpty()) {
		    	break;
		    }
			StringTokenizer st4 = new StringTokenizer(line);
			double x = Double.parseDouble(st4.nextToken());
			double y = Double.parseDouble(st4.nextToken());
			double[] xy = new double[] {x,y};
			xylist.add(xy);
		}
		n = -1;
		visited = new boolean[xylist.size()];
		Arrays.fill(visited, false);
		double[] start = {xs,ys,0};
		queue.add(start);
		search();
		if (n == -1) {
			System.out.println("No.");
		} else {
			System.out.println("Yes, visiting "+n+" other holes.");
		}
	}
	static void search() {
		while(!queue.isEmpty()) {
			double[] xyz = queue.poll();
			double x = xyz[0];
			double y = xyz[1];
			double move = xyz[2];
			if (dist(x,y,xt,yt)<=r) {
				n = (int)move;
				return;
			}
			for (int i = 0; i < xylist.size(); i++) {
				if (!visited[i]) {
					double[] c = xylist.get(i);
					if (dist(x,y,c[0],c[1])<=r) {
						visited[i]=true;
						double[] new_xy = new double[] {c[0],c[1],move+1};
						queue.add(new_xy);
					}
				}
			}
		}
	}
	static double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2));
	}
}
