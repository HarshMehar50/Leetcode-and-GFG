/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        List<Integer> ids = new ArrayList<>();
        for(int i = 0; i < employees.size(); i++){
            ids.add(employees.get(i).id);
        }
        int index = 0;
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).id == id)
            index = i;
        }
        Queue<Employee> q = new LinkedList<>();
        q.offer(employees.get(index));
        int s = 0;
        while(!q.isEmpty()){
            int l = q.size();
            Employee c = q.poll();
            s += c.importance;
            for(int i = 0; i < c.subordinates.size(); i++){
                int j = ids.indexOf(c.subordinates.get(i));
                q.offer(employees.get(j));
            }
        }
        return s;
    }
}