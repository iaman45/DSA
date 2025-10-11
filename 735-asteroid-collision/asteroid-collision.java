import java.util.Stack;
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i:asteroids)
        {
            boolean check=true;
            while(!st.isEmpty() && i<0 && st.peek()>0)
            {
                if(Math.abs(i)>st.peek())
                {
                    st.pop();
                }
                else if(Math.abs(i)==st.peek())
                {
                    check=false;
                    st.pop();
                    break;
                }
                else 
                {
                    check=false;
                    break;
                }
            }
            if(check) st.push(i);
        }
     int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }
}