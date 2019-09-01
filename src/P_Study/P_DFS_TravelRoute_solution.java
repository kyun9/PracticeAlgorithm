package P_Study;
 
import java.util.*;
 
class P_DFS_TravelRoute_solution {
	public static void main(String[] args) {
//		String[][] tickets = { { "ICN", "COO" }, { "COO", "ICN" },{ "COO", "ICN" } }; 
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = 	{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
		System.out.println(solution(tickets));
	}
    public static String[] solution(String[][] tickets) {
        // 출발지 초기화 //
        List<node2> nodeList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++)
            nodeList.add(new node2(tickets[i][0], tickets[i][1]));
 
        Collections.sort(nodeList, ((o1, o2) -> o1.departure.compareTo((o2.departure)) != 0
                ? o1.departure.compareTo((o2.departure)) : o1.destination.compareTo(o2.destination)));
        
        // ICN으로 시작된 출발점 설정 //
        List<node2> departures = new ArrayList<>();
        for (node2 node2 : nodeList)
            if(node2.departure.equals("ICN"))
                departures.add(node2);
        
        // DFS //
        for (node2 node2 : departures) {
            node2.index = 0;
            if(dfs(nodeList, node2, 1)) break;
        }

        return createArray(nodeList);
    }
 
    public static String[] createArray(List<node2> nodeList) {
        // index 순차적으로 값을 넣기 위해 //
        Collections.sort(nodeList, (o1, o2) -> o1.index > o2.index ? 1 : -1);
 
        String[] answer = new String[nodeList.size() + 1];
        answer[0] = nodeList.get(0).departure;
        answer[1] = nodeList.get(0).destination;
        for (int i = 1; i < nodeList.size(); i++)
            answer[i + 1] = nodeList.get(i).destination;
        
        return answer;
    }
 
    public static boolean dfs(List<node2> tickets, node2 departure, int idx) {
        boolean stop = false;
        if(idx == tickets.size())
            return true;
 
        for (node2 ticket : tickets) {
            if(ticket.index < 0 && departure.isAdjacent(ticket)) {
                ticket.index = idx;
                if((stop = dfs(tickets, ticket, idx + 1))) break;
            }
        }
 
        // 잘못된 경로 일 경우, 현재 경로는 취소하기 위한 로직 //
        if(!stop)
            departure.index = -1;
 
        return stop;
    }
 
}
class node2 {
	String departure;
	String destination;
	int index = -1;
	
	public node2(String departure, String destination) {
		this.departure = departure;
		this.destination = destination;
	}
	
	public boolean isAdjacent(node2 other) {
		return this.destination.equals(other.departure);
	}
}