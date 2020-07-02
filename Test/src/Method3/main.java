package Method3;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CDSubway cd= new CDSubway();
		System.out.println("欢迎使用成都地铁查询系统，请输入你想要进行的操作");
		System.out.println("查询一条线上的所有站点，请按1");
		System.out.println("查询某站点的所在线路，请按2");
		System.out.println("查询两个站点间的最短线路，请按3");
		Scanner scan = new Scanner(System.in);
		String command =scan.next();
		while(!command.equals("exit")) {
			if(command.equals("1")) {
				System.out.println("请输入你想查询的线路,例一号线");
				String line =scan.next();
				cd.searchline(line);
				System.out.println("请输入你想进行的其他操作，输入exit推出本系统");
				command =scan.next();
			}
			else if(command.equals("2")) {
				System.out.println("请输入你想查询的站点");
				String station =scan.next();
				cd.searchstation(station);
				System.out.println("请输入你想进行的其他操作，输入exit推出本系统");
				command =scan.next();
			}
			else if(command.equals("3")) {
				System.out.println("请输入你想查询的两个站点");
				String start =scan.next();
				String end =scan.next();
				cd.calc(cd.search(start), cd.search(end), CDSubway.graph);
				System.out.println("请输入你想进行的其他操作，输入exit推出本系统");
				command =scan.next();
			}
			else {
				System.out.println("我不懂你的意思呢，请输入正确的命令");
				System.out.println("请输入你想进行的其他操作，输入exit推出本系统");
				command =scan.next();
			}
		}
		System.out.println("再见！！！");
	}

}
