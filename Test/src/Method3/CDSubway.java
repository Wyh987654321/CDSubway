package Method3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class CDSubway {
	static List<String> station_name=new ArrayList<String>();         //用于存储所有的站点名称，共138个，从station_name文件中获取
	/*
	 * 接下来三个list是存储站点信息的，分别是站点名称，站点所属线路名称，站点在该线上的序列号（人为设置，如万盛是四号线1站）
	 * 三个list 的内容从station.data文件中获取
	 * 三个list的相同位置存储同一个站点的信息，如lstation_name.get(1)+lline_name.get(1)+lstation_num.get(1) 存储的就是第二个站点的信息
	 */
	static List<String> lstation_name=new ArrayList<String>(); 
	static List<String> lline_name=new ArrayList<String>();           
    static List<String> lstation_num=new ArrayList<String>();
    /*
     *     一共五个list，分别存储一号线，二号线，三号线，四号线，七号线，十号线的站点名称
     */
    public static List<String> line1 = new ArrayList<String>();
    public static List<String> line2 = new ArrayList<String>();
    public static List<String> line3 = new ArrayList<String>();
    public static List<String> line4 = new ArrayList<String>();
    public static List<String> line7 = new ArrayList<String>();
    public static List<String> line10 = new ArrayList<String>();
    
    public static Set<List<String>> lineSet = new LinkedHashSet<List<String>>(); //Set对象，用于存放所有地铁线路的list
	public static Graph graph = new Graph(138);   //成都的地铁线路网,138是所有地铁站的个数
	
	public CDSubway() {   //构造方法，调用init()函数
		init();
	}
	/*
	 *  search方法，用于查询 站点在station_name中的序列号
	 */
	public static int search(String name) {  
		int i=0;
		int flag=0;
		for(i=0;i<station_name.size();i++) {
			if(name.equals(station_name.get(i).trim())) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println(name+" "+"站点不存在");
			i=-1;
		}
		return i;
	}
	
	/*
	 * searchline
	 * 查询线路上所有的站点
	 */
	public static void searchline(String lname) {
		System.out.println(lname+"查询结果如下");
		//int flag=0;
		switch(lname) {
    	case "一号线":System.out.println(line1);break;
    	case "二号线":System.out.println(line2);break;
    	case "三号线":System.out.println(line3);break;
    	case "四号线":System.out.println(line4);break;
    	case "七号线":System.out.println(line7);break;
    	case "十号线":System.out.println(line10);break;
    	default:System.out.println("线路不存在");break;
    	}
	}
	
	/*
	 * searchstation方法
	 *   查询站点的所属线路
	 */
	public static void searchstation(String sname) {
		int i=0;
		int flag=0;
		System.out.println(sname+":");
		for(List<String> line:lineSet) {
			for(String s:line) {
				if(s.equals(sname)) {
					switch(i) {
					case 0:System.out.println("1号线");flag++;break;
					case 1:System.out.println("2号线");flag++;break;
					case 2:System.out.println("3号线");flag++;break;
					case 3:System.out.println("4号线");flag++;break;
					case 4:System.out.println("7号线");flag++;break;
					case 5:System.out.println("10号线");flag++;break;
					}
				}
			}
			i++;
		}
		if(flag==0) {
			System.out.println("站点不存在");
		}
	}
	
	/*
	 * init()方法
	 * 用于创建成都地铁线路网graph
	 */
	public static void init() {
		/*
		 * 读取station_name.txt文件中的站点名称，并存储进station_name list中
		 */
		try {
//            File file = new File("E:\\eclipse\\Test\\bin\\station_name.txt");
			File file = new File("src//method3//station_name.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
            	
            	station_name.add(line.trim());
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		/*
		 * 读取station_data.txt文件中的站点信息
		 */
		try {
//            File file = new File("E:\\eclipse\\Test\\bin\\station_data.txt");
			File file = new File("src//method3//station_data.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
            	String[] sArray=line.split(",");  //以,为分隔符，将每一行划分为三个字符串存入sArray中
            	//将数组中的三个字符串分别存放进三个list中，因此三个list中的相同位置存放的都是一个站点的信息
            	lstation_name.add(sArray[0].trim());     
            	lline_name.add(sArray[1].trim());
            	lstation_num.add(sArray[2].trim());
            	//将站点划分到各自的路线中，通过sArray[1]来判断
            	switch(sArray[1]) {
            	case "1":line1.add(sArray[0]);break;
            	case "2":line2.add(sArray[0]);break;
            	case "3":line3.add(sArray[0]);break;
            	case "4":line4.add(sArray[0]);break;
            	case "7":line7.add(sArray[0]);break;
            	case "10":line10.add(sArray[0]);break;
            	}
                line = br.readLine();  //读取下一行，直到读完整个文件
            }
            // while循环结束后，所有的站点信息都被录入完毕，现在将所有线路list放入之前创建的Set对象中方便调用
            lineSet.add(line1);
            lineSet.add(line2);
            lineSet.add(line3);
            lineSet.add(line4);
            lineSet.add(line7);
            lineSet.add(line10);           
          } catch (Exception e) {
            e.printStackTrace();
        }
		int size=lstation_name.size();     //size表示的是站点信息的多少，因为一个站点可能有多个信息（就是指换乘站），
		/*
		 * 到目前为止，graph中只有结点，还没有边，现在开始加边
		 * 每次对两个站点信息进行遍历，判断是否要加边
		 * 加边的条件，处在同一条路线上，且序列号连续
		 * 因为每个站点一定都处在至少一条线路上，这样即使是中转站也可以完成加边，
		 * 如一品天下是二号线和七号线的中转站，那么在station_data.txt中就有两个一品天下的信息，分别是一品天下,2,9和一品天下,7,1
		 * 这样一品天下站点的所有邻接点都能找到，自然就可以加边了
		 */
		for(int i=1;i<size;i++) {
				if((lline_name.get(i)).equals(lline_name.get(i-1))&&Integer.parseInt(lstation_num.get(i))==Integer.parseInt(lstation_num.get(i-1))+1) {
				int x=search(lstation_name.get(i));   //通过search方法获取当前站点在lstation_name中的序列号，因为graph中的LinkedList（邻接点数组）和lstation_name 的序列号是一一对应的
				int y=search(lstation_name.get(i-1)); //同上
				graph.addEdge(x, y);    //调用加边方法进行加边
			}
		}
	}
	
	public void calc(int start,int end,Graph graph){
		if(start<0||end<0) {
			return;
		}
		if(start==end) {
			System.out.println("两站点相同");
			return;
		}
		int v=graph.getV();  //得到结点总数
		LinkedList<Integer>[] adj=graph.getAdj();  //得到所有边的信息
		boolean[] visited = new boolean[v];        //创建访问数组
		visited[start] = true;         //设置初始站点已被访问过
		Queue<Integer> queue = new LinkedList<>();     //创建辅助队列
		queue.add(start);     
		int[] prev = new int[v];   //路径数组，记录站点的前一个站点，如prev[q]=w,就表示想要到达q，就必须先经过w
		for(int i=0; i<v;i++) {    //初始化为-1
			prev[i] = -1;
		}
		while(queue.size() != 0) {
			int w =queue.poll();
			for(int i=0; i<adj[w].size();++i) {   //遍历站点 w 的所有邻接站点
				int q = adj[w].get(i);     //取出 w 的邻接站点
				if(!visited[q]) {      //判断是否访问过
					prev[q] = w;         //加入路径数组
					if(q == end) {       //如果是终点就结束，调用print方法打印路径
						print(prev,start,end);  
						return;
					}
					visited[q] = true;  //如果不是目的地，就设置为已访问过， 
					queue.add(q);      //邻接站点入队
				}
			}
		}
	}
	private void print(int[] prev, int start,int end) {
		int end2=end;    //将end赋值给end2，之后会用到
		int num=1;       //用于记录经过的站数，初值为1
		Stack<Integer> stack=new Stack<Integer>(); //创建辅助栈
		/*
		 * 依次将路径数组中的值入栈，利用栈后进先出的特性
		 * 循环条件1：prev[end]!=-1 表示已经找到了正确路线，
		 * 循环条件2：start!=end，表示已经全部压栈完毕
		 */
		while(prev[end]!=-1&&start!=end){  
			stack.push(prev[end]);  //目的地的前一个站点入栈
			end=prev[end];          //将目的地设为目的地的前一个站点，这样循环下去，最终end=start 结束循环
		}
		List<String> line = new ArrayList<String>();  //创建辅助list line
		/*
		 * 将栈里的数据依次出栈，并将序列号转换成站名，放进list
		 */
		while(!stack.empty()){     //只要栈不空
			int e=stack.pop();     //出栈
			String name=new CDSubway().station_name.get(e); //调用CDSubway的静态变量station_name，根据序列号获取站名
			line.add(name);  //将站名加入list
		}
		String name=new CDSubway().station_name.get(end2); //通过之前保存的end2，获取目的地站名，因为end会变化
		line.add(name); //加入list
		System.out.print(line.get(0));
		//对线路上每一个站点进行遍历（从第二个站点开始，倒数第二个站点结束），判断与前后两个站点是否发生了换乘
		for(int i=1;i<line.size()-1;i++) {
			/*
			 * 之所以3个站点要一前一后一共四次调用transfer方法是因为一条路线有两个方向
			 * 如顺着走就是高新，火车南站，三瓦窑，逆着走就是三瓦窑，火车南站，高新
			 * 注，地铁并没有顺逆的方向，这里的顺逆是指的我的station_data文件中标注的顺序
			 */
			int x=transfer(line.get(i-1),line.get(i)); 
			int y=transfer(line.get(i),line.get(i-1)); 
			int x1=transfer(line.get(i),line.get(i+1));
			int y1=transfer(line.get(i+1),line.get(i));
			if(x<=0) {    //说明逆着走  
				x=y;
			}
			if(x1<=0) {   //说明逆着走
				x1=y1;
			}
			if(x==x1) {      //表示没换乘
				System.out.print("->"+line.get(i));
				num++;
			}
			else {           //表示换乘
				System.out.print("->"+line.get(i)+"(换乘"+num(x1)+")");
				num++;
			}
		}
		System.out.println("->"+line.get(line.size()-1));
		System.out.println("共"+num+"站");
	}
	/*
	 * 判断是否有换乘，如果有返回换乘线路的代号
	 */
	private int transfer(String n,String m) {
		int p=-1;
		int flag=0;    //循环结束标志
		int linenum=0; //线路代号
		for(List<String> line:new CDSubway().lineSet) { //对成都每条地铁线路进行遍历
			for(int i=0;i<line.size()-1;i++) {  //对该地铁线上的每个地铁站进行遍历
				/*
				 * 对两个地铁站n和m进行判断，判断是否为一条线上的相邻两站，
				 * 第一个条件是正常情况，即该线路不是环线
				 * 第二三个条件不是正常情况，即该路是环线
				 */
				if(n.equals(line.get(i).trim())&&m.equals(line.get(i+1).trim())|| //表示 n和 m 是一条线上的相邻站
				   n.equals(line.get(0).trim())&&m.equals(line.get(line.size()-1).trim())|| //表示n和m 是一条线上的头尾两站，环线上的头尾两站也是相邻站
				   m.equals(line.get(0).trim())&&n.equals(line.get(line.size()-1).trim())) { //同上，只不过方向不同
					p=linenum;   
					flag=1;
					break;
				}
			}
			if (flag==1) break;
			linenum++; //线路代号加1，表示换了令一条线路查找
		}
		return p;     //返回线路代号
	}
	//通过代号，找到换乘的线路
	public String num(int p) {
		String n=null;
		switch(p) {
		case 0:n=("1号线");break;
		case 1:n=("2号线");break;
		case 2:n=("3号线");break;
		case 3:n=("4号线");break;
		case 4:n=("7号线");break;
		case 5:n=("10号线");break;
		}
		return n;
	}
}
