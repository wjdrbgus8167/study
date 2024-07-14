import java.io.*;
import java.util.*;

class Main{	
	
	public static int r,c,t;
	public static int dx[] = {1,0,-1,0};
	public static int dy[]= {0,1,0,-1};
	public static int anti_x[] = {0,-1,0,1};
	public static int anti_y[]= {1,0,-1,0};
	public static int clock_x[] = {0,1,0,-1};
	public static int clock_y[]= {1,0,-1,0};
	
	public static int arr[][];
	public static int arr_c[][];
	public static int antinum;
	public static int clocknum;
	public static void main(String[] args)throws IOException{
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	t = Integer.parseInt(st.nextToken());
	
	arr = new int[r][c];
	arr_c = new int[r][c];
	for(int i=0;i<r;i++)
	{
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<c;j++)
		{
			arr[i][j]= Integer.parseInt(st.nextToken());
			arr_c[i][j]=0;
			if(arr[i][j]==-1)
			{
				clocknum=i;
			}
		}
	}
	
	antinum = clocknum-1;
	
	
	for(int i=0;i<t;i++)
	{
		arr_c = new int [r][c];
		for(int j=0;j<r;j++)
		{
			for(int k=0;k<c;k++)
			{
				if(arr[j][k]!=0&&arr[j][k]!=-1&&arr[j][k]/5!=0)
				{
					spread(j,k);
				}
			}
		}
		
		for(int j=0;j<r;j++)
		{
			for(int k=0;k<c;k++)
			{
				arr[j][k] = arr[j][k]+arr_c[j][k];
			}
		}
		
		int temp = arr[antinum][1];
		arr[antinum][1] =0;

		int temp1 = arr[clocknum][1];
		arr[clocknum][1] =0;
		anticlockwise(antinum,1,temp,0);
		clockwise(clocknum,1,temp1,0);
		
	}
	
	int sum =0;
	for(int j=0;j<r;j++)
	{
		for(int k=0;k<c;k++)
		{
			if(arr[j][k]!=-1)
			{
				sum+=arr[j][k];
			}
			
		}
	}
	System.out.println(sum);
		
	}
	public static void spread(int x,int y)
	{
		int dust = arr[x][y]/5;
		
		for(int i=0;i<4;i++)
		{
			int k1 = dx[i]+x;
			int k2 = dy[i]+y;
			
			if(k1>=0&&k1<r&&k2>=0&&k2<c)
			{
				if(arr[k1][k2]!=-1)
				{
					arr_c[k1][k2] +=dust;
					arr[x][y] -=dust;
				}
			}
		}
	}
	
	public static void anticlockwise(int x,int y,int temp,int depth)
	{
		
		int k1 = anti_x[depth]+x;
		int k2 = anti_y[depth]+y;
		if(k1==antinum&&k2==0)
		{
			return;
		}	
		if(k1>=0&&k1<antinum+1&&k2>=0&&k2<c)
		{
			
			int num =arr[k1][k2];
			arr[k1][k2]=temp;
			
			anticlockwise(k1,k2,num,depth);
		}else 
		{
			anticlockwise(x,y,temp,depth+1);
		}
		
	}
	public static void clockwise(int x,int y,int temp,int depth)
	{
		
		int k1 = clock_x[depth]+x;
		int k2 = clock_y[depth]+y;
		
		if(k1==clocknum&&k2==0)
		{
			return;
		}
	
		if(k1>=clocknum&&k1<r&&k2>=0&&k2<c)
		{
			int num =arr[k1][k2];
			arr[k1][k2]=temp;
			clockwise(k1,k2,num,depth);
		}else 
		{
			clockwise(x,y,temp,depth+1);
		}
		
	}

}