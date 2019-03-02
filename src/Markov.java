import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Markov<T>
{
    private HashMap<T, ArrayList<T>> map;

    public Markov()
    {
        map = new HashMap<>();
        map.put(null, new ArrayList<>());
    }

    public void add(T... chain)
    {
        map.get(null).add(chain[0]);

        for(int x=0;x<chain.length;x++)
        {
            T cur = chain[x];

            if(!map.containsKey(cur)) map.put(cur, new ArrayList<>());

            List<T> next = map.get(cur);

            if(x!=chain.length-1) next.add(chain[x+1]);
            else next.add(null);
        }
    }

    public List<T> generate()
    {
        if(map.get(null).size()>0)
        {
            List<T> out = new ArrayList<>();

            T cur = getNext(null);
            while(cur!=null)
            {
                out.add(cur);
                cur = getNext(cur);
            }
            return out;
        }
        return null;
    }

    private T getNext(T cur)
    {
        List<T> next = map.get(cur);
        return next.get((int) (Math.random() * next.size()));
    }
}














