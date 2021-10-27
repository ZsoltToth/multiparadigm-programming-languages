package hu.ekcu.java.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Slf4j
@Service
public class ArraySplitterImpl implements ArraySplitter {

    @Override
    public Collection<ArraySlices> split(String[] array, int groupCount) {
        Collection<ArraySlices> result = new HashSet<>();
        result.addAll(split(array, groupCount, new ArraySlices()));
        return result;
    }

    /**
     * Overloaded method is hidden.
     * Recursion requires the prefix argument which is not part of the public method.
     * Public method wraps the private recursive implementation.
     *
     * @param array
     * @param groupCount
     * @param prefix
     * @return
     */
    private Collection<ArraySlices> split(String[] array, int groupCount, ArraySlices prefix){
//       log.info(String.format("Split: array %s", array));
        Collection<ArraySlices> result = new HashSet<>();
        if(groupCount == 0){
            if(array.length == 0 && prefix.validate()){
                result.add(prefix);
            }
            return result;
        }
        for(int i = 1; i < array.length; i++){
            if(!array[0].equals(array[i])){
                continue;
            }
            String[][] headAndTail = splitArrayAtIndex(array, i);
            String[] head = headAndTail[0];
            String[] tail = headAndTail[1];
            try {
                ArraySlices prefixExtended = prefix.clone();
                prefixExtended.getSlices().add(new ArraySlice(head));
                result.addAll(
                        split(tail, groupCount-1, prefixExtended)
                );
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


        }
        return result;
    }

    protected String[][] splitArrayAtIndex(String[] array, int index){
        String[] head = new String[index+1];
        String[] tail = new String[array.length - (index+1)];
        for(int i = 0; i < array.length; i++){
            if(i < head.length) {
                head[i] = array[i];
            }
            else{
                tail[i- head.length] = array[i];
            }
        }
        return new String[][] {head, tail};
    }
}
