package Method3;

import java.util.LinkedList;

public class Graph {
	public int num;                     //结点总数
	/*
	 * LinkedList<Integer> adj[]
	 * 一个存放list的数组，其中list中存放的是对应节点的所有邻接点信息,
	 * 如adj[1]存储的就是序列号为1的站点的所有邻接点信息,也可以理解为存储所有的边
	 */
	public LinkedList<Integer> adj[];  
	/*
	 * 图的构造方法，传入结点总数v
	 * 将数组实例化，并将每个数组中的每个list都实例化
	 */
	public Graph(int v){               
		num = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}
	/*
	 * 图的加边方法，传入参数，s和t，二者都是结点的序列号
	 *因为是无向图，所以二者的邻接点list都要存储对方的信息
	 */
	public void addEdge(int s,int t) {
		adj[s].add(t);
		adj[t].add(s);
	}
	public int getV() {
		return num;
	}
	public void setV(int v) {
		this.num = v;
	}
	public LinkedList<Integer>[] getAdj() {
		return adj;
	}
	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}
}