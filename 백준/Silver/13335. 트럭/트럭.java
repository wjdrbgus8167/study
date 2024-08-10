import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue <Integer> truck = new LinkedList<>();
		Queue <Integer> bridge = new LinkedList<>();
		st= new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
		{
			truck.add(Integer.parseInt(st.nextToken()));
		}
		// 다리 길이 정하기 
		for(int i=0;i<w;i++)
		{
			bridge.add(0);
		}
		
		int time=0;
		int sum=0;
		while(!bridge.isEmpty())
		{
			time++;
			sum -=bridge.poll();
			
			if(!truck.isEmpty())
			{
				if(L>=sum+truck.peek())
				{
					sum += truck.peek();
					bridge.add(truck.poll());
				}else {
					bridge.add(0);
				}
			}
		}
		System.out.println(time);
		
	}
}
