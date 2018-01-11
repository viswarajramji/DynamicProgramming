import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WeightScheduling {
	int start;
	int end;
	int profit;

	WeightScheduling(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}
	
  public static void main(String args[])
  {
	  List<WeightScheduling> list=new ArrayList<WeightScheduling>();
	  WeightScheduling w1=new WeightScheduling(1,3,5);
	  WeightScheduling w2=new WeightScheduling(2,5,6);
	  WeightScheduling w3=new WeightScheduling(4,6,5);
	  WeightScheduling w4=new WeightScheduling(6,7,4);
	  WeightScheduling w5=new WeightScheduling(5,8,11);
	  WeightScheduling w6=new WeightScheduling(7,9,2);
	  list.add(w1);
	  list.add(w2);
	  list.add(w3);
	  list.add(w4);
	  list.add(w5);
	  list.add(w6);
	  Collections.sort(list,new sortByEndTime());
	  System.out.println(printMaxValue(list));
	  
  }
  
	public static int printMaxValue(List<WeightScheduling> ws) {
		int temp[] = new int[ws.size()];
		temp[0] = ws.get(0).profit;
		for (int i = 1; i < ws.size(); i++) {
			temp[i] = Math.max(ws.get(i).profit, temp[i - 1]);
			for (int j = i - 1; j >= 0; j--) {
				if (ws.get(i).start >= ws.get(j).end) {
					temp[i] = Math.max(ws.get(i).profit + temp[j], temp[i]);
					break;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}
}

class sortByEndTime implements Comparator<WeightScheduling>
{

	@Override
	public int compare(WeightScheduling o1, WeightScheduling o2) {
		if (o1.end > o1.end)
			return -1;
		else
			return 1;

	}

}
