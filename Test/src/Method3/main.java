package Method3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CDSubway cd= new CDSubway();
		System.out.println("��ӭʹ�óɶ�������ѯϵͳ������������Ҫ���еĲ���");
		System.out.println("��ѯһ�����ϵ�����վ�㣬�밴1");
		System.out.println("��ѯĳվ���������·���밴2");
		System.out.println("��ѯ����վ���������·���밴3");
		Scanner scan = new Scanner(System.in);
		String command =scan.next();
		while(!command.equals("exit")) {
			if(command.equals("1")) {
				System.out.println("�����������ѯ����·,��һ����");
				String line =scan.next();
				cd.searchline(line);
				System.out.println("������������е���������������exit�Ƴ���ϵͳ");
				command =scan.next();
			}
			else if(command.equals("2")) {
				System.out.println("�����������ѯ��վ��");
				String station =scan.next();
				cd.searchstation(station);
				System.out.println("������������е���������������exit�Ƴ���ϵͳ");
				command =scan.next();
			}
			else if(command.equals("3")) {
				System.out.println("�����������ѯ������վ��");
				String start =scan.next();
				String end =scan.next();
				cd.calc(cd.search(start), cd.search(end), CDSubway.graph);
				System.out.println("������������е���������������exit�Ƴ���ϵͳ");
				command =scan.next();
			}
			else {
				System.out.println("�Ҳ��������˼�أ���������ȷ������");
				System.out.println("������������е���������������exit�Ƴ���ϵͳ");
				command =scan.next();
			}
		}
		System.out.println("�ټ�������");
	}

}
