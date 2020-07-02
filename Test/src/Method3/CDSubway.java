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
	static List<String> station_name=new ArrayList<String>();         //���ڴ洢���е�վ�����ƣ���138������station_name�ļ��л�ȡ
	/*
	 * ����������list�Ǵ洢վ����Ϣ�ģ��ֱ���վ�����ƣ�վ��������·���ƣ�վ���ڸ����ϵ����кţ���Ϊ���ã�����ʢ���ĺ���1վ��
	 * ����list �����ݴ�station.data�ļ��л�ȡ
	 * ����list����ͬλ�ô洢ͬһ��վ�����Ϣ����lstation_name.get(1)+lline_name.get(1)+lstation_num.get(1) �洢�ľ��ǵڶ���վ�����Ϣ
	 */
	static List<String> lstation_name=new ArrayList<String>(); 
	static List<String> lline_name=new ArrayList<String>();           
    static List<String> lstation_num=new ArrayList<String>();
    /*
     *     һ�����list���ֱ�洢һ���ߣ������ߣ������ߣ��ĺ��ߣ��ߺ��ߣ�ʮ���ߵ�վ������
     */
    public static List<String> line1 = new ArrayList<String>();
    public static List<String> line2 = new ArrayList<String>();
    public static List<String> line3 = new ArrayList<String>();
    public static List<String> line4 = new ArrayList<String>();
    public static List<String> line7 = new ArrayList<String>();
    public static List<String> line10 = new ArrayList<String>();
    
    public static Set<List<String>> lineSet = new LinkedHashSet<List<String>>(); //Set�������ڴ�����е�����·��list
	public static Graph graph = new Graph(138);   //�ɶ��ĵ�����·��,138�����е���վ�ĸ���
	
	public CDSubway() {   //���췽��������init()����
		init();
	}
	/*
	 *  search���������ڲ�ѯ վ����station_name�е����к�
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
			System.out.println(name+" "+"վ�㲻����");
			i=-1;
		}
		return i;
	}
	
	/*
	 * searchline
	 * ��ѯ��·�����е�վ��
	 */
	public static void searchline(String lname) {
		System.out.println(lname+"��ѯ�������");
		//int flag=0;
		switch(lname) {
    	case "һ����":System.out.println(line1);break;
    	case "������":System.out.println(line2);break;
    	case "������":System.out.println(line3);break;
    	case "�ĺ���":System.out.println(line4);break;
    	case "�ߺ���":System.out.println(line7);break;
    	case "ʮ����":System.out.println(line10);break;
    	default:System.out.println("��·������");break;
    	}
	}
	
	/*
	 * searchstation����
	 *   ��ѯվ���������·
	 */
	public static void searchstation(String sname) {
		int i=0;
		int flag=0;
		System.out.println(sname+":");
		for(List<String> line:lineSet) {
			for(String s:line) {
				if(s.equals(sname)) {
					switch(i) {
					case 0:System.out.println("1����");flag++;break;
					case 1:System.out.println("2����");flag++;break;
					case 2:System.out.println("3����");flag++;break;
					case 3:System.out.println("4����");flag++;break;
					case 4:System.out.println("7����");flag++;break;
					case 5:System.out.println("10����");flag++;break;
					}
				}
			}
			i++;
		}
		if(flag==0) {
			System.out.println("վ�㲻����");
		}
	}
	
	/*
	 * init()����
	 * ���ڴ����ɶ�������·��graph
	 */
	public static void init() {
		/*
		 * ��ȡstation_name.txt�ļ��е�վ�����ƣ����洢��station_name list��
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
		 * ��ȡstation_data.txt�ļ��е�վ����Ϣ
		 */
		try {
//            File file = new File("E:\\eclipse\\Test\\bin\\station_data.txt");
			File file = new File("src//method3//station_data.txt");
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"utf-8");
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
            	String[] sArray=line.split(",");  //��,Ϊ�ָ�������ÿһ�л���Ϊ�����ַ�������sArray��
            	//�������е������ַ����ֱ��Ž�����list�У��������list�е���ͬλ�ô�ŵĶ���һ��վ�����Ϣ
            	lstation_name.add(sArray[0].trim());     
            	lline_name.add(sArray[1].trim());
            	lstation_num.add(sArray[2].trim());
            	//��վ�㻮�ֵ����Ե�·���У�ͨ��sArray[1]���ж�
            	switch(sArray[1]) {
            	case "1":line1.add(sArray[0]);break;
            	case "2":line2.add(sArray[0]);break;
            	case "3":line3.add(sArray[0]);break;
            	case "4":line4.add(sArray[0]);break;
            	case "7":line7.add(sArray[0]);break;
            	case "10":line10.add(sArray[0]);break;
            	}
                line = br.readLine();  //��ȡ��һ�У�ֱ�����������ļ�
            }
            // whileѭ�����������е�վ����Ϣ����¼����ϣ����ڽ�������·list����֮ǰ������Set�����з������
            lineSet.add(line1);
            lineSet.add(line2);
            lineSet.add(line3);
            lineSet.add(line4);
            lineSet.add(line7);
            lineSet.add(line10);           
          } catch (Exception e) {
            e.printStackTrace();
        }
		int size=lstation_name.size();     //size��ʾ����վ����Ϣ�Ķ��٣���Ϊһ��վ������ж����Ϣ������ָ����վ����
		/*
		 * ��ĿǰΪֹ��graph��ֻ�н�㣬��û�бߣ����ڿ�ʼ�ӱ�
		 * ÿ�ζ�����վ����Ϣ���б������ж��Ƿ�Ҫ�ӱ�
		 * �ӱߵ�����������ͬһ��·���ϣ������к�����
		 * ��Ϊÿ��վ��һ������������һ����·�ϣ�������ʹ����תվҲ������ɼӱߣ�
		 * ��һƷ�����Ƕ����ߺ��ߺ��ߵ���תվ����ô��station_data.txt�о�������һƷ���µ���Ϣ���ֱ���һƷ����,2,9��һƷ����,7,1
		 * ����һƷ����վ��������ڽӵ㶼���ҵ�����Ȼ�Ϳ��Լӱ���
		 */
		for(int i=1;i<size;i++) {
				if((lline_name.get(i)).equals(lline_name.get(i-1))&&Integer.parseInt(lstation_num.get(i))==Integer.parseInt(lstation_num.get(i-1))+1) {
				int x=search(lstation_name.get(i));   //ͨ��search������ȡ��ǰվ����lstation_name�е����кţ���Ϊgraph�е�LinkedList���ڽӵ����飩��lstation_name �����к���һһ��Ӧ��
				int y=search(lstation_name.get(i-1)); //ͬ��
				graph.addEdge(x, y);    //���üӱ߷������мӱ�
			}
		}
	}
	
	public void calc(int start,int end,Graph graph){
		if(start<0||end<0) {
			return;
		}
		if(start==end) {
			System.out.println("��վ����ͬ");
			return;
		}
		int v=graph.getV();  //�õ��������
		LinkedList<Integer>[] adj=graph.getAdj();  //�õ����бߵ���Ϣ
		boolean[] visited = new boolean[v];        //������������
		visited[start] = true;         //���ó�ʼվ���ѱ����ʹ�
		Queue<Integer> queue = new LinkedList<>();     //������������
		queue.add(start);     
		int[] prev = new int[v];   //·�����飬��¼վ���ǰһ��վ�㣬��prev[q]=w,�ͱ�ʾ��Ҫ����q���ͱ����Ⱦ���w
		for(int i=0; i<v;i++) {    //��ʼ��Ϊ-1
			prev[i] = -1;
		}
		while(queue.size() != 0) {
			int w =queue.poll();
			for(int i=0; i<adj[w].size();++i) {   //����վ�� w �������ڽ�վ��
				int q = adj[w].get(i);     //ȡ�� w ���ڽ�վ��
				if(!visited[q]) {      //�ж��Ƿ���ʹ�
					prev[q] = w;         //����·������
					if(q == end) {       //������յ�ͽ���������print������ӡ·��
						print(prev,start,end);  
						return;
					}
					visited[q] = true;  //�������Ŀ�ĵأ�������Ϊ�ѷ��ʹ��� 
					queue.add(q);      //�ڽ�վ�����
				}
			}
		}
	}
	private void print(int[] prev, int start,int end) {
		int end2=end;    //��end��ֵ��end2��֮����õ�
		int num=1;       //���ڼ�¼������վ������ֵΪ1
		Stack<Integer> stack=new Stack<Integer>(); //��������ջ
		/*
		 * ���ν�·�������е�ֵ��ջ������ջ����ȳ�������
		 * ѭ������1��prev[end]!=-1 ��ʾ�Ѿ��ҵ�����ȷ·�ߣ�
		 * ѭ������2��start!=end����ʾ�Ѿ�ȫ��ѹջ���
		 */
		while(prev[end]!=-1&&start!=end){  
			stack.push(prev[end]);  //Ŀ�ĵص�ǰһ��վ����ջ
			end=prev[end];          //��Ŀ�ĵ���ΪĿ�ĵص�ǰһ��վ�㣬����ѭ����ȥ������end=start ����ѭ��
		}
		List<String> line = new ArrayList<String>();  //��������list line
		/*
		 * ��ջ����������γ�ջ���������к�ת����վ�����Ž�list
		 */
		while(!stack.empty()){     //ֻҪջ����
			int e=stack.pop();     //��ջ
			String name=new CDSubway().station_name.get(e); //����CDSubway�ľ�̬����station_name���������кŻ�ȡվ��
			line.add(name);  //��վ������list
		}
		String name=new CDSubway().station_name.get(end2); //ͨ��֮ǰ�����end2����ȡĿ�ĵ�վ������Ϊend��仯
		line.add(name); //����list
		System.out.print(line.get(0));
		//����·��ÿһ��վ����б������ӵڶ���վ�㿪ʼ�������ڶ���վ����������ж���ǰ������վ���Ƿ����˻���
		for(int i=1;i<line.size()-1;i++) {
			/*
			 * ֮����3��վ��Ҫһǰһ��һ���Ĵε���transfer��������Ϊһ��·������������
			 * ��˳���߾��Ǹ��£�����վ������Ҥ�������߾�������Ҥ������վ������
			 * ע��������û��˳��ķ��������˳����ָ���ҵ�station_data�ļ��б�ע��˳��
			 */
			int x=transfer(line.get(i-1),line.get(i)); 
			int y=transfer(line.get(i),line.get(i-1)); 
			int x1=transfer(line.get(i),line.get(i+1));
			int y1=transfer(line.get(i+1),line.get(i));
			if(x<=0) {    //˵��������  
				x=y;
			}
			if(x1<=0) {   //˵��������
				x1=y1;
			}
			if(x==x1) {      //��ʾû����
				System.out.print("->"+line.get(i));
				num++;
			}
			else {           //��ʾ����
				System.out.print("->"+line.get(i)+"(����"+num(x1)+")");
				num++;
			}
		}
		System.out.println("->"+line.get(line.size()-1));
		System.out.println("��"+num+"վ");
	}
	/*
	 * �ж��Ƿ��л��ˣ�����з��ػ�����·�Ĵ���
	 */
	private int transfer(String n,String m) {
		int p=-1;
		int flag=0;    //ѭ��������־
		int linenum=0; //��·����
		for(List<String> line:new CDSubway().lineSet) { //�Գɶ�ÿ��������·���б���
			for(int i=0;i<line.size()-1;i++) {  //�Ըõ������ϵ�ÿ������վ���б���
				/*
				 * ����������վn��m�����жϣ��ж��Ƿ�Ϊһ�����ϵ�������վ��
				 * ��һ�����������������������·���ǻ���
				 * �ڶ��������������������������·�ǻ���
				 */
				if(n.equals(line.get(i).trim())&&m.equals(line.get(i+1).trim())|| //��ʾ n�� m ��һ�����ϵ�����վ
				   n.equals(line.get(0).trim())&&m.equals(line.get(line.size()-1).trim())|| //��ʾn��m ��һ�����ϵ�ͷβ��վ�������ϵ�ͷβ��վҲ������վ
				   m.equals(line.get(0).trim())&&n.equals(line.get(line.size()-1).trim())) { //ͬ�ϣ�ֻ��������ͬ
					p=linenum;   
					flag=1;
					break;
				}
			}
			if (flag==1) break;
			linenum++; //��·���ż�1����ʾ������һ����·����
		}
		return p;     //������·����
	}
	//ͨ�����ţ��ҵ����˵���·
	public String num(int p) {
		String n=null;
		switch(p) {
		case 0:n=("1����");break;
		case 1:n=("2����");break;
		case 2:n=("3����");break;
		case 3:n=("4����");break;
		case 4:n=("7����");break;
		case 5:n=("10����");break;
		}
		return n;
	}
}
