package Method3;

import java.util.LinkedList;

public class Graph {
	public int num;                     //�������
	/*
	 * LinkedList<Integer> adj[]
	 * һ�����list�����飬����list�д�ŵ��Ƕ�Ӧ�ڵ�������ڽӵ���Ϣ,
	 * ��adj[1]�洢�ľ������к�Ϊ1��վ��������ڽӵ���Ϣ,Ҳ�������Ϊ�洢���еı�
	 */
	public LinkedList<Integer> adj[];  
	/*
	 * ͼ�Ĺ��췽��������������v
	 * ������ʵ����������ÿ�������е�ÿ��list��ʵ����
	 */
	public Graph(int v){               
		num = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList<>();
		}
	}
	/*
	 * ͼ�ļӱ߷��������������s��t�����߶��ǽ������к�
	 *��Ϊ������ͼ�����Զ��ߵ��ڽӵ�list��Ҫ�洢�Է�����Ϣ
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