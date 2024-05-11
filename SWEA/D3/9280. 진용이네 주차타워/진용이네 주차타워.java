import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

class Solution{
	
	
	public static void main(String[] args)throws IOException{
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		 int t = Integer.parseInt(br.readLine());
	      
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st ;
		 for(int testcase=1;testcase<=t;testcase++)
		 {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			HashMap<Integer,Integer> r_i = new HashMap<>();
			HashMap<Integer,Integer> w_i = new HashMap<>();
			
			int parking[] = new int[m+1];
			
			Queue<Integer> que1 = new LinkedList<>();
			PriorityQueue<Integer> que2 = new PriorityQueue<>();
			
			int result=0;
			
			for(int i=0;i<n;i++)
			{
				r_i.put(i+1, Integer.parseInt(br.readLine()));
			}
			for(int i=0;i<m;i++)
			{
				w_i.put(i+1,Integer.parseInt(br.readLine()));
			}
			for(int i=1;i<=n;i++)
			{
				que2.add(i);
			}
			
			
			for(int i=0;i<2*m;i++)
			{
				int a = Integer.parseInt(br.readLine());
				
				if(a>0)
				{
					if(que2.isEmpty())
					{
						que1.add(a);
					}else {
						int parkingindex = que2.poll();
						parking[a] = parkingindex;
					}
				}else {
				
					int carindex = a*-1;
					int parkingindex = parking[carindex];
					result += w_i.get(carindex)*r_i.get(parkingindex);
					que2.add(parkingindex);
					
					if(!que1.isEmpty())
					{
						parkingindex = que2.poll();
						carindex = que1.poll();
						parking[carindex]= parkingindex;
					}
				}
			}
			
			sb.append("#"+testcase+" "+result+"\n");
			
		 }
			
		 System.out.println(sb); 
	}
		
	
	
	
}