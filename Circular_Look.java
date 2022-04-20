import java.util.ArrayList;
import java.util.Collections;

public class Circular_Look {
    ArrayList<Integer> data ;
    int head ;
    int numberOfData ;

    public Circular_Look ( ArrayList<Integer> data, int head, int numberOfData  ) {
        this.data = data;
        this.head = head;
        this.numberOfData = numberOfData;
    }

    public ArrayList<Integer> getData () {
        return data;
    }

    public void setData ( ArrayList<Integer> data ) {
        this.data = data;
    }

    public int getHead () {
        return head;
    }

    public void setHead ( int head ) {
        this.head = head;
    }

    public int getNumberOfData () {
        return numberOfData;
    }

    public void setNumberOfData ( int numberOfData ) {
        this.numberOfData = numberOfData;
    }

    public int implementation(ArrayList<Integer> path)
    {
        Collections.sort ( data );
        int start = 0 ;
        for ( int i = 0 ; i < numberOfData ; i++ ) {
            if(data.get ( i ) <= head)
            {
                start =  i ;
            }
        }
        int pointer = head;
        for ( int i = start+1 ; i < numberOfData  ; i++ ) {
            path.add ( pointer );
            pointer = data.get ( i );
        }
        pointer = data.get ( 0 ) ;
        for ( int i = 1 ; i <= start ; i++ ) {
            path.add ( pointer );
            pointer = data.get ( i );
        }
        path.add ( pointer );
        return data.get ( data.size ()-1 ) - head +
                data.get ( data.size ()-1 ) - data.get ( 0 )+
                data.get ( start );
    }

}
